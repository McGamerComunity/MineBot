package commands;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import util.STATIC;

import java.awt.*;


import net.dv8tion.jda.core.EmbedBuilder;
import sun.nio.ch.Secrets;
import util.*;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.awt.*;

    public class Versionlog implements commands {


        @Override
        public boolean called(String[] args, MessageReceivedEvent event) {
            return false;
        }

        @Override
        public void action(String[] args, MessageReceivedEvent event) {
            event.getTextChannel().sendMessage(new EmbedBuilder().setColor(new Color(0x25DD52)).setDescription("**Versionlog:**")
                    .addField("2.8.156 (_29.04.2018 - 19:28_)", "-ADDED VERSIONLOG\n-FIXED SOME BUGGS", false)
                    .addField("2.8.162 (_02.05.2018 - 17:24_)", "-FIXED SOME BUGS", false)
                    .addField("2.8.217 (_02.05.2018 - 16:19_)", "-FIXED TIMESTAMP BUG", false)
                    .addField("2.8.218 (_03.05.2018 - 16:23_)", "-ADDED TIMESTAMP TO VERSIONLOG", false)
                    .addField("2.8.219 (_03.05.2018 - 16:35_)", "-FIXED SOME FORMATTING BUGS", false)
                    .addField("2.8.220 (_03.05.2018 - 17:02_)", "-FIXED SOME FORMATTING BUGS", false)
                    .addField("2.8.227 (_03.05.2018 - 17:11_)", "-ADDED SOMETHING TO THE NICKNAME LOG", false)
                    .addField("2.8.246 (_03.05.2018 - 17:49_)", "-FIXED TIMESTAMPS\n-FIXED NAMECHANGE EVENTS", false)
                    .addField("2.8.321 (_12.05.2018 - 10:07_)", "-ADDED GAMELOG", false)
                    .addField("2.8.327 (_12.05.2018 - 10:46_)", "-REMOVED GAMELOG\n-ADDED ONLINELOG", false)
                    .addField("2.8.329 (_12.05.2018 - 10:56_)", "-ADDED GAMELOG AGAIN", false)
                    .addField("2.8.330 (_12.05.2018 - 11:01_)", "-REMOVED GAMELOG AGAIN BECAUSE OF AN UNKNOWN BUG", false)
                    .addField("2.9 (_24.05.2018 - 17:27_)", "-ADDED MUSIC COMMAND", false)
                    .build()).queue();
        }

        @Override
        public void executet(boolean sucess, MessageReceivedEvent event) {
            System.out.println("[INFO] Command '" + STATIC.PREFIX + "versionlog' wurde erfolgreich ausgeführt");

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

