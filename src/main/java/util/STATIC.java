package util;

import com.sedmelluq.discord.lavaplayer.source.twitch.TwitchStreamAudioTrack;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.Game;

import java.text.SimpleDateFormat;
import java.util.Date;

public class STATIC {


    public static final String[] PERMS = {"", "*", "Owner"};          /*PERMISSIONLEVEL 5*/

    public static final String[] PERMSA = {"Co-Owner"};          /*PERMISSIONLEVEL 4*/

    public static final String[] PERMSB = {"---"};          /*PERMISSIONLEVEL 3*/

    public static final String[] PERMSC = {"---"};          /*PERMISSIONLEVEL 2*/

    public static final String[] PERMSD = {"---"};          /*PERMISSIONLEVEL 1*/

    public static String PREFIX = "mb ";

    public static String VERSION = "2.9 ALPHA";
    public static final String TOKEN = "NDM3Mjg0MTc4OTUwNjE5MTQ2.Dbz0KA.SZaYALD2LsOusAtGNQWTLRYm08E";
    public static String CUSTOM_MESSAGE = "By McGamer";
    public static String LICENCE = "H00m5mmh-B5A5OMjL-EjYbSmYC-96urfO0c-A9vlKy3d-vRqF7Y7U-pALSRb92-ViwBL9Ep6a";
    public static int BOT_OWNER_ID = 0;

    public static String GAME = PREFIX + "help | v." + VERSION + " | " + CUSTOM_MESSAGE;

    public static OnlineStatus STATUS = OnlineStatus.IDLE;


    public class CMDTYPE {
        public static final String administration = "Administration";
        public static final String chatutils = "Chat Utilities";
        public static final String essentials = "Essentials";
        public static final String etc = "Etc";
        public static final String music = "Music";
        public static final String guildadmin = "Guild Administration";
        public static final String settings = "SettingsCore";
    }



    public static String getTime() {
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd - HH:mm:ss");
        return df.format(date.getTime());
    }



}
