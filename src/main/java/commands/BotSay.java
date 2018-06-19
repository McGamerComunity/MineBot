package commands;

        import core.permsCore;
        import net.dv8tion.jda.core.EmbedBuilder;
        import net.dv8tion.jda.core.entities.User;
        import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

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
        return null;
    }

    @Override
    public String commandType() {
        return null;
    }

    @Override
    public int permission() {
        return 5;
    }

}
