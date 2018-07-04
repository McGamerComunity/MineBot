package core;

import com.sun.deploy.security.ruleset.DRSResult;
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
import javax.xml.bind.annotation.XmlType;
import java.awt.*;
import java.io.IOException;
import java.util.HashMap;

public class Botstart {
    public static final commandHandler parser = new commandHandler();
    public static JDABuilder builder;

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
                .setGame(Game.streaming(STATIC.GAME, "https://www.twitch.tv/mcgamer_comunity"))
        ;




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
                //.addEventListener(new MsgListener())
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
        commandHandler.commands.put("bjoke", new BJoke());
        commandHandler.commands.put("bj", new BJoke());
        commandHandler.commands.put("joke", new JokeV2());
        commandHandler.commands.put("apply", new apply());


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

