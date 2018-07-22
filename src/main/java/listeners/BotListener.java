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

import commands.etc.BotStats;
import core.Botstart;
import core.SSSS;
import core.CoreCommands;
import net.dv8tion.jda.core.entities.ChannelType;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import util.STATIC;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import static commands.Ping.setInputTime;
import static sun.rmi.transport.TransportConstants.Ping;

public class BotListener extends ListenerAdapter{


    private void addToLogfile(MessageReceivedEvent e) throws IOException {

        File logFile = new File("CMDLOG.txt");
        BufferedWriter bw = new BufferedWriter(new FileWriter(logFile, true));

        if (!logFile.exists())
            logFile.createNewFile();

        bw.write(String.format("%s [%s (%s)] [%s (%s)] '%s'\n",
                CoreCommands.getCurrentSystemTime(),
                e.getGuild().getName(),
                e.getGuild().getId(),
                e.getAuthor().getName(),
                e.getAuthor().getId(),
                e.getMessage().getContentRaw()));
        bw.close();

    }


    @Override
    public void onMessageReceived(MessageReceivedEvent e) {

        BotStats.messagesProcessed++;

        if (e.getChannelType().equals(ChannelType.PRIVATE)) return;

        if (e.getMessage().getContentRaw().startsWith(STATIC.PREFIX) && e.getMessage().getAuthor().getId() != e.getJDA().getSelfUser().getId()) {
            setInputTime(new Date().getTime());

            try {
                Botstart.handleCommand(Botstart.parser.parse(e.getMessage().getContentRaw(), e));
                if (STATIC.commandConsoleOutout)
                    System.out.println(CoreCommands.getCurrentSystemTime() + " [Info] [Commands]: Command '" + e.getMessage().getContentRaw() + "' was executed by '" + e.getAuthor() + "' (" + e.getGuild().getName() + ")!");
                ArrayList<String> list = new ArrayList<>();
                list.add(e.getGuild().getId());
                list.add(CoreCommands.getCurrentSystemTime());
                list.add(e.getMember().getEffectiveName());
                list.add(e.getMessage().getContentRaw());
                STATIC.cmdLog.add(list);
                addToLogfile(e);
            } catch (ParseException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

}

