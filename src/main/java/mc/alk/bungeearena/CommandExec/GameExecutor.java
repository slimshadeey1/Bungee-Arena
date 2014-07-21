package mc.alk.bungeearena.CommandExec;

import mc.alk.bungeearena.*;
import mc.alk.bungeearena.Communication.*;
import net.md_5.bungee.api.*;
import net.md_5.bungee.api.config.*;
import net.md_5.bungee.api.connection.*;

import java.util.*;

/**
 * Version 1.0
 * Created by Ben Byers on 7/16/2014.
 */
public class GameExecutor {
    public GameExecutor(CommandSender sender, String command, String[] args) {

        String servername = Receiver.getGameMap().get(command.toLowerCase());

        String playername = sender.getName();

        ProxiedPlayer player = Main.getPlugin().getProxy().getPlayer(playername);
        String option;
        try {
            option = args[0];
        }catch (ArrayIndexOutOfBoundsException e){
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
                player.sendMessage("A help message will go here :)");
                break;
        }
    }
}
