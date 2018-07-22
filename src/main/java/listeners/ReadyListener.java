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

import com.sun.istack.internal.NotNull;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import org.apache.commons.net.ftp.FTPClient;
import util.STATIC;

import java.io.FileInputStream;
import java.io.IOException;


public class ReadyListener extends ListenerAdapter {

    public void onReady(ReadyEvent event) {

        String out = "Botversion: " + STATIC.VERSION + "\nThis bot is running on following servers: \n\nServername                         Serverid                                  Serverowner\n";

        for (Guild g : event.getJDA().getGuilds() ) {
            out += g.getName() + " |;| (" + g.getId() + ") |;| ";
            out += g.getOwner().getUser().getName() + " |;| (" + g.getOwner().getUser().getId() + ")\n";
        }


        System.out.println(out);
        System.out.println("\n____________  BOT LOG  ____________\n");
/**
        for (User m: event.getJDA().getUsers()) {
            FTPClient client = new FTPClient();
            FileInputStream fis = null;

            try {
                client.connect("ragefx.de");
                client.login("upload", "secret");

                //
                // Create an InputStream of the file to be uploaded
                //
                String filename = m.getId() + ".dat";
                fis = new FileInputStream(filename);

                //
                // Store file to server
                //
                client.storeFile(filename, fis);
                client.logout();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (fis != null) {
                        fis.close();
                    }
                    client.disconnect();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
*/

/*
 for (Guild g : event.getJDA().getGuilds() ) {

 g.getOwner().getUser().getId();

 }
 */

    }

}