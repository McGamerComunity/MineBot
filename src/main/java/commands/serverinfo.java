package commands;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.MessageEmbed;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import util.MSGS;
import util.STATIC;

import java.awt.*;
import java.io.IOException;
import java.text.ParseException;
import java.time.format.DateTimeFormatter;

import static core.Botstart.jda;

public class serverinfo implements commands {


    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }



    private static int members = 0;
    private static int emotes = 0;
    private static int vchan = 0;
    private static int tchan = 0;
    private static int omembers = 0;

    private static void count() {
        members++;
    }
    private static void countemotes() {
        emotes++;
    }

    private static void countvchan() {
        vchan++;
    }

    private static void counttchan() {
        tchan++;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) throws IOException, ParseException {

        event.getGuild().getMembers().forEach(members -> count());

        event.getGuild().getEmotes().forEach(emotes -> countemotes());

        event.getGuild().getVoiceChannels().forEach(vchan -> countvchan());

        event.getGuild().getTextChannels().forEach(tchan -> counttchan());

        User owner = event.getGuild().getOwner().getUser();

        event.getTextChannel().sendMessage(new EmbedBuilder()

                .setAuthor(event.getGuild().getName() + " - " + event.getGuild().getId() , "http://discord.gg/" + STATIC.DISCORD, event.getGuild().getIconUrl())
                .setThumbnail(event.getGuild().getIconUrl())
                .setColor(new Color(0x71FF0F))

                .addField("Owner", owner.getName() + "#" + owner.getDiscriminator() + "\n" + owner.getAsMention() , false)

                .addField("Member[" + members + "]",  omembers + " Members Online", true)
                .addField("Region", event.getGuild().getRegion().getName(), true)

                .addField("Voice Channels", String.valueOf(vchan), true)
                .addField("Text Channels", String .valueOf(tchan), true)


                .addField("Emotes:", String.valueOf(emotes), false)

                .addField("Guild Created", event.getGuild().getCreationTime().format(DateTimeFormatter.ofPattern("yyyy/MM/dd - HH:mm:ss")), false)

        .build()).queue();
        members = 0;
        emotes = 0;
        vchan = 0;
        tchan = 0;
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
