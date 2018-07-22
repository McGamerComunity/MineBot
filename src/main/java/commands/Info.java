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

import net.dv8tion.jda.core.EmbedBuilder;
import sun.nio.ch.Secrets;
import util.*;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.awt.*;

public class Info implements commands {


    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        event.getTextChannel().sendMessage((new EmbedBuilder().setColor(Color.MAGENTA).setDescription(":robot: __**MineBot v2.0**__ Developed By McGamer_Comunity")
                .addField("Current Version", STATIC.VERSION, true)
                .addField("Latest Version", STATIC.LVERSION, true)
                .addField("Copyright", "Coded By McGamer_Comunity and RaphA 03.\n© 2013 - 2018 McGamer_Comunity.", false)
                .addField("Information and Links", "GitHub Repository: \n*https://github.com/McGamerComunity/MineBot*\n\nReadme/Changelogs: \n*https://github.com/McGamerComunity/MineBot/blob/master/README.md*\n\nWebpage: \n*https://www.ragefx.de*\n\nGithub Profile: \n*https://github.com/McGamerComunity*", false)
                .addField("Libraries and Dependencies", " -  JDA  *(https://github.com/DV8FromTheWorld/JDA)*\n -  Toml4J  *(https://github.com/mwanji/toml4j)*\n -  lavaplayer  *(https://github.com/sedmelluq/lavaplayer)*\n -  Steam-Condenser  *(https://github.com/koraktor/steam-condenser-java)*", false)
                .addField("Bug Reporting / Idea Suggestion", "If you got some bugs, please contact me here:\n - Please use this document to report a Bug or suggest an idea: http://bugs.ragefx.de\n -  E-Mail: mcgamer@ragefx.de\n -  Discord:  https://discord.gg/" + STATIC.DISCORD + " (or directly: `\uD83D\uDD30 McGamer_Comunity \uD83D\uDD30#8073`)", false)
                .addField("HELPER:", "RaphA 03(RaphA 03#1226)", true)
                .build())).queue();
    }

    @Override
    public void executet(boolean sucess, MessageReceivedEvent event) {
        System.out.println("[INFO] Command '" + STATIC.PREFIX + "ping' wurde erfolgreich ausgeführt");

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
        return "Information about the Bot";
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
