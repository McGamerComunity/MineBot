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
            level = "*Spieler* :white_small_square:";
        if (lvl == 1)
            level = "*Freund* :small_blue_diamond:";
        if (lvl == 2)
            level = "*Teammitglied* :small_orange_diamond:";
        if (lvl == 3)
            level = "*Admins* :small_red_triangle_down:";
        if (lvl == 4)
            level = "*Co-Owner* :octagonal_sign:";
        if (lvl == 5)
            level = "*Owner* :diamonds:";
        if (lvl == 10)
            level = "*Alle Rechte* :large_orange_diamond:";
        if (lvl == 50)
            level = "*Server Owner* :unlock:";
        if (lvl == 1000)
            level = "*Bot Ersteller* :octagonal_sign:";
        if (lvl == 10000)
            level = "*MineBot* :lock:";


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
        return "Shows your Permissionlevel";
    }

    @Override
    public String commandType() {
        return STATIC.CMDTYPE.etc;
    }

    @Override
    public int permission() {
        return 0;
    }
}
