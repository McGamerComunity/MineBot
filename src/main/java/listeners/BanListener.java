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
import net.dv8tion.jda.core.events.guild.GuildBanEvent;
import net.dv8tion.jda.core.events.guild.GuildUnbanEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import util.STATIC;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BanListener extends ListenerAdapter {


    public void onGuildBan(GuildBanEvent event) {
        event.getGuild().getTextChannelsByName("banlog", true).get(0).sendMessage(new EmbedBuilder().setColor(new Color(0xDD1324)).setDescription(
                ":no_entry_sign: was Banned"
        ).setFooter(STATIC.getTime(),null)
                .setAuthor(event.getUser().getName(), STATIC.userlink(event.getUser().getId(), event.getUser().getName()), event.getUser().getAvatarUrl())
                .build()).queue();
    }

    public void onGuildUnban(GuildUnbanEvent event) {
        event.getGuild().getTextChannelsByName("banlog", true).get(0).sendMessage(new EmbedBuilder().setColor(new Color(0x07DD09)).setDescription(
                ":white_check_mark: was Unbanned"
        ).setFooter(STATIC.getTime(),null)
                .setAuthor(event.getUser().getName(), STATIC.userlink(event.getUser().getId(), event.getUser().getName()), event.getUser().getAvatarUrl())
                .build()).queue();
    }

}
