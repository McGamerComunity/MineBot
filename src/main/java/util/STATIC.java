package util;

import com.oracle.deploy.update.UpdateInfo;
import com.sedmelluq.discord.lavaplayer.source.twitch.TwitchStreamAudioTrack;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.Game;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.stream.Stream;

public class STATIC {

    public static final String[] PERMSALL = {" ", "*"};

    public static final String[] PERMS = {"Owner"};          /*PERMISSIONLEVEL 5*/

    public static final String[] PERMSA = {"Co-Owner"};          /*PERMISSIONLEVEL 4*/

    public static final String[] PERMSB = {"Admin"};          /*PERMISSIONLEVEL 3*/

    public static final String[] PERMSC = {"Teammitglied"};          /*PERMISSIONLEVEL 2*/

    public static final String[] PERMSD = {"Freunde"};          /*PERMISSIONLEVEL 1*/

    public static String PREFIX = "mb ";

    public static String VERSION = "2.10 ALPHA";
    public static String LVERSION = "github querry failed";
    public static String TOKEN = secrets.token;                     /*TOP SECRET TOKEN*/
    public static String CUSTOM_MESSAGE = "By McGamer";
    public static String[] LICENCE = secrets.licence;               /* FUN FEATURE - CAN BE USED FOR SELLING THE BOT ---- CODE FROM secrets.java public static String[] licence = {"licence 1", "licence 2", ...};*/
    public static String DISCORD = "MD3Nasp";
    public static String BOT_OWNER_ID = "273115881960374272";
    public static boolean UPDATEINFO = true;

    public static String GAME = PREFIX + "help | v." + VERSION + " | ";

    public static OnlineStatus STATUS = OnlineStatus.ONLINE;

    public static String input;


    public static int music_volume = 10;
    public static String musicChannel = "RageRadio";


    public class CMDTYPE {
        public static final String administration = "Administration";
        public static final String chatutils = "Chat Utilities";
        public static final String essentials = "Essentials";
        public static final String etc = "Etc";
        public static final String music = "Music";
        public static final String guildadmin = "Guild Administration";
        public static final String settings = "SettingsCore";
    }
    public static String SQL_TYPE = "";
    public static String SQL_HOST = "";
    public static String SQL_PORT = "";
    public static String SQL_USER = "";
    public static String SQL_PASS = "";
    public static String SQL_DB = "";


    public static String getTime() {
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd - HH:mm:ss");
        return df.format(date.getTime());
    }

    public static String msglink(String id, String msg) {
        String link;
        link = "https://www.ragefx.de/minebot/message.php?id=" + id + "&msg=" + msg;

        return link;
    }

    public static String userlink(String id, String name) {
        String link;
        link = "https://www.ragefx.de/minebot/user.php?id=" + id /*+ "&name=" + name*/;

        return link;
    }



}
