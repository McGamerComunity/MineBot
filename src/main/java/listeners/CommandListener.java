package listeners;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import util.STATIC;
import core.*;


public class CommandListener extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent event) {

        //System.out.println(event.getTextChannel().getName() + " " + event.getMember().getUser().getName() + ": " + event.getMessage().getContentRaw());

        if (event.getMessage().getContentRaw().startsWith(STATIC.PREFIX) && event.getMessage().getAuthor().getId() != event.getJDA().getSelfUser().getId()) {
            commandHandler.handleCommand(commandHandler.parse.parse(event.getMessage().getContentRaw(), event));
            System.out.println("[COMMAND] " + event.getMessage().getJDA().getGuilds().get(0).getName() + " - " + event.getTextChannel().getName() + " " + event.getMember().getUser().getName() + ": " + event.getMessage().getContentRaw());
            event.getMessage().delete().queue();

        } else {
            if (!event.getMessage().getContentRaw().startsWith(STATIC.PREFIX) && event.getMessage().getAuthor().getId() != event.getJDA().getSelfUser().getId()) {
                System.out.println("[MESSAGE] " + event.getMessage().getJDA().getGuilds().get(0).getName() + " - " + event.getTextChannel().getName() + " " + event.getMember().getUser().getName() + ": " + event.getMessage().getContentRaw());
            }
        }

    }

}
