package listeners;

import core.Perms;
import core.SSSS;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.PrivateChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import util.STATIC;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MsgListener extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent event) {

        String[] intbots = {"1","2","3","4","5","6","7","rage","!rage"};

        if (Perms.getLvl(event.getMember()) < 2) {
            if (!event.getMessage().getContentRaw().startsWith(STATIC.PREFIX)) {
                if (!event.getMessage().getContentRaw().startsWith("!" + Arrays.toString(intbots))) {

        if (event.getMessage().getContentRaw().matches("http*?://?\\.?/.+")){

            event.getMessage().delete().queue();
            PrivateChannel pc = event.getMember().getUser().openPrivateChannel().complete();
            pc.sendMessage(new EmbedBuilder()
                    .setDescription("Youll be Warned :warning:\nYour Message Got Deleted because of advertising links")
                    .addField("Content:" , event.getMessage().getContentRaw(), false)
                    .build()).complete();
        }
        if (event.getMessage().getContentRaw().matches("https*?://?\\.?/.+")){

            event.getMessage().delete().queue();
            PrivateChannel pc = event.getMember().getUser().openPrivateChannel().complete();
            pc.sendMessage(new EmbedBuilder()
                    .setDescription("Youll be Warned :warning:\nYour Message Got Deleted because of advertising links")
                    .addField("Content:" , event.getMessage().getContentRaw(), false)
                    .build()).complete();
        }
        if (event.getMessage().getContentRaw().matches(".*?.?\\.?.+")) {

            event.getMessage().delete().queue();
            PrivateChannel pc = event.getMember().getUser().openPrivateChannel().complete();
            pc.sendMessage(new EmbedBuilder()
                    .setDescription("Youll be Warned :warning:\nYour Message Got Deleted because of advertising")
                    .addField("Content:", event.getMessage().getContentRaw(), false)
                    .build()).complete();
        }
        }
        }
        }
    }
}
