package mc.alk.bungeearena.Communication;

import mc.alk.bungeearena.Handlers.*;
import mc.alk.bungeearena.Util.*;
import net.md_5.bungee.api.connection.*;
import net.md_5.bungee.api.plugin.*;
import net.md_5.bungee.event.*;

import java.io.*;
import java.util.*;


/**
 * Created by Ben Byers on 7/15/2014.
 * Beta
 */
public class Receiver implements Listener {

    private static HashMap<String, String> EventMap = new HashMap<>();
    private static HashMap<String, String> GameMap = new HashMap<>();

    private static ArrayList<String> EventNames;

    private static ArrayList<String> GameNames;


    @EventHandler
    public static void PluginMessageEvent(Connection sender, Connection receiver, String tag, byte[] data) {


        if (tag.equals("BungeeCord")) {

                /*Perform subchannel decryption as well as data parsing */

            try {


                DataInputStream in = new DataInputStream(new ByteArrayInputStream(data));
                String subchannel = in.readUTF();
                short len;
                byte[] bytes;
                String dataRaw;
                String Server;

                switch (subchannel) {


                    case "BattleArenaEventNames":
                        len = in.readShort();
                        bytes = new byte[len];
                        in.readFully(data);
                        dataRaw = new String(data);
                        RawDataConverter EventData = new RawDataConverter(dataRaw, true);
                        EventNames = EventData.getNames();
                        Server = EventData.getServerName();
                        for (String s : EventNames) {
                            EventMap.put(s, Server);
                        }
                        break;


                    case "BattleArenaGameNames":
                        len = in.readShort();
                        bytes = new byte[len];
                        in.readFully(data);
                        dataRaw = new String(data);
                        RawDataConverter GameData = new RawDataConverter(dataRaw, true);
                        GameNames = GameData.getNames();
                        Server = GameData.getServerName();
                        for (String s : GameData.getNames()) {
                            GameMap.put(s, Server);
                        }
                        break;


                    case "CommandResponse":            /* I would like the rest of the channels to be executed in this fashion. */
                        len = in.readShort();
                        bytes = new byte[len];
                        in.readFully(data);
                        dataRaw = new String(data);
                        new CommandHandler(dataRaw);
                        break;


                    case "BattleTeams":
                        len = in.readShort();
                        bytes = new byte[len];
                        in.readFully(data);
                        dataRaw = new String(data);
                        new CommandHandler(dataRaw); //Change
                        break;


                    case "BattlePlayers":
                        len = in.readShort();
                        bytes = new byte[len];
                        in.readFully(data);
                        dataRaw = new String(data);
                        new CommandHandler(dataRaw); //Change
                        break;


                    case "BattleStats":
                        len = in.readShort();
                        bytes = new byte[len];
                        in.readFully(data);
                        dataRaw = new String(data);
                        new CommandHandler(dataRaw); //Change
                        break;


                    default:
                        break;
                }


            } catch (Exception x) {
            }
        }
    }

    public static ArrayList<String> getEventNames() {
        return EventNames;
    }

    public static ArrayList<String> getGameNames() {
        return GameNames;
    }

    public static HashMap<String, String> getGameMap() {
        return GameMap;
    }

    public static HashMap<String, String> getEventMap() {
        return EventMap;
    }

}
