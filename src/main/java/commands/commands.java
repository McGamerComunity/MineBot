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

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.io.IOException;
import java.text.ParseException;


public interface commands {
    boolean called(String[] args, MessageReceivedEvent event);
    void action(String[] args, MessageReceivedEvent event) throws IOException, ParseException;
    void executet(boolean sucess, MessageReceivedEvent event);

    void executed(boolean success, MessageReceivedEvent event);

    String help();

    String description();

    String commandType();

    int permission();
}
