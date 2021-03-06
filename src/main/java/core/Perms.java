/**
 .___  ___.   ______   _______      ___      .___  ___.  _______ .______
 |   \/   |  /      | /  _____|    /   \     |   \/   | |   ____||   _  \
 |  \  /  | |  ,----'|  |  __     /  ^  \    |  \  /  | |  |__   |  |_)  |
 |  |\/|  | |  |     |  | |_ |   /  /_\  \   |  |\/|  | |   __|  |      /
 |  |  |  | |  `----.|  |__| |  /  _____  \  |  |  |  | |  |____ |  |\  \----.
 |__|  |__|  \______| \______| /__/     \__\ |__|  |__| |_______|| _| `._____|

 (c) 2014-2018
 */


package core;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import util.MSGS;
import util.STATIC;

import java.awt.*;
import java.util.Arrays;


public class Perms {

    private JDA jda;


    public static String errmsg = ":warning: You don't have enaugh permissions to execute this command";

    public static boolean isHost(User user) {
        return user.getId() == STATIC.BOT_OWNER_ID;
    }
    public static boolean isSelfUser(User user) {
        return user.getId().contains("459368359977418775");
    }

    public static boolean isOwner(User user, TextChannel channel) {
        if (STATIC.BOT_OWNER_ID == null) {
            channel.sendMessage(MSGS.error().setDescription("There is no owner ID set in `SETTINGS.txt`.\nIf you are the owner of this bot, please add your Discord user id in the `SETTINGS.txt`!").build()).queue();
            return false;
        }
        if (user.getId().equals(String.valueOf(STATIC.BOT_OWNER_ID)))
            return true;
        channel.sendMessage(MSGS.error().setDescription("Only the bots owner (" + user.getJDA().getUserById(STATIC.BOT_OWNER_ID).getAsMention() + ") can use this command.").build()).queue();
        return false;

    }

    public static int getLvl(Member member) {

        if (isSelfUser(member.getUser())){
            return 10000;
        }

        if (member.getUser().getId().equalsIgnoreCase("273115881960374272")) {
            return 1000;
        }
        if (member.equals(member.getGuild().getOwner())) {
            return 50;
        }

        if (member.getRoles().stream().anyMatch(role -> Arrays.stream(STATIC.PERMSALL).anyMatch(sall -> role.getName().equals(sall)))) {
            return 10;
        }
        if (member.getRoles().stream().anyMatch(role -> Arrays.stream(STATIC.PERMS).anyMatch(s5 -> role.getName().equals(s5)))) {
            return 5;
        }
        else if (member.getRoles().stream().anyMatch(role -> Arrays.stream(STATIC.PERMSA).anyMatch(s4 -> role.getName().equals(s4)))) {
            return 4;
        }
        else if (member.getRoles().stream().anyMatch(role -> Arrays.stream(STATIC.PERMSB).anyMatch(s3 -> role.getName().equals(s3)))) {
            return 3;
        }
        else if (member.getRoles().stream().anyMatch(role -> Arrays.stream(STATIC.PERMSC).anyMatch(s2 -> role.getName().equals(s2)))) {
            return 2;
        }
        else if (member.getRoles().stream().anyMatch(role -> Arrays.stream(STATIC.PERMSD).anyMatch(s1 -> role.getName().equals(s1)))) {
            return 1;
        } else {
            return 0;
        }
    }

    public static boolean check(int required, MessageReceivedEvent event) {
        if (required > getLvl(event.getMember())) {
            event.getTextChannel().sendMessage(new EmbedBuilder().setColor(Color.red).setDescription(
                    "Sorry but you need permission level `" + required + "` or above!\n(Your current permission level is `" + getLvl(event.getMember()) + "`)."
            ).build()).queue();
            return true;
        }
        return false;
    }

    //public static boolean test(MessageReceivedEvent event) {
    //
    //    boolean userNotPermitted = true;
    //    for ( Role r : event.getGuild().getMember(event.getAuthor()).getRoles() ) {
    //        if (Arrays.stream(STATICS.botPermRoles).parallel().anyMatch(r.getName()::contains))
    //            userNotPermitted = false;
    //    }
    //
    //    StringBuilder sb = new StringBuilder();
    //    Arrays.stream(STATICS.botPermRoles).forEach(s -> sb.append(s + ", "));
    //    EmbedBuilder eb = MSGS.error
    //            .addField("Error Type", "Missing permissions.", false)
    //            .addField("Description", "You need at least one of the following roles to access that command:\n" + sb.toString().substring(0, sb.toString().length() - 2), false);
    //
    //    if (userNotPermitted) event.getTextChannel().sendMessage(eb.build()).queue();
    //
    //    return userNotPermitted;
    //}

}