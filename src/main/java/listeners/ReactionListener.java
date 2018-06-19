package listeners;

import commands.Vote;
import commands.etc.Bug;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;



public class ReactionListener extends ListenerAdapter {

    @Override
    public void onMessageReactionAdd(MessageReactionAddEvent event) {

        Vote.handleReaction(event);

        try {
            if (event.getMessageId().equals(Bug.MESSAGE.getId()) && event.getUser().equals(Bug.AUTHOR)) {
                Bug.CHANNEL.sendMessage(Bug.FINAL_MESSAGE.build()).queue();
                Bug.sendConfMessage();

                Bug.AUTHOR = null;
                Bug.MESSAGE = null;
                Bug.FINAL_MESSAGE = null;
                Bug.CHANNEL = null;
                Bug.TIMER = null;
            }
        } catch (Exception e) {}
    }

}