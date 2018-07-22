/**
 .___  ___.   ______   _______      ___      .___  ___.  _______ .______
 |   \/   |  /      | /  _____|    /   \     |   \/   | |   ____||   _  \
 |  \  /  | |  ,----'|  |  __     /  ^  \    |  \  /  | |  |__   |  |_)  |
 |  |\/|  | |  |     |  | |_ |   /  /_\  \   |  |\/|  | |   __|  |      /
 |  |  |  | |  `----.|  |__| |  /  _____  \  |  |  |  | |  |____ |  |\  \----.
 |__|  |__|  \______| \______| /__/     \__\ |__|  |__| |_______|| _| `._____|

 (c) 2014-2018
 */


package core;

import com.sun.corba.se.impl.activation.CommandHandler;
import com.sun.deploy.security.ruleset.DRSResult;
import commands.commands;
import commands.etc.BotStats;
import listeners.*;
import commands.*;
import commands.etc.Bug;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.entities.User;
import util.STATIC;

import javax.security.auth.login.LoginException;
import javax.xml.bind.annotation.XmlType;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;

public class Botstart {
    static JDABuilder builder;

    public static final CommandParser parser = new CommandParser();

    public static HashMap<String, commands> commands = new HashMap<>();

    public static JDA jda;

    private static MySql mySql;

    public static void main(String[] Args) throws InterruptedException, IOException {


        File users_dir = new File("USERS");
        if (!users_dir.exists() || !users_dir.isDirectory()) {
            System.out.println(
                    users_dir.mkdir() ? "[INFO] Path \"USERS\" successfully created!" : "[ERROR] Failed to create path \"USERS\"!"
            );
        }


        SettingsCore.loadSettings();

        BotStats.load();

        //mySql = new MySql(STATIC.SQL_HOST, STATIC.SQL_PORT, STATIC.SQL_USER, STATIC.SQL_PASS, STATIC.SQL_DB).initialize();

        JDABuilder builder = new JDABuilder(AccountType.BOT);

        builder = new JDABuilder(AccountType.BOT)
                .setToken(STATIC.TOKEN)
                .setAudioEnabled(true)
                .setAutoReconnect(true)
                .setStatus(STATIC.STATUS)
                .setGame(Game.streaming(STATIC.GAME + STATIC.CUSTOM_MESSAGE, "https://www.twitch.tv/mcgamer_comunity"))
        ;



        builder
                .addEventListener(new ReadyListener())
                .addEventListener(new VoiceListener())
                .addEventListener(new BotListener())
                .addEventListener(new CommandListener())
                .addEventListener(new privateMessageListener())
                .addEventListener(new ReactionListener())
                .addEventListener(new nickListener())
                .addEventListener(new BanListener())
                .addEventListener(new OnlineListener())
                .addEventListener(new Consolelistener())
                .addEventListener(new SecurityListener())
                .addEventListener(new MuteHanlder())
                //.addEventListener(new MsgListener());
                .addEventListener(new RuleListener())
        ;

        initializeListeners();
        initializeCommands();


        

        try {
            builder.buildBlocking();
        } catch (LoginException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    private static void initializeCommands() {
        commands.put("vote", new Vote());
        commands.put("help", new Help());
        commands.put("say", new Say());
        commands.put("botsay", new BotSay());
        commands.put("bug", new Bug());
        commands.put("clear", new Clear());
        commands.put("info", new Info());
        commands.put("about", new Info());
        commands.put("versionlog", new Versionlog());
        commands.put("changelog", new Versionlog());
        commands.put("music", new Music());
        commands.put("m", new Music());
        commands.put("cinfo", new UserInfo());
        commands.put("clientinfo", new UserInfo());
        commands.put("mute", new Mute());
        commands.put("plevel", new Permlvl());
        commands.put("bjoke", new BJoke());
        commands.put("bj", new BJoke());
        commands.put("joke", new JokeV2());
        commands.put("apply", new apply());
        commands.put("ri", new ri());
        commands.put("serverinfo", new serverinfo());
        commands.put("register", new register());
        commands.put("botstats", new BotStats());
    }

    private static void initializeListeners() {

    }
    
    public static void handleCommand(CommandParser.CommandContainer cmd) throws ParseException, IOException {

        if (commands.containsKey(cmd.invoke.toLowerCase())) {

            BotStats.commandsExecuted++;
            boolean safe = commands.get(cmd.invoke.toLowerCase()).called(cmd.args, cmd.event);

            if (!safe) {
                commands.get(cmd.invoke.toLowerCase()).action(cmd.args, cmd.event);
                commands.get(cmd.invoke.toLowerCase()).executed(safe, cmd.event);
            } else {
                commands.get(cmd.invoke.toLowerCase()).executed(safe, cmd.event);
            }
        }
    }


    public static MySql getMySql() {
        return mySql;
    }
}

