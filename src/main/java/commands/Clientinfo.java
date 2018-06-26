package commands;

import core.Perms;
import net.dv8tion.jda.client.managers.EmoteManager;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Emote;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import util.MSGS;
import util.STATIC;

import java.awt.*;
import java.io.IOException;
import java.text.ParseException;
import java.time.OffsetDateTime;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Clientinfo implements commands {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {


        if (args.length < 2) {
            event.getTextChannel().sendMessage(MSGS.error().setDescription(help()).build()).queue();
            return;
        }

        if (args.length <0) {
            event.getTextChannel().sendMessage(MSGS.error().setDescription(help()).build()).queue();
            return;
        }

        User User = event.getMessage().getMentionedUsers().get(0);
        Member Member = event.getMessage().getMentionedMembers().get(0);
        OffsetDateTime jd = Member.getJoinDate();
        Color cl = Member.getColor();
        String vchan;
        String avatarurl;
        String avatarid;
        String game;

        switch (args[1].toLowerCase()) {

            case "--all":

                if (Member.getVoiceState().getChannel().getName().isEmpty()) {
                    vchan = "none";
                } else {
                    vchan = Member.getVoiceState().getChannel().getName();
                }

                if (User.getAvatarUrl().isEmpty()){
                    avatarurl = User.getDefaultAvatarUrl();
                } else {
                    avatarurl = User.getAvatarUrl();
                }

                if (User.getAvatarId().isEmpty()) {
                    avatarid = User.getDefaultAvatarUrl();
                } else {
                    avatarid = User.getAvatarId();
                }

                if (Member.getGame().getName().isEmpty()) {
                    game = "none";
                } else {
                    game = Member.getGame().getName();
                }

            Message msg = event.getTextChannel().sendMessage(new EmbedBuilder()
                    .setColor(new Color((int)(Math.random() * 0x1000000)))
                    .setAuthor(User.getName() + "'s Clientinformation", null, User.getDefaultAvatarUrl())
                    .setThumbnail(User.getAvatarUrl())
                    .addField("Full Name:", "`" + User.getName() + "#" + User.getDiscriminator() + "`", false)
                    .addField("Discriminator:", User.getDiscriminator(), false)
                    .addField("Mention:", User.getAsMention(), false)
                    .addField("Avatar ID:", avatarid, false)
                    .addField("Avatar URL:", avatarurl, false)
                    .addField("Default Avatar ID:", User.getDefaultAvatarId(), false)
                    .addField("Default Avatar URL:", User.getDefaultAvatarUrl(), false)
                    .addField("Effective Avatar Url:", User.getEffectiveAvatarUrl(), false)
                    .addField("Onlinestatus", Member.getOnlineStatus().toString(), false)
                    .addField("Joindate:", jd.getYear() + " - " + jd.getMonth() + " - "  + jd.getDayOfWeek() + " | " +jd.getHour() + ":" + jd.getMinute() + ":" + jd.getSecond() , false)
                    .addField("Game:", game, false)
                    .addField("Voicechannel:", vchan, false)
                    .addField("Name Color:", "red: `" + cl.getRed() + "` green: `" + cl.getGreen() + "` blue: `" + cl.getBlue() + "` alpha: `" + cl.getAlpha() + "`", false)
                    .addField("UserID:", User.getId(), false)
                    //.addField("Permission Level",Perms.getLvl(Member), false)
                    .addField("Is Owner:", String.valueOf(Member.isOwner()), false)
                    .addField("Is Bot:", String.valueOf(User.isBot()), false)
                    .build()).complete();

            case "--noagv":
                Message msgs = event.getTextChannel().sendMessage(new EmbedBuilder()
                        .setColor(new Color((int)(Math.random() * 0x1000000)))
                        .setAuthor(User.getName() + "'s Clientinformation", null, User.getDefaultAvatarUrl())
                        .setThumbnail(User.getDefaultAvatarUrl())
                        .addField("Full Name:", "`" + User.getName() + "#" + User.getDiscriminator() + "`", false)
                        .addField("Discriminator:", User.getDiscriminator(), false)
                        .addField("Mention:", User.getAsMention(), false)
                        .addField("Default Avatar ID:", User.getDefaultAvatarId(), false)
                        .addField("Default Avatar URL:", User.getDefaultAvatarUrl(), false)
                        .addField("Effective Avatar Url:", User.getEffectiveAvatarUrl(), false)
                        .addField("Onlinestatus", Member.getOnlineStatus().toString(), false)
                        .addField("Joindate:", jd.getYear() + " - " + jd.getMonth() + " - "  + jd.getDayOfWeek() + " | " +jd.getHour() + ":" + jd.getMinute() + ":" + jd.getSecond() , false)
                        .addField("Name Color:", "red: `" + cl.getRed() + "` green: `" + cl.getGreen() + "` blue: `" + cl.getBlue() + "` alpha: `" + cl.getAlpha() + "`", false)
                        .addField("UserID:", User.getId(), false)
                        //.addField("Permission Level",Perms.getLvl(Member), false)
                        .addField("Is Owner:", String.valueOf(Member.isOwner()), false)
                        .addField("Is Bot:", String.valueOf(User.isBot()), false)
                        .build()).complete();
        }
    }



    @Override
    public void executet(boolean sucess, MessageReceivedEvent event) {

    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return "USAGE:\n" +
                "mb cinfo <@mention> <--noagv/--all>";
    }

    @Override
    public String description() {
        return null;
    }

    @Override
    public String commandType() {
        return null;
    }

    @Override
    public int permission() {
        return 0;
    }
}
