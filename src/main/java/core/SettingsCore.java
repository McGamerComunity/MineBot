package core;


import com.moandjiezana.toml.Toml;
import com.moandjiezana.toml.TomlWriter;
import net.dv8tion.jda.core.entities.Guild;
import org.json.JSONObject;
import util.STATIC;
import util.STATIC;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;



public class SettingsCore {


    public static void initialize() {

        JSONObject main = new JSONObject();

        JSONObject mysql = new JSONObject()
                .put("type", "sqlite")
                .put("host", "")
                .put("port", "3306")
                .put("username", "")
                .put("password", "")
                .put("database", "minebot");

        main    .put("token", "")
                .put("prefix", "-")
                .put("ownerid", "")
                .put("updateinfo", "false")
                .put("mysql", mysql);

        try {
            BufferedWriter br = new BufferedWriter(new FileWriter("SETTINGS.json"));
            br.write(main.toString());
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void loadSettings() throws IOException {

        if (!new File("SETTINGS.json").exists()) {
            initialize();
            System.out.println("Please open \"SETTINGS.json\" file and enter your discord token and owner ID there!");
            System.exit(-1);
        } else {

            BufferedReader br = new BufferedReader(new FileReader("SETTINGS.json"));
            String out = br.lines().collect(Collectors.joining("\n"));

            JSONObject obj = new JSONObject(out);

            STATIC.TOKEN           = obj.getString("token");
            STATIC.PREFIX          = obj.getString("prefix");
            STATIC.BOT_OWNER_ID    = (int) Long.parseLong(obj.getString("ownerid"));
            STATIC.UPDATEINFO      = Boolean.parseBoolean(obj.getString("updateinfo"));

            JSONObject mysql = obj.getJSONObject("mysql");
            STATIC.SQL_TYPE = mysql.getString("type");
            STATIC.SQL_HOST = mysql.getString("host");
            STATIC.SQL_PORT = mysql.getString("port");
            STATIC.SQL_USER = mysql.getString("username");
            STATIC.SQL_PASS = mysql.getString("password");
            STATIC.SQL_DB = mysql.getString("database");

        }

    }

}
