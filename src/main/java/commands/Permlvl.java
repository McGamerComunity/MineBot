package commands;

import core.Perms;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import util.MSGS;
import util.STATIC;

import java.io.IOException;
import java.text.ParseException;

public class Permlvl implements commands {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) throws IOException, ParseException {
        TextChannel tc = event.getTextChannel();

        tc.sendMessage(MSGS.success()
                .setAuthor(event.getMember().getUser().getName(), STATIC.userlink(event.getMember().getUser().getId()), event.getMember().getUser().getEffectiveAvatarUrl())
                .addField("Dein Permissionlevel:", "`" + String.valueOf(Perms.getLvl(event.getMember())) + "`",false )
                .build()).complete();
    }

    @Override
    public void executet(boolean sucess, MessageReceivedEvent event) {

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
