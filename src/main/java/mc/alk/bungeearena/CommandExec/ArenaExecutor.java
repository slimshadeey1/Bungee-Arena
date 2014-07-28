package mc.alk.bungeearena.CommandExec;

import mc.alk.bungeearena.*;
import mc.alk.bungeearena.Communication.*;
import net.md_5.bungee.api.*;
import net.md_5.bungee.api.connection.*;

import java.util.*;

/**
 * TODO This class still needs to be changed to fit all the requirements of the arena commands. I just have created this to have something here for now. It will follow this basic structure.
 * Created by Ben Byers on 7/16/2014.
 */
public class ArenaExecutor {
    public ArenaExecutor(CommandSender sender, String command, String[] args) {

        String servername = null;///TODO Find how alkarin stores arena names or how he knows where they are. Take the and do the same thing as event and game. Make a map of each arena - server pair and call the arena name to get the server

        String playername = sender.getName();


        ProxiedPlayer player = Main.getPlugin().getProxy().getPlayer(playername);
        String option;
        try {
            option = args[0];
        } catch (ArrayIndexOutOfBoundsException e) {
            option = "null";
        }
        ArrayList<String> data = new ArrayList<>();
        data.add(playername);
        data.add(command);
        for (String s : args) {
            data.add(s);
        }
        switch (option.toLowerCase()) {
            case "join":
                try {
                    wait(3);
                    player.connect(Main.getPlugin().getProxy().getServerInfo(servername));
                } catch (Exception e) {
                }
                new PlayerTransmitter(player, "BattleArenaCommand", data, servername);
                break;
            case "leave":
                new Transmitter("BattleArenaCommand", servername, data);
                break;
            case "info":
                new Transmitter("BattleArenaCommand", servername, data);
                break;
            case "option":
                new Transmitter("BattleArenaCommand", servername, data);
                break;
            case "status":
                new Transmitter("BattleArenaCommand", servername, data);
                break;
            case "check":
                new Transmitter("BattleArenaCommand", servername, data);
                break;
            default:
                player.sendMessage("ChannelCommandAPI!");//TODO Find out why players receive two messages per command.
                break;
        }
    }
}
