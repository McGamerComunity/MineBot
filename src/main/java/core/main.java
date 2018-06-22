package core;

import com.sun.corba.se.impl.activation.CommandHandler;
import commands.*;
import commands.etc.Bug;
import listeners.*;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Game;
import org.omg.CORBA.ORB;
import util.STATIC;

import javax.security.auth.login.LoginException;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.HashMap;

public class main {



    public static final CommandHandler parser = new CommandHandler() {
        @Override
        public String getCommandName() {
            return null;
        }

        @Override
        public void printCommandHelp(PrintStream out, boolean helpType) {

        }

        @Override
        public boolean processCommand(String[] cmd, ORB orb, PrintStream out) {
            return false;
        }
    };

    public static HashMap<String, commands> commands = new HashMap<>();

    public static JDA jda;



    public static void main(String[] Args) throws InterruptedException, IOException {
        System.out.println("MINEBOT CONSOLE\nTYPE 'help' FOR HELP\n");

        while (true) {
            System.out.print("MAIN> ");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String s = null;
            try {
                s = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (s.startsWith("licence")) {
                System.out.println("your licencekey is: " + STATIC.LICENCE);
            }

            if (s.startsWith("start")) {
                System.out.println("starting the bot");

                JDABuilder builder = new JDABuilder(AccountType.BOT);

                builder = new JDABuilder(AccountType.BOT)
                        .setToken(STATIC.TOKEN)
                        .setAudioEnabled(true)
                        .setAutoReconnect(true)
                        .setStatus(STATIC.STATUS)
                        .setGame(Game.playing(STATIC.GAME));


                builder
                        .addEventListener(new ReadyListener())
                        .addEventListener(new VoiceListener())
                        .addEventListener(new CommandListener())
                        .addEventListener(new privateMessageListener())
                        .addEventListener(new ReactionListener())
                        .addEventListener(new nickListener())
                        .addEventListener(new BanListener())
                        .addEventListener(new OnlineListener())
                        .addEventListener(new Consolelistener())
                        .addEventListener(new SecurityListener())
                ;


                commandHandler.commands.put("vote", new Vote());
                commandHandler.commands.put("help", new Help());
                commandHandler.commands.put("say", new Say());
                commandHandler.commands.put("botsay", new BotSay());
                commandHandler.commands.put("bug", new Bug());
                commandHandler.commands.put("clear", new Clear());
                commandHandler.commands.put("info", new Info());
                commandHandler.commands.put("about", new Info());
                commandHandler.commands.put("versionlog", new Versionlog());
                commandHandler.commands.put("changelog", new Versionlog());
                commandHandler.commands.put("music", new Music());
                commandHandler.commands.put("cinfo", new Clientinfo());
                commandHandler.commands.put("clientinfo", new Clientinfo());



                try {
                    builder.buildBlocking();
                } catch (LoginException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if (s.startsWith("help")) {
                System.out.println(
                                "############################## HELP ##############################\n" +
                                "#                                                                #\n" +
                                "#  licence ---------- shows your licencekey                      #\n" +
                                "#                                                                #\n" +
                                "#  start ------------ starts the bot (if you start it            #\n" +
                                "#                     once it will start two times and bug)      #\n" +
                                "#                                                                #\n" +
                                "#  chat ------------- sends an chatmessage                       #\n" +
                                "#                                                                #\n" +
                                "##################################################################\n"
                );
            }

            if (s.startsWith("chat")) {
                System.out.println("CHAT SENDER\nTYPE 'help' FOR HELP");
                while (true) {
                    System.out.print("CHAT> ");
                    String chat = null;
                    try {
                        chat = reader.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if (chat.startsWith("help")) {
                        System.out.println(
                                "############################## HELP ##############################\n" +
                                        "#                                                                #\n" +
                                        "#  send ------------- sends an chatmessage                       #\n" +
                                        "#                                                                #\n" +
                                        "#  exit ------------- exits the chat programm                    #\n" +
                                        "#                                                                #\n" +
                                        "##################################################################\n"
                        );
                    }
                    if (chat.startsWith("send")) {
                        System.out.print("CHANNEL> ");
                        String chan = null;
                        try {
                            chan = reader.readLine();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        System.out.print("MESSAGE> ");
                        String msg = null;
                        try {
                            msg = reader.readLine();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        JDABuilder builder = new JDABuilder(AccountType.BOT);
                        System.out.println("MESSAGE SEND IN CHANNEL: '" + chan + "' WITH CONTENT: '" + msg + "'");
                        try {
                            builder.setToken(STATIC.TOKEN);
                            builder.buildBlocking().getTextChannelsByName(chan, true).get(0).sendMessage(msg).queue();
                        } catch (LoginException e) {
                            e.printStackTrace();
                        }
                    }

                    if (chat.startsWith("exit")) {
                        main(null);
                    }

                }
            }

        }
    }
}


