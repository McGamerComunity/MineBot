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
                .addField("Latest Version", STATIC.VERSION, true)
                .addField("Copyright", "Coded By McGamer_Comunity and RaphA 03.\n© 2013 - 2018 McGamer_Comunity.", false)
                .addField("Information and Links", "GitHub Repository: \n*https://github.com/McGamer_Comunity/DiscordBot*\n\nReadme/Changelogs: \n*https://github.com/McGamer_Comunity/DiscordBot/blob/master/README.md*\n\nWebpage: \n*https://github.com/McGamer_Comunity/*\n\nGithub Profile: \n*https://github.com/McGamer_Comunity*", false)
                .addField("Libraries and Dependencies", " -  JDA  *(https://github.com/DV8FromTheWorld/JDA)*\n -  Toml4J  *(https://github.com/mwanji/toml4j)*\n -  lavaplayer  *(https://github.com/sedmelluq/lavaplayer)*\n -  Steam-Condenser  *(https://github.com/koraktor/steam-condenser-java)*", false)
                .addField("Bug Reporting / Idea Suggestion", "If you got some bugs, please contact me here:\n - Please use this document to report a Bug or suggest an idea: mcgamer_comunity#8073@discordmail.com\n -  E-Mail: mcgamer_comunity#8073@discordmail.com\n -  Discord:  https://discord.gg/pUh9XEh (or directly: `\uD83D\uDD30 McGamer_Comunity \uD83D\uDD30#8073`)", false)
                .addField("HELPER:", "RaphA 03(RaphA 03#1226)", true)
                .addField("DESINGER:", "TheVoidNebula(\uD83C\uDF1FTheVoidNebula\uD83C\uDF1F#7394)", true)
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
