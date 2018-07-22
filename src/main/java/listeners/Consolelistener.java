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

import net.dv8tion.jda.core.hooks.ListenerAdapter;
import util.STATIC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Consolelistener extends ListenerAdapter {

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("MINEBOT RECOVERY");
            System.out.println(
                    "############################## HELP ##############################\n" +
                            "#                                                                #\n" +
                            "#  1----licence ---------- shows your licencekey                 #\n" +
                            "#                                                                #\n" +
                            "#  2----start    ---------- starts the bot                       #\n" +
                            "#                                                                #\n" +
                            "##################################################################\n"
            );
            while (true) {
                System.out.print("\n> ");

                try{
                    int i = Integer.parseInt(br.readLine());

                    if (i == 1) {
                        System.out.println("your licencekey is: " + STATIC.LICENCE);
                    }
                    if (i == 2) {
                        System.out.println("starting the bot");
                    }
                }catch(NumberFormatException nfe){
                    System.err.println("Invalid Format!");



                }
            }

        }
}
