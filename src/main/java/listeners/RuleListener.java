/**
 .___  ___.   ______   _______      ___      .___  ___.  _______ .______
 |   \/   |  /      | /  _____|    /   \     |   \/   | |   ____||   _  \
 |  \  /  | |  ,----'|  |  __     /  ^  \    |  \  /  | |  |__   |  |_)  |
 |  |\/|  | |  |     |  | |_ |   /  /_\  \   |  |\/|  | |   __|  |      /
 |  |  |  | |  `----.|  |__| |  /  _____  \  |  |  |  | |  |____ |  |\  \----.
 |__|  |__|  \______| \______| /__/     \__\ |__|  |__| |_______|| _| `._____|

 (c) 2014-2018
 */


package listeners;

import net.dv8tion.jda.client.events.call.CallCreateEvent;
import net.dv8tion.jda.core.entities.ChannelType;
import net.dv8tion.jda.core.entities.PrivateChannel;
import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.core.events.message.react.MessageReactionRemoveEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import util.STATIC;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class RuleListener extends ListenerAdapter {


    @Override
    public void onMessageReactionAdd(MessageReactionAddEvent event) {
        String msg = event.getReactionEmote().getName();
        String chan = event.getTextChannel().getName();
        System.out.println("[RuleListener] " + event.getMember().getUser().getName() + " reactet in " + event.getTextChannel().getName() + " with " + msg);
        PrivateChannel pc = event.getMember().getUser().openPrivateChannel().complete();
        String[] player = {"Spieler"};
        Boolean roles = event.getMember().getRoles().stream().anyMatch(role -> Arrays.stream(player).anyMatch(s1 -> role.getName().equals(s1)));

        if (roles == false) {
            if (chan.contains("rules-regeln")) {
                if (msg.contains("✅")) {
                    pc.sendMessage("You acceptet the rules and get the Spieler rank\n" +
                            "have fun on this server ;)\n\n" +
                            "if you want to register use the following command: `mb register` in any textchannel you want")
                            .queue();
                    event.getGuild().getController().addRolesToMember(event.getMember(), event.getGuild().getRolesByName("Spieler", true)).queue();
                    System.out.println("[RuleListener] " + event.getMember().getUser().getName() + " acceptet the rules");
                    event.getReaction().removeReaction(event.getUser()).queue();
                } else if (msg.contains("❌")) {
                    pc.sendMessage("You had to accept the rules\nyou can rejoin the server with this link:\nhttps://discord.gg/" + STATIC.DISCORD).queue();
                    event.getGuild().getController().kick(event.getUser().getId()).queue();
                    System.out.println("[RuleListener] " + event.getMember().getUser().getName() + " declined the rules");
                    event.getReaction().removeReaction(event.getUser()).queue();
                }
            }
        } else {

            if (roles == true) {
                if (event.getChannelType() == ChannelType.PRIVATE) {
                    if (msg.contains("✅")) {

                        event.getReaction().removeReaction(event.getUser()).queue();
                    } else if (msg.contains("❌")) {

                        event.getReaction().removeReaction(event.getUser()).queue();
                    }
                }
            }
        }

        if (event.getChannelType() == ChannelType.PRIVATE) {

            if (msg.contains("✅")) {

            }

        }

    }
}
