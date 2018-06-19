/*
package listeners;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.user.UserGameUpdateEvent;
import net.dv8tion.jda.core.events.user.update.UserUpdateGameEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import util.STATIC;

import java.awt.*;

public class GameListener extends ListenerAdapter {

    public void onUserUpdateGame(UserUpdateGameEvent event) {
        if (event.getOldGame().getName().toLowerCase() == null){

            event.getJDA().getTextChannelsByName("gamelog", true).get(0).sendMessage(new EmbedBuilder().setColor(new Color(0x109E00))
                    .setDescription("Spielt nun `" + event.getNewGame().getName() + "`")
                    .setFooter(STATIC.getTime(),null)
                    .setAuthor(event.getUser().getName(), null , event.getUser().getAvatarUrl())
                    .build()).queue();
            System.out.println(event.getUser().getName() + "begins playing:" + event.getNewGame());

        }

        if (event.getNewGame().getName().toLowerCase() == null) {
            event.getJDA().getTextChannelsByName("gamelog", true).get(0).sendMessage(new EmbedBuilder().setColor(new Color(0x9D0019))
                    .setDescription("hat aufgehört `" + event.getOldGame().getName() + "` zu spielen")
                    .setFooter(STATIC.getTime(),null)
                    .setAuthor(event.getUser().getName(), null , event.getUser().getAvatarUrl())
                    .build()).queue();
            System.out.println(event.getUser().getName() + "stops playing:" + event.getOldGame());
        }

        if (event.getOldGame().getName().toLowerCase() != event.getNewGame().getName().toLowerCase()) {
            event.getJDA().getTextChannelsByName("gamelog", true).get(0).sendMessage(new EmbedBuilder().setColor(new Color(0x00BCBC))
                    .setDescription("hat sein Spiel von: `" + event.getOldGame().getName() + "` zu: `" + event.getNewGame().getName() + "` geändert.")
                    .setFooter(STATIC.getTime(),null)
                    .setAuthor(event.getUser().getName(), null , event.getUser().getAvatarUrl())
                    .build()).queue();
            System.out.println(event.getUser().getName() + "changed his game from:" + event.getOldGame() + "to:" + event.getNewGame());
        }
    }

}
*/