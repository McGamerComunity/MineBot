/**
 .___  ___.   ______   _______      ___      .___  ___.  _______ .______
 |   \/   |  /      | /  _____|    /   \     |   \/   | |   ____||   _  \
 |  \  /  | |  ,----'|  |  __     /  ^  \    |  \  /  | |  |__   |  |_)  |
 |  |\/|  | |  |     |  | |_ |   /  /_\  \   |  |\/|  | |   __|  |      /
 |  |  |  | |  `----.|  |__| |  /  _____  \  |  |  |  | |  |____ |  |\  \----.
 |__|  |__|  \______| \______| /__/     \__\ |__|  |__| |_______|| _| `._____|

 (c) 2014-2018
 */

package commands;

import commands.commands;
import core.Botstart;
import core.SSSS;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.PrivateChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import util.STATIC;

import java.awt.*;
import java.lang.reflect.Field;
import java.util.*;



public class Help implements commands {


    EmbedBuilder eb = new EmbedBuilder();

    private String getPermPre(int lvl) {
        switch (lvl) {
            case 1: return ":small_blue_diamond:";
            case 2: return ":small_orange_diamond:";
            case 3: return ":small_red_triangle_down:";
            case 4: return ":octagonal_sign:";
            case 5: return ":diamonds:";
            case 10: return ":large_orange_diamond:";
            case 50: return ":unlock:";
            case 1000: return ":octagonal_sign:";
            case 10000: return ":lock:";
            default: return ":white_small_square:";
        }
    }


    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {

        if (args.length > 0) {
            if (Botstart.commands.containsKey(args[0]))
                if (Botstart.commands.get(args[0]).help() != null)
                    event.getTextChannel().sendMessage(
                            eb.setColor(new Color(22, 138, 233)).setDescription(Botstart.commands.get(args[0]).help()).build()
                    ).queue();
                else
                    event.getTextChannel().sendMessage(
                            eb.setColor(Color.red).setDescription(":warning:  There are currently no information for the command  *-" + args[0] + "* !").build()
                    ).queue();
            else
                event.getTextChannel().sendMessage(
                        eb.setColor(Color.red).setDescription(":warning:  The command list does not contains information for the command *-" + args[0] + "* !").build()
                ).queue();
            return;
        }

        event.getMessage().delete().queue();

        Map<String, String> cmds = new TreeMap<>();
        Botstart.commands.forEach((s, command) -> cmds.put(s, command.description()));

        StringBuilder ciams = new StringBuilder();

        String[] ignorers = {"bpoll", "test", "r", "c", "bj", "ttt", "userinfo", "dev", "nudge", "poll", "moveall", "purge", "info", "suggestion", "r6", };
        Arrays.stream(ignorers).forEach(s -> cmds.remove(s));


        try {

            PrivateChannel pc = event.getAuthor().openPrivateChannel().complete();
            pc.sendMessage(":clipboard:  __**COMMAND LIST**__  :clipboard: \n\n" +
                    "***Legend:***\n" +
                    "  :white_small_square:  -  Usable for everyone\n" +
                    "  :small_blue_diamond:  -  Only for groups `" + Arrays.toString(STATIC.PERMSD).replace("[", "").replace("]", "") + "`\n" +
                    "  :small_orange_diamond:  -  Only for groups `" + Arrays.toString(STATIC.PERMSC).replace("[", "").replace("]", "") + "`\n" +
                    "  :small_red_triangle_down:  -  Only for owner of the server\n"
                    + "\n\n___").queue();

            ciams.delete(0, ciams.length());
            ciams.append("**" + STATIC.CMDTYPE.administration + "**\n");
            cmds.keySet().stream()
                    .filter(s -> Botstart.commands.get(s).commandType().equals(STATIC.CMDTYPE.administration))
                    .forEach(s1 -> ciams.append(
                            getPermPre(Botstart.commands.get(s1).permission()) + "  **" + s1 + "**   -   `" + cmds.get(s1) + "`\n"
                    ));
            pc.sendMessage(new EmbedBuilder().setColor(new Color(134, 255, 0)).setDescription(ciams.toString()).build()).queue();

            ciams.delete(0, ciams.length());
            ciams.append("**" + STATIC.CMDTYPE.chatutils + "**\n");
            cmds.keySet().stream()
                    .filter(s -> Botstart.commands.get(s).commandType().equals(STATIC.CMDTYPE.chatutils))
                    .forEach(s1 -> ciams.append(
                            getPermPre(Botstart.commands.get(s1).permission()) + "  **" + s1 + "**   -   `" + cmds.get(s1) + "`\n"
                    ));
            pc.sendMessage(new EmbedBuilder().setColor(new Color(255, 97, 0)).setDescription(ciams.toString()).build()).queue();

            ciams.delete(0, ciams.length());
            ciams.append("**" + STATIC.CMDTYPE.essentials + "**\n");
            cmds.keySet().stream()
                    .filter(s -> Botstart.commands.get(s).commandType().equals(STATIC.CMDTYPE.essentials))
                    .forEach(s1 -> ciams.append(
                            getPermPre(Botstart.commands.get(s1).permission()) + "  **" + s1 + "**   -   `" + cmds.get(s1) + "`\n"
                    ));
            pc.sendMessage(new EmbedBuilder().setColor(new Color(255, 0, 213)).setDescription(ciams.toString()).build()).queue();

            ciams.delete(0, ciams.length());
            ciams.append("**" + STATIC.CMDTYPE.etc + "**\n");
            cmds.keySet().stream()
                    .filter(s -> Botstart.commands.get(s).commandType().equals(STATIC.CMDTYPE.etc))
                    .forEach(s1 -> ciams.append(
                            getPermPre(Botstart.commands.get(s1).permission()) + "  **" + s1 + "**   -   `" + cmds.get(s1) + "`\n"
                    ));
            pc.sendMessage(new EmbedBuilder().setColor(new Color(39, 0, 255)).setDescription(ciams.toString()).build()).queue();

            ciams.delete(0, ciams.length());
            ciams.append("**" + STATIC.CMDTYPE.guildadmin + "**\n");
            cmds.keySet().stream()
                    .filter(s -> Botstart.commands.get(s).commandType().equals(STATIC.CMDTYPE.guildadmin))
                    .forEach(s1 -> ciams.append(
                            getPermPre(Botstart.commands.get(s1).permission()) + "  **" + s1 + "**   -   `" + cmds.get(s1) + "`\n"
                    ));
            pc.sendMessage(new EmbedBuilder().setColor(new Color(0, 233, 255)).setDescription(ciams.toString()).build()).queue();

            ciams.delete(0, ciams.length());
            ciams.append("**" + STATIC.CMDTYPE.music + "**\n");
            cmds.keySet().stream()
                    .filter(s -> Botstart.commands.get(s).commandType().equals(STATIC.CMDTYPE.music))
                    .forEach(s1 -> ciams.append(
                            getPermPre(Botstart.commands.get(s1).permission()) + "  **" + s1 + "**   -   `" + cmds.get(s1) + "`\n"
                    ));
            pc.sendMessage(new EmbedBuilder().setColor(new Color(0, 255, 126)).setDescription(ciams.toString()).build()).queue();

            ciams.delete(0, ciams.length());
            ciams.append("**" + STATIC.CMDTYPE.settings + "**\n");
            cmds.keySet().stream()
                    .filter(s -> Botstart.commands.get(s).commandType().equals(STATIC.CMDTYPE.settings))
                    .forEach(s1 -> ciams.append(
                            getPermPre(Botstart.commands.get(s1).permission()) + "  **" + s1 + "**   -   `" + cmds.get(s1) + "`\n"
                    ));
            pc.sendMessage(new EmbedBuilder().setColor(new Color(255, 233, 0)).setDescription(ciams.toString()).build()).queue();

        } catch (Exception e) {
            e.printStackTrace();
        }


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
        return "\"Ich brauch keine Hilfe...\" :D";
    }

    @Override
    public String commandType() {
        return STATIC.CMDTYPE.essentials;
    }

    @Override
    public int permission() {
        return 0;
    }
}
