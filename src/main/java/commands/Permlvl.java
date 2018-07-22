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

    private String level;

    void checklvl(int lvl) {

        if (lvl == 0)
            level = "*Spieler*";
        if (lvl == 1)
            level = "*Freund*";
        if (lvl == 2)
            level = "*Teammitglied*";
        if (lvl == 3)
            level = "*Admins*";
        if (lvl == 4)
            level = "*Co-Owner*";
        if (lvl == 5)
            level = "*Owner*";
        if (lvl == 10)
            level = "*Alle Rechte*";
        if (lvl == 50)
            level = "Server Owner";
        if (lvl == 1000)
            level = "*Bot Ersteller*";
        if (lvl == 10000)
            level = "*MineBot*";


    }


    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) throws IOException, ParseException {
        TextChannel tc = event.getTextChannel();

        checklvl(Perms.getLvl(event.getMember()));

        tc.sendMessage(MSGS.success()
                .setAuthor(event.getMember().getUser().getName(), STATIC.userlink(event.getMember().getUser().getId(), event.getMember().getUser().getName()), event.getMember().getUser().getEffectiveAvatarUrl())
                .addField("Dein Permissionlevel:", "`" + String.valueOf(Perms.getLvl(event.getMember())) + "` " + level,false )
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
