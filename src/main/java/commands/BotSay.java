/**
 .___  ___.   ______   _______      ___      .___  ___.  _______ .______
 |   \/   |  /      | /  _____|    /   \     |   \/   | |   ____||   _  \
 |  \  /  | |  ,----'|  |  __     /  ^  \    |  \  /  | |  |__   |  |_)  |
 |  |\/|  | |  |     |  | |_ |   /  /_\  \   |  |\/|  | |   __|  |      /
 |  |  |  | |  `----.|  |__| |  /  _____  \  |  |  |  | |  |____ |  |\  \----.
 |__|  |__|  \______| \______| /__/     \__\ |__|  |__| |_______|| _| `._____|

 (c) 2014-2018
 */

package commands;

        import core.permsCore;
        import net.dv8tion.jda.core.EmbedBuilder;
        import net.dv8tion.jda.core.entities.User;
        import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
        import util.STATIC;

        import java.awt.*;

public class BotSay implements commands
{
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {


        String msg = String.join(" ", args);

        event.getMessage().delete().queue();

        if (msg == "") {
            event.getTextChannel().sendMessage(new EmbedBuilder().setColor(new Color(0xBE171F))

                    .addField("USAGE:", "mb botsay <message>", false)
                    .build()).queue();
        }

        event.getTextChannel().sendMessage(msg).queue();
    }
    @Override
    public void executet(boolean sucess, MessageReceivedEvent event) {

    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return "USAGE: mb botsay <message>";
    }

    @Override
    public String description() {
        return "Says something as the bot";
    }

    @Override
    public String commandType() {
        return STATIC.CMDTYPE.administration;
    }

    @Override
    public int permission() {
        return 5;
    }

}
