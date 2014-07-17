package mc.alk.bungeearena.Util;

import mc.alk.bungeearena.*;
import net.md_5.bungee.api.config.*;
import net.md_5.bungee.api.connection.*;

import java.util.*;

/**
 * This is a beta version and will be expanded as new string parsing jobs become necessary.
 * Created by Ben Byers on 7/16/2014.
 */
public class RawDataConverter {
    ProxiedPlayer player;
    ServerInfo server;
    String command;
    ArrayList<String> args;
    String serverName;
    String playerName;
    ArrayList<String> response;
    ArrayList<String> Names;

    public RawDataConverter(String Commanddata) {
        playerName = Commanddata.split(".")[1].split("=")[0];
        serverName = Commanddata.split(".")[0];
        String[] commandRaw = Commanddata.split(".")[1].split("=")[1].replace(";", "").split(" ");
        player = Main.getPlugin().getProxy().getPlayer(playerName);
        server = Main.getPlugin().getProxy().getServerInfo(serverName);
        Integer argsLen = Integer.getInteger(commandRaw[0]);
        command = commandRaw[1];
        args = new ArrayList<>();
        for (int i = 2; i == argsLen; i++) {
            args.add(commandRaw[i]);
        }
        for (int i = argsLen + 1; i == commandRaw.length; i++) {
            response.add(commandRaw[i]);
        }
    }

    public RawDataConverter(String rawData, Boolean NameFind) { ///TODO Figure out how I want the other channel syntax to work
        String[] originalNames = rawData.split(":")[1].replace(";", "").split(",");
        for (String s : originalNames) {
            Names.add(s);
        }
        serverName = rawData.split(":")[0];
        server = Main.getPlugin().getProxy().getServerInfo(serverName);
        if (NameFind) {
            Main.getPlugin().getLogger().info("Converting Message");
        }
    }

    public ArrayList<String> getArgs() {
        return args;
    }

    public ArrayList<String> getResponse() {
        return response;
    }

    public String getResponseString() {
        String newResponse = "";
        for (String s : response) {
            newResponse = newResponse + " " + s;
        }
        return newResponse;
    }

    public ServerInfo getServer() {
        return server;
    }

    public String getCommand() {
        return command;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getServerName() {
        return serverName;
    }

    public ProxiedPlayer getPlayer() {
        return player;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public ArrayList<String> getNames() {
        return Names;
    }
}
