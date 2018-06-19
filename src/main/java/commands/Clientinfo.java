package commands;

import net.dv8tion.jda.client.managers.EmoteManager;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Emote;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import util.STATIC;

import java.awt.*;
import java.io.IOException;
import java.text.ParseException;
import java.util.Timer;
import java.util.TimerTask;

public class Clientinfo implements commands {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) throws IOException, ParseException {


        User User = event.getMessage().getMentionedUsers().get(0);


         Message msg = event.getTextChannel().sendMessage(new EmbedBuilder()
                .setColor(new Color((int)(Math.random() * 0x1000000)))
                .setAuthor(User.getName() + "'s Clientinformation", null, User.getDefaultAvatarUrl())
                .setThumbnail(User.getAvatarUrl())
                .addField("Full Name:", "`" + User.getName() + "#" + User.getDiscriminator() + "`", false)
                .addField("Mention:", User.getAsMention(), false)
                .addField("Discriminator:", User.getDiscriminator(), false)
                .addField("Avatar ID:", User.getAvatarId(), false)
                .addField("Avatar URL:", User.getAvatarUrl(), false)
                .addField("Default Avatar ID:", User.getDefaultAvatarId(), false)
                .addField("Default Avatar URL:", User.getDefaultAvatarUrl(), false)
                .addField("Effective Avatar Url:", User.getEffectiveAvatarUrl(), false)
                .addField("UserID:", User.getId(), false)
                .addField("Is Bot:", String.valueOf(User.isBot()), false)
                .build()).complete();

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                msg.addReaction("⏰").queue();
            }
        }, 0);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {

            }
        }, 1000);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {

            }
        }, 2000);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {

            }
        }, 3000);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {

            }
        }, 4000);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {

            }
        }, 5000);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {

            }
        }, 6000);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {

            }
        }, 7000);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {

            }
        }, 8000);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                
            }
        }, 9000);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                msg.delete().queue();
            }
        }, 10000);


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
