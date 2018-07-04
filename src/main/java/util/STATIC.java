package util;

import com.oracle.deploy.update.UpdateInfo;
import com.sedmelluq.discord.lavaplayer.source.twitch.TwitchStreamAudioTrack;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.Game;

import java.text.SimpleDateFormat;
import java.util.Date;

public class STATIC {


    public static final String[] PERMS = {" ", "*", "Owner"};          /*PERMISSIONLEVEL 5*/

    public static final String[] PERMSA = {"Co-Owner" + PERMS};          /*PERMISSIONLEVEL 4*/

    public static final String[] PERMSB = {"Admin" + PERMSA};          /*PERMISSIONLEVEL 3*/

    public static final String[] PERMSC = {"Teammitglied" + PERMSB};          /*PERMISSIONLEVEL 2*/

    public static final String[] PERMSD = {"Freunde" + PERMSC};          /*PERMISSIONLEVEL 1*/

    public static String PREFIX = "mb ";

    public static String VERSION = "2.10 ALPHA";
    public static String TOKEN = secrets.token;
    public static String CUSTOM_MESSAGE = "By McGamer";
    public static String LICENCE = secrets.licence;
    public static int BOT_OWNER_ID = 0;
    public static boolean UPDATEINFO = true;

    public static String GAME = PREFIX + "help | v." + VERSION + " | " + CUSTOM_MESSAGE;

    public static OnlineStatus STATUS = OnlineStatus.ONLINE;


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
