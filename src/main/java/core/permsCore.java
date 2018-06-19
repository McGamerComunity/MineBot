package core;

import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.entities.impl.ReceivedMessage;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import util.STATIC;

import java.util.Arrays;

public class permsCore {

    public static int check(MessageReceivedEvent event) {

        for (Role r : event.getGuild().getMember(event.getAuthor()).getRoles()) {

            if (Arrays.stream(STATIC.PERMS).parallel().anyMatch(r.getName()::contains))
                return 5;

            else if (Arrays.stream(STATIC.PERMSA).parallel().anyMatch(r.getName()::contains))
                return 4;

            else if (Arrays.stream(STATIC.PERMSB).parallel().anyMatch(r.getName()::contains))
                return 3;

            else if (Arrays.stream(STATIC.PERMSC).parallel().anyMatch(r.getName()::contains))
                return 2;

            else if (Arrays.stream(STATIC.PERMSD).parallel().anyMatch(r.getName()::contains))
                return 1;
            else
                event.getTextChannel().sendMessage(":warning: " + event.getAuthor().getAsMention() + " Du hast nicht die benötigsten Berechtigungen diesen Befehl auszuführen").queue();
        }
        return 0;
    }

    public static boolean check(Member event) {
        return false;
    }
}
