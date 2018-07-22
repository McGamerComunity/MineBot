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

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import util.STATIC;

import java.awt.*;
import java.io.IOException;
import java.text.ParseException;

public class Prefix implements commands {
    private static Guild guild;

    public void sendErrorMsg(MessageReceivedEvent event, String content) {
        event.getTextChannel().sendMessage(
                new EmbedBuilder()
                        .setColor(Color.red)
                        .setDescription(content)
                        .build()
        ).queue();
    }

    @java.lang.Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @java.lang.Override
    public void action(String[] args, MessageReceivedEvent event) {

        guild = event.getGuild();
        if(args.length < 0) {
            sendErrorMsg(event,(help()));
            return;
        }




    }

    @java.lang.Override
    public void executet(boolean sucess, MessageReceivedEvent event) {

    }

    @java.lang.Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }

    @java.lang.Override
    public String help() {
        return null;
    }

    @java.lang.Override
    public String description() {
        return null;
    }

    @java.lang.Override
    public String commandType() {
        return null;
    }

    @java.lang.Override
    public int permission() {
        return 0;
    }
}
