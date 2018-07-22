package commands;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import util.MSGS;

import java.io.IOException;
import java.text.ParseException;

public class apply implements commands {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) throws IOException, ParseException {

        event.getTextChannel().sendMessage(MSGS.success()
                .addField("Du kannst dich unter folgender E-Mail bewerben:","apply@ragefx.de" , false)
                .addField("Vorraussetzungen:", "-Alter: mind. 14(<13 => informiere dich im support)\n-Geistige Reife\n-Vorkenntnisse Gern gesehen(mit serverangabe)", false)
                .addField("Wie sollte meine Bewerbung\nstrukturiert sein:", "1.Persönliches\n2.Warum bin ich als Teammitglied bei ragefx.de geeignet\n3. Was sind meine Ziele bei ragefx.de\n4.Meine Stärken und Schwächen\n5.Schlusssatz(wenn du noch was loswerden willst)", false)

                .build()).complete();

    }

    @Override
    public void executet(boolean sucess, MessageReceivedEvent event) {

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
