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
import commands.*;
import core.Botstart;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.PrivateChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import util.STATIC;

import java.awt.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Ping implements commands {

    private final String HELP = "USAGE: ~ping";

    private static long inputTime;

    public static void setInputTime(long inputTimeLong) {
        inputTime = inputTimeLong;
    }

    private Color getColorByPing(long ping) {
        if (ping < 100)
            return Color.cyan;
        if (ping < 400)
            return Color.green;
        if (ping < 700)
            return Color.yellow;
        if (ping < 1000)
            return Color.orange;
        return Color.red;
    }



    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    public void action(String[] args, MessageReceivedEvent event) {
        long processing = new Date().getTime() - inputTime;
        long ping = event.getJDA().getPing();
        event.getTextChannel().sendMessage(new EmbedBuilder().setColor(getColorByPing(ping)).setDescription(
                String.format(":ping_pong:   **Pong!**\n\nThe bot took `%s` milliseconds to response.\nIt took `%s` milliseconds to parse the command and the ping is `%s` milliseconds.",
                        processing + ping, processing, ping)
        ).build()).queue();
    }

    @Override
    public void executet(boolean sucess, MessageReceivedEvent event) {

    }

    public void executed(boolean success, MessageReceivedEvent event) {

    }

    public String help() {

        return HELP;
    }

    @Override
    public String description() {
        return "Pong!";
    }

    @Override
    public String commandType() {
        return STATIC.CMDTYPE.essentials;
    }

    @Override
    public int permission() {
        return 0;
    }


}
