package listeners;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.emote.update.EmoteUpdateNameEvent;
import net.dv8tion.jda.core.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.core.events.guild.member.GuildMemberNickChangeEvent;
import net.dv8tion.jda.core.events.guild.voice.*;
import net.dv8tion.jda.core.events.self.SelfUpdateNameEvent;
import net.dv8tion.jda.core.events.user.update.UserUpdateNameEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import util.STATIC;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class nickListener extends ListenerAdapter {

    public void onGuildMemberNickChange(GuildMemberNickChangeEvent event) {

        if (event.getPrevNick() == "null") {
           String nickold = event.getMember().getUser().getName();
        } else {
            String nickold = event.getPrevNick();
        }

        if (event.getNewNick() == "null") {
            String nicknew = event.getMember().getUser().getName();
        } else {
            String nicknew = event.getNewNick();
        }

        event.getGuild().getTextChannelsByName("namelog", true).get(0).sendMessage(new EmbedBuilder().setColor(new Color(0x7D0FDD)).setDescription(
                "hat seinen Nickname von `" + event.getPrevNick() + "` zu: `" + event.getNewNick() + "` geändert."
        ).setFooter(STATIC.getTime(),null)
                .setAuthor(event.getMember().getUser().getName(), STATIC.userlink(event.getMember().getUser().getId(), event.getMember().getUser().getName()), event.getMember().getUser().getAvatarUrl())
                .build()).queue();

    }
    public void onUserUpdateName(UserUpdateNameEvent event) {
        event.getJDA().getTextChannelsByName("namelog", true).get(0).sendMessage(new EmbedBuilder().setColor(new Color(0xFFFF00)).setDescription(
                "hat seinen Discordnamen von `" + event.getOldName() + "` zu: `" + event.getNewName() + "` geändert."
        ).setFooter(STATIC.getTime(),null)
                .setAuthor(event.getUser().getName(), STATIC.userlink(event.getUser().getId(), event.getUser().getName()), event.getUser().getAvatarUrl())
                .build()).queue();
    }

}
