package core;

import com.sun.corba.se.impl.activation.CommandHandler;
import commands.*;
import commands.etc.Bug;
import listeners.*;
import net.dv8tion.jda.client.entities.Application;
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
    public static final commandHandler parser = new commandHandler();


    public static void main(String[] Args) throws InterruptedException, IOException, LoginException {
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
                Botstart.main(null);
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
                            System.out.println("MESSAGE SEND IN CHANNEL: '" + chan + "' WITH CONTENT: '" + msg + "'");
                        }

                        if (chat.startsWith("exit")) {
                            main(null);
                        }

                    }
                }

            }
        }
    }


