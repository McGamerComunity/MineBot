package commands;

import com.sun.prism.paint.Color;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.PrivateChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import util.STATIC;
import core.permsCore;

public class Help implements commands {

    private String prefix = STATIC.PREFIX;

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {

        if (permsCore.check(event) == 0)
            return;


        event.getTextChannel().sendMessage(new EmbedBuilder().setColor(java.awt.Color.CYAN)

                .addField("ADMIN", "**role** manage your roles (*WILL BE ADDED IN 2.9.x*)\n", false)
                .addField("GUILD-ADMIN", "**ownership** assing multiple people ownership rights (*WILL BE ADDED SOON*)\n", false)
                .addField("MODERATION", "---\n", false)
                .addField("FUN", "---\n", false)
                .addField("SETTINGS", "---\n", false)
                .addField("CHAT", "**vote** Create Polls. (**CONTAINS BUGGS**) _[lvl.100]_\n**say** Say something. _[lvl.0]_\n**botsay** Say something as the bot. _[lvl.5]_\n**clear** removes messages. _[lvl.10]_", false)
                .addField("MISC", "**prefix** change your color (*WILL BE ADDED IN 2.9.x*) _[lvl.1]_\n", false)
                .addField("DEBUG", "---\n", false)
                .addField("INFORMATION","**about/info** shows informations about the bot _[lvl.0]_\n**versionlog/changelog** shows the changelog _[lvl.0]_\nBOTPREFIX: `" + prefix + "`" , false)
                .build()).queue();


    }


    @Override
    public void executet(boolean sucess, MessageReceivedEvent event) {
        System.out.println("[INFO] Command '" + prefix + "help' wurde erfolgreich ausgeführt");
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return null;
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
        return 0;
    }

}
