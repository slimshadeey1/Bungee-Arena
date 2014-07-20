package mc.alk.bungeearena.Handlers;

import mc.alk.bungeearena.*;
import mc.alk.bungeearena.Util.*;
import net.md_5.bungee.api.config.*;
import net.md_5.bungee.api.connection.*;

import java.util.*;

/**
 * I should investigate latency at some point.
 * Created by Ben Byers on 7/16/2014.
 */
public class CommandHandler {
    public CommandHandler(ArrayList<String> data, ServerInfo server) {
        //Initialize data into converter. Dump raw string in... get good stuff back :)
        //Get all of the necessary variables and define them here
        ProxiedPlayer player = Main.getPlugin().getProxy().getPlayer(data.get(0));
        String response = "";
        for (String s : data) {
            if (data.indexOf(s) == 0) {
                return;
            }
            response = response + " " + s;
        }
        String finalResponse = sb(response, player.getName(), server.getName()).toString();

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

