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

import core.SSSS;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.PrivateChannel;
import net.dv8tion.jda.core.events.guild.GuildBanEvent;
import net.dv8tion.jda.core.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.core.events.guild.member.GuildMemberLeaveEvent;
import net.dv8tion.jda.core.events.guild.voice.GuildVoiceJoinEvent;
import net.dv8tion.jda.core.events.guild.voice.GuildVoiceLeaveEvent;
import net.dv8tion.jda.core.events.guild.voice.GuildVoiceMoveEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import util.STATIC;

import java.text.SimpleDateFormat;
import java.util.Date;

import java.awt.*;



public class VoiceListener extends ListenerAdapter {
    

    public void onGuildVoiceJoin(GuildVoiceJoinEvent event) {
        event.getGuild().getTextChannelsByName("voicelog", true).get(0).sendMessage(new EmbedBuilder().setColor(new Color(0x25DD52)).setDescription(
                ":white_check_mark: joined `" + event.getChannelJoined().getName() + "`."
        ).setFooter(STATIC.getTime(),null)
                .setAuthor(event.getVoiceState().getMember().getUser().getName(), STATIC.userlink(event.getMember().getUser().getId(), event.getMember().getUser().getName()), event.getVoiceState().getMember().getUser().getAvatarUrl())
                .build()).queue();

    }

    public void onGuildVoiceMove(GuildVoiceMoveEvent event) {
        event.getGuild().getTextChannelsByName("voicelog", true).get(0).sendMessage(new EmbedBuilder().setColor(new Color(0x47BDDD)).setDescription(
                ":arrow_right: went from `" + event.getChannelLeft().getName() + "` to `" + event.getChannelJoined().getName() + "`."
        ).setFooter(STATIC.getTime(),null)
                .setAuthor(event.getVoiceState().getMember().getUser().getName(), STATIC.userlink(event.getMember().getUser().getId(), event.getMember().getUser().getName()), event.getVoiceState().getMember().getUser().getAvatarUrl())
                .build()).queue();
    }

    public void onGuildVoiceLeave(GuildVoiceLeaveEvent event) {
        event.getGuild().getTextChannelsByName("voicelog", true).get(0).sendMessage(new EmbedBuilder().setColor(new Color(0xDD3238)).setDescription(
                ":small_red_triangle_down: left `" + event.getChannelLeft().getName() + "`."
        ).setFooter(STATIC.getTime(),null)
                .setAuthor(event.getVoiceState().getMember().getUser().getName(), STATIC.userlink(event.getMember().getUser().getId(), event.getMember().getUser().getName()), event.getVoiceState().getMember().getUser().getAvatarUrl())
                .build()).queue();
    }

    public void onGuildMemberLeave(GuildMemberLeaveEvent event){
        event.getGuild().getTextChannelsByName("joinleave", true).get(0).sendMessage(new EmbedBuilder().setColor(Color.red).setDescription(":x: " + event.getMember().getAsMention() + " hat den Server verlassen").setFooter(STATIC.getTime(),null).setAuthor(event.getMember().getUser().getName(), STATIC.userlink(event.getMember().getUser().getId(), event.getMember().getUser().getName()), event.getMember().getUser().getAvatarUrl()).build()).queue();
        event.getGuild().getTextChannelsByName("chat", true).get(0).sendMessage(new EmbedBuilder().setColor(Color.red).setDescription(":x: " + event.getMember().getAsMention() + " hat den Server verlassen").setFooter(STATIC.getTime(),null).setAuthor(event.getMember().getUser().getName(), STATIC.userlink(event.getMember().getUser().getId(), event.getMember().getUser().getName()), event.getMember().getUser().getAvatarUrl()).build()).queue();


    }

    public void onGuildMemberJoin(GuildMemberJoinEvent event){

        PrivateChannel pc = event.getMember().getUser().openPrivateChannel().complete();
        if (event.getMember().getUser().isBot() == false) {
            pc.sendMessage(
                    "**Hey,** " + event.getMember().getAsMention() + " **and welcome on the " + event.getGuild().getName() + " Discord server!**   :wave:\n\n" +
                            "You have to react in #rules-regeln with :white_check_mark: to the rules to get the Spieler role.\n\n"
            ).queue();
        } else {
            event.getGuild().getController().addRolesToMember(event.getMember(), event.getGuild().getRolesByName("Bot", true)).queue();
        }



        event.getGuild().getTextChannelsByName("joinleave", true).get(0).sendMessage(new EmbedBuilder().setColor(Color.green).setDescription(
                ":white_check_mark: hat den Server Betreten"
        ).setFooter(STATIC.getTime(),null)
                .setAuthor(event.getMember().getUser().getName(), STATIC.userlink(event.getMember().getUser().getId(), event.getMember().getUser().getName()), event.getMember().getUser().getAvatarUrl())
                .build()).queue();

        event.getGuild().getTextChannelsByName("chat", true).get(0).sendMessage(new EmbedBuilder().setColor(Color.green).setDescription(
                ":white_check_mark: Willkommen " + event.getMember().getAsMention() + " auf dem **"+ event.getGuild().getName() +"**"
        ).setFooter(STATIC.getTime(),null)
                .setAuthor(event.getMember().getUser().getName(), STATIC.userlink(event.getMember().getUser().getId(), event.getMember().getUser().getName()), event.getMember().getUser().getAvatarUrl())
                .build()).queue();

    }

}