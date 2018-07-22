/**
 .___  ___.   ______   _______      ___      .___  ___.  _______ .______
 |   \/   |  /      | /  _____|    /   \     |   \/   | |   ____||   _  \
 |  \  /  | |  ,----'|  |  __     /  ^  \    |  \  /  | |  |__   |  |_)  |
 |  |\/|  | |  |     |  | |_ |   /  /_\  \   |  |\/|  | |   __|  |      /
 |  |  |  | |  `----.|  |__| |  /  _____  \  |  |  |  | |  |____ |  |\  \----.
 |__|  |__|  \______| \______| /__/     \__\ |__|  |__| |_______|| _| `._____|

 (c) 2014-2018
 */

package commands;

import commands.commands;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.*;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.exceptions.PermissionException;
import net.dv8tion.jda.core.managers.GuildController;
import util.MSGS;
import util.MSGS;
import util.STATIC;

import java.awt.*;
import java.util.*;

public class BJoke implements commands {

    Timer timer = new Timer();
    Timer countdown = new Timer();
    Member victim = null;
    int count = 10;

    private void countdownMessage(Message message) {
        count--;
        if (count < 0)
            count = 0;
        message.editMessage("**COUNTDONW:  `" + count + "`**").queue();
    }

    public boolean called(String[] args, MessageReceivedEvent event) {

        return false;
    }

    public void action(String[] args, final MessageReceivedEvent event) {


        if (args[0].toLowerCase().equals("c")) {

            if (victim == null) {
                event.getTextChannel().sendMessage(MSGS.error().setDescription("There is currently no victim to save. :^)").build()).queue();
                return;
            }

            if (event.getMember().equals(victim)) {
                event.getTextChannel().sendMessage(MSGS.error().setDescription("Sorry, " + event.getAuthor().getAsMention() + ", you can't free yourself from your fate...").build()).queue();
                return;
            }

            timer.cancel();
            timer = new Timer();
            countdown.cancel();
            countdown = new Timer();
            count = 10;
            event.getTextChannel().sendMessage(MSGS.success().setDescription("You had luck, " + victim.getAsMention() + ". " + event.getAuthor().getAsMention() + " freed you from the kick.").build()).queue();
            victim = null;
            return;
        }

        try {
            victim = event.getGuild().getMember(event.getMessage().getMentionedUsers().get(0));
        } catch (Exception e) {
            event.getTextChannel().sendMessage(MSGS.error().setDescription(help()).build()).queue();
            return;
        }

        event.getTextChannel().sendMessage(new EmbedBuilder().setColor(new Color(0xFF6100)).setDescription(
                "Because " + victim.getAsMention() + " throwed a bad joke, he will be kicked out of the channel in 10 seconds if no one types `mb bj c` to free " + victim.getAsMention() + "."
        ).build()).queue();

        Message cdMessage = event.getTextChannel().sendMessage("**COUNTDONW:  `10`**").complete();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    event.getGuild().getController().moveVoiceMember(victim, event.getGuild().getAfkChannel()).queue();
                } catch (Exception e) {
                    util.Messages.error(event.getTextChannel(), "Can not kick a user witch is not in any voice channel.");
                }
                countdown.cancel();
                countdown = new Timer();
                count = 10;

                if (count == 0) {
                    victim = null;
                    event.getTextChannel().sendMessage(new EmbedBuilder().setColor(new Color(0xFF0002)).setDescription(
                            victim.getAsMention() + " was kicked out of the channel."
                    ).build()).queue();
                }
            }
        }, 10*1000);

        countdown.schedule(new TimerTask() {
            @Override
            public void run() {
                countdownMessage(cdMessage);
            }
        }, 0, 1000);


    }

    @Override
    public void executet(boolean sucess, MessageReceivedEvent event) {

    }

    public void executed(boolean success, MessageReceivedEvent event) {

    }

    public String help() {
        return "USAGE:\n" +
                "**bjoke <@mention>**  -  `Kicks a member out of the voice channel because of a bad joke after 10 seconds counter`\n" +
                "**bjoke c**  -  `If someone laughed he can cancel the bad joke kick`";
    }

    @Override
    public String description() {
        return "Kick someone out of the voice channel after a bad joke";
    }

    @Override
    public String commandType() {
        return STATIC.CMDTYPE.chatutils;
    }

    @Override
    public int permission() {
        return 0;
    }
}