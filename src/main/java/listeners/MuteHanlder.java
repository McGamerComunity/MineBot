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

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import util.MSGS;
import util.STATIC;

import java.awt.Color;
import java.util.HashMap;


public class MuteHanlder extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent e) {

        User sender = e.getAuthor();
        HashMap<String, String> mutes = commands.Mute.getMuted();

        if (mutes.containsKey(sender.getId())) {
            e.getMessage().getJDA().getTextChannelsByName("mutelog", false).get(0).sendMessage(MSGS.error()
                    .setAuthor(e.getMember().getUser().getName() + "#" + e.getMember().getUser().getDiscriminator(), STATIC.userlink(e.getMember().getUser().getId(), e.getMember().getUser().getName()), e.getMember().getUser().getEffectiveAvatarUrl())
                    .addField("Guild:", e.getGuild().getName(), true)
                    .addField("Textchannel", e.getTextChannel().getName(), true)
                    .addField("Message:", e.getMessage().getContentRaw(), false)
                    .setFooter(STATIC.getTime(), null)
                    .build()).complete();

            sender.openPrivateChannel().queue(pc -> pc.sendMessage(
                    new EmbedBuilder().setColor(Color.orange).setDescription(
                            "You can not write on this server, because you are muted in text channels!\n" +
                                    "Please contact an Supporter, Moderator or Admin to unmute.\n\n" +
                                    "Mute Reason: `" + mutes.get(sender.getId()) + "`"
                    ).build()
            ).queue());
            e.getMessage().delete().queue();
        }
    }

}
