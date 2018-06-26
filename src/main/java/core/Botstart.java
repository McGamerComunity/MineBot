package core;

import commands.commands;
import listeners.*;
import commands.*;
import commands.etc.Bug;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Game;
import util.STATIC;

import javax.security.auth.login.LoginException;
import java.awt.*;
import java.io.IOException;
import java.util.HashMap;

public class Botstart {
    public static final commandHandler parser = new commandHandler();
    static JDABuilder builder;


    public static HashMap<String, commands> commands = new HashMap<>();

    public static JDA jda;

    private static MySql mySql;

    public static void main(String[] Args) throws InterruptedException, IOException {

        SettingsCore.loadSettings();

//        mySql = new MySql(STATIC.SQL_HOST, STATIC.SQL_PORT, STATIC.SQL_USER, STATIC.SQL_PASS, STATIC.SQL_DB).initialize();

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
                .addEventListener(new MuteHanlder())
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
        commandHandler.commands.put("mute", new Mute());
        commandHandler.commands.put("plevel", new Permlvl());


        try {
            builder.buildBlocking();
        } catch (LoginException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static MySql getMySql() {
        return mySql;
    }
}

