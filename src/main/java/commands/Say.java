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
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import util.STATIC;

import java.awt.*;

public class Say implements commands {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {

        String msg = String.join(" ", args);
        User author = event.getMessage().getAuthor();

        event.getTextChannel().sendMessage(new EmbedBuilder()
                .setColor(new Color(0x7DFFEB))
                .setAuthor(author.getName(), null, author.getAvatarUrl())
                .setDescription(msg)
                .build()
        ).queue();
    }

    @Override
    public void executet(boolean sucess, MessageReceivedEvent event) {

    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return "USAGE: mb say <message>";
    }

    @Override
    public String description() {
        return "send messsages with the bot";
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
