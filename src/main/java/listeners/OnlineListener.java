package listeners;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.user.update.UserUpdateOnlineStatusEvent;
import net.dv8tion.jda.core.hooks.EventListener;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import util.STATIC;

import java.awt.*;

import static net.dv8tion.jda.core.OnlineStatus.*;

public class OnlineListener extends ListenerAdapter {

    public void onUserUpdateOnlineStatus(UserUpdateOnlineStatusEvent event) {

        if (event.getNewOnlineStatus() == ONLINE) {

            event.getJDA().getTextChannelsByName("onlinelog", true).get(0).sendMessage(new EmbedBuilder().setColor(new Color(0x15D200))
                    .setDescription("hat sein onlinestatus von `" + event.getOldOnlineStatus() + "` zu: `" + event.getNewOnlineStatus() + "`")
                    .setFooter(STATIC.getTime(), null)
                    .setAuthor(event.getUser().getName(), STATIC.userlink(event.getMember().getUser().getId(), event.getMember().getUser().getName()), event.getUser().getAvatarUrl())
                    .build()).queue();

        }


        if (event.getNewOnlineStatus() == IDLE) {

            event.getJDA().getTextChannelsByName("onlinelog", true).get(0).sendMessage(new EmbedBuilder().setColor(new Color(0xD2C900))
                    .setDescription("hat sein onlinestatus von `" + event.getOldOnlineStatus() + "` zu: `" + event.getNewOnlineStatus() + "`")
                    .setFooter(STATIC.getTime(),null)
                    .setAuthor(event.getUser().getName(), STATIC.userlink(event.getMember().getUser().getId(), event.getMember().getUser().getName()), event.getUser().getAvatarUrl())
                    .build()).queue();

        }

        if (event.getNewOnlineStatus() == DO_NOT_DISTURB) {

            event.getJDA().getTextChannelsByName("onlinelog", true).get(0).sendMessage(new EmbedBuilder().setColor(new Color(0xD2000C))
                    .setDescription("hat sein onlinestatus von `" + event.getOldOnlineStatus() + "` zu: `" + event.getNewOnlineStatus() + "`")
                    .setFooter(STATIC.getTime(),null)
                    .setAuthor(event.getUser().getName(), STATIC.userlink(event.getMember().getUser().getId(), event.getMember().getUser().getName()), event.getUser().getAvatarUrl())
                    .build()).queue();

        }

        if (event.getNewOnlineStatus() == OFFLINE) {

            event.getJDA().getTextChannelsByName("onlinelog", true).get(0).sendMessage(new EmbedBuilder().setColor(new Color(0x595959))
                    .setDescription("hat sein onlinestatus von `" + event.getOldOnlineStatus() + "` zu: `" + event.getNewOnlineStatus() + "`")
                    .setFooter(STATIC.getTime(),null)
                    .setAuthor(event.getUser().getName(), STATIC.userlink(event.getMember().getUser().getId(), event.getMember().getUser().getName()), event.getUser().getAvatarUrl())
                    .build()).queue();

        }

    }

}
