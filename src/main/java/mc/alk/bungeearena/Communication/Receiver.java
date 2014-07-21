package mc.alk.bungeearena.Communication;

import mc.alk.bungeearena.Handlers.*;
import mc.alk.bungeearena.Util.*;
import net.md_5.bungee.api.connection.*;
import net.md_5.bungee.api.event.*;
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
    public static void PluginMessageEvent(PluginMessageEvent event) {
        String tag = event.getTag();
        byte[] data = event.getData();

        if (tag.equals("BattleArena")) {

                /*Perform subchannel decryption as well as data parsing */

            try {


                DataInputStream in = new DataInputStream(new ByteArrayInputStream(data));
                String subchannel = in.readUTF();
                short len;
                byte[] bytes;
                String dataRaw;
                String Server;

                switch (subchannel) {


                    case "EventNames":
                        BAConverter EventData = new BAConverter(in);
                        EventNames = EventData.getData();
                        Server = EventData.getServer();
                        for (String s : EventNames) {
                            EventMap.put(s, Server);
                        }
                        break;


                    case "GameNames":
                        BAConverter GameData = new BAConverter(in);
                        GameNames = GameData.getData();
                        Server = GameData.getServer();
                        for (String s : GameNames) {
                            GameMap.put(s, Server);
                        }
                        break;


                    case "CommandResponse":            /* I would like the rest of the channels to be executed in this fashion. */
                        BAConverter command = new BAConverter(in);
                        new CommandHandler(command.getData(), command.getServerInfo());
                        break;


                    case "BattleTeams":
                        BAConverter teams = new BAConverter(in);
                        break;


                    case "BattlePlayers":
                        BAConverter players = new BAConverter(in);
                        break;


                    case "BattleStats":
                        BAConverter stats = new BAConverter(in);
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
