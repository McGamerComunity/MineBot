package commands;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import util.MSGS;

import java.io.IOException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.stream.Collectors;

public class ri implements commands {

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) throws IOException, ParseException {
        String input = Arrays.stream(args).skip(0).map(s -> " " + s).collect(Collectors.joining()).substring(0);
        String msg = input;
        msg += input.replace("a", ":regional_indicator_a:")
        .replace("b", ":regional_indicator_b:")
        .replace("c", ":regional_indicator_c:")
        .replace("d", ":regional_indicator_d:")
        .replace("e", ":regional_indicator_e:")
        .replace("f", ":regional_indicator_f:")
        .replace("g", ":regional_indicator_g:")
        .replace("h", ":regional_indicator_h:")
        .replace("i", ":regional_indicator_i:")
        .replace("j", ":regional_indicator_j:")
        .replace("k", ":regional_indicator_k:")
        .replace("l", ":regional_indicator_l:")
        .replace("m", ":regional_indicator_m:")
        .replace("n", ":regional_indicator_n:")
        .replace("o", ":regional_indicator_o:")
        .replace("p", ":regional_indicator_p:")
        .replace("q", ":regional_indicator_q:")
        .replace("r", ":regional_indicator_r:")
        .replace("s", ":regional_indicator_s:")
        .replace("t", ":regional_indicator_t:")
        .replace("u", ":regional_indicator_u:")
        .replace("v", ":regional_indicator_v:")
        .replace("w", ":regional_indicator_w:")
        .replace("x", ":regional_indicator_x:")
        .replace("y", ":regional_indicator_y:")
        .replace("z", ":regional_indicator_z:");

        event.getTextChannel().sendMessage(MSGS.success().setDescription(msg).build()).queue();
        event.getMessage().delete().queue();
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
