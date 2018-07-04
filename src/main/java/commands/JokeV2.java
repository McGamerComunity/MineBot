package commands;

import commands.commands;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import org.json.JSONException;
import org.json.JSONObject;
import util.STATIC;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.ParseException;



public class JokeV2 implements commands {

    private JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = rd.readLine();
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }

    private String get() {

        String out = "";

        try {
            out = readJsonFromUrl("http://api.yomomma.info").getString("joke");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return out;
    }


    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) throws ParseException, IOException {

        event.getMessage().delete().queue();
        event.getTextChannel().sendMessage(new EmbedBuilder().setColor(new Color(0xFF00C7)).setDescription(get()).build()).queue();

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
        return "Throw around with some yo mama jokes";
    }

    @Override
    public String commandType() {
        return STATIC.CMDTYPE.chatutils;
    }

    @Override
    public int permission() {
        return 0;
    }
}