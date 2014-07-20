package mc.alk.bungeearena.Handlers;

import mc.alk.bungeearena.Util.*;
import net.md_5.bungee.api.connection.*;

/**
 * I should investigate latency at some point.
 * Created by Ben Byers on 7/16/2014.
 */
public class CommandHandler {
    public CommandHandler(byte[] data) {
        //Initialize data into converter. Dump raw string in... get good stuff back :)
        RawDataConverter newData = new RawDataConverter(data,true);
        //Get all of the necessary variables and define them here
        ProxiedPlayer player = newData.getPlayer();
        String response = newData.getResponseString();
        String playerName = newData.getPlayerName();
        String serverName = newData.getServerName();

        String finalResponse = sb(response, playerName, serverName).toString();

        player.sendMessage(finalResponse);
    }

    private static StringBuilder sb(String msg, String player, String server) {
        String msg1 = msg.replaceAll("<player>", player);
        String msg2 = msg1.replaceAll("<server>", server);
        StringBuilder msg3 = new StringBuilder(msg2);
        if (msg.contains("<0>") | msg.equalsIgnoreCase("Error") | msg.isEmpty()) {
            msg3.replace(0, msg3.length(), "Uh oh! An error has occurred, please contact your server administrator!");
            return msg3;
        } else {
            return msg3;

        }
    }
}

