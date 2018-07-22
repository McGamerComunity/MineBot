/**
 .___  ___.   ______   _______      ___      .___  ___.  _______ .______
 |   \/   |  /      | /  _____|    /   \     |   \/   | |   ____||   _  \
 |  \  /  | |  ,----'|  |  __     /  ^  \    |  \  /  | |  |__   |  |_)  |
 |  |\/|  | |  |     |  | |_ |   /  /_\  \   |  |\/|  | |   __|  |      /
 |  |  |  | |  `----.|  |__| |  /  _____  \  |  |  |  | |  |____ |  |\  \----.
 |__|  |__|  \______| \______| /__/     \__\ |__|  |__| |_______|| _| `._____|

 (c) 2014-2018
 */


package listeners;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.PrivateChannel;
import net.dv8tion.jda.core.events.message.priv.PrivateMessageReceivedEvent;
import net.dv8tion.jda.core.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


public class privateMessageListener extends ListenerAdapter {



    public void onPrivateMessageReceived(PrivateMessageReceivedEvent event) {

        final File file = new File( "USERS/" + event.getAuthor().getId() + "/mcname.dat");

        if (event.getMessage().getContentRaw().startsWith("token_"))
            return;

        if (event.getMessage().getContentRaw().equalsIgnoreCase("-disable")) {

            try {
                new File("SERVER_SETTINGS/no_update_info").createNewFile();
                event.getChannel().sendMessage(new EmbedBuilder()
                        .setColor(Color.red)
                        .setDescription("You disabled update notifications.\n" +
                                "Now, you wont get automatically notified if there are new versions of the bot available.")
                        .setFooter("Re-enable this function with enetring '-enable'.", null)
                        .build()).queue();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return;
        }

        if (event.getMessage().getContentRaw().equalsIgnoreCase("-enable")) {


            File f = new File("SERVER_SETTINGS/no_update_info");
            if (f.exists())
                f.delete();

            event.getChannel().sendMessage(new EmbedBuilder()
                    .setColor(Color.green)
                    .setDescription("You re-enabled update notification.")
                    .setFooter("Disable this function with enetring '-disable'.", null)
                    .build()).queue();

            return;
        }

        if (event.getMessage().getContentRaw().startsWith("-register")) {

            File users_dir = new File("USERS/" + event.getAuthor().getId());
            if (!users_dir.exists() || !users_dir.isDirectory()) {
                System.out.println(
                        users_dir.mkdir() ? "[INFO] Path \"" + event.getAuthor().getId() + "\" successfully created!" : "[ERROR] Failed to create path \"" + event.getAuthor().getId() + "\"!"
                );
            }

            try {
                new File(String.valueOf(file)).createNewFile();

                BufferedWriter br = new BufferedWriter(new FileWriter(file));

                br.write(event.getMessage().getContentRaw().replace("-register ", ""));
                br.flush();
                br.close();

                PrivateChannel pc = event.getAuthor().openPrivateChannel().complete();

                event.getJDA().getGuildById("402526922439000068").getController().addRolesToMember(event.getJDA().getGuildById("402526922439000068").getMemberById(event.getAuthor().getId()), event.getJDA().getGuildById("402526922439000068").getRolesByName("Registered", true)).queue();

                pc.sendMessage("You are Registered with Minecraftname: " + event.getMessage().getContentRaw().replace("-register", "")).queue();

                PrivateChannel mcpc = event.getJDA().getUserById("273115881960374272").openPrivateChannel().complete();

                mcpc.sendMessage("The User: `" + event.getAuthor().getName() + "` (" +event.getAuthor().getId() + ") is now registered with following minecraft name: `" + event.getMessage().getContentRaw().replace("-register", "") + "`").queue();



            } catch (IOException e) {
                e.printStackTrace();
            }

            return;

        }

        if (event.getMessage().getContentRaw().equalsIgnoreCase("-help")) {
            event.getChannel().sendMessage(new EmbedBuilder()
                    .setColor(new Color(0xC9FF30))
                    .setDescription("Minebot Privatechat Help")
                    .addField("Update Notify:", "**enable** enables update notification\n" +
                            "**disable** disables update notification\n" +
                            "**register** registers you with your minecraftaccount", false)
                    .setFooter("Prefix: `-`", null)
                    .build()).queue();
            return;
        }


        String[] answers = {
                "Hey, " + event.getAuthor().getName() + "! What's going on?",
                "That's nice!",
                "Good job!",
                "I love it so much to eat cookies :cookie: all day long...",
                "I'm bored.",
                "You are so smart, " + event.getAuthor().getName() + "!",
                "You smell really good, you know? ^^",
                "Tell me more, Senpai.",
                "The weather here is quite nice.",
                "lol",
                "lel",
                "xD",
                ":^)",
                "Did you had a nice day? ^^",
                "I'm talking shit lul",
                "Please get me out of that box... o.o",
                "My real name is Thomas, but please don't tell it someone else... :)",
                "I don't know",
                "Why are my awnser so stupid?",
                "My Developer is McGamer_Comunity",
                "I Like you"
        };

        try {

            if (!event.getAuthor().equals(event.getJDA().getSelfUser())) {

                Random rand = new Random();
                PrivateChannel pc = event.getAuthor().openPrivateChannel().complete();
                if (event.getMessage().getContentRaw().toLowerCase().contains("hey") || event.getMessage().getContentRaw().toLowerCase().contains("hello")) {
                    pc.sendTyping().queue();
                    new Timer().schedule(new TimerTask() {
                        @Override
                        public void run() {
                            pc.sendMessage("Hey, " + event.getAuthor().getName() + "! What's going on?").queue();
                        }
                    }, 1000);
                } else {
                    pc.sendTyping().queue();
                    new Timer().schedule(new TimerTask() {
                        @Override
                        public void run() {
                            pc.sendMessage(answers[rand.nextInt(answers.length)]).queue();
                        }
                    }, 1000);
                }

            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}