package listeners;

import com.sun.istack.internal.NotNull;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import util.STATIC;


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
 for (Guild g : event.getJDA().getGuilds() ) {

 g.getOwner().getUser().getId();

 }
 */

    }

}