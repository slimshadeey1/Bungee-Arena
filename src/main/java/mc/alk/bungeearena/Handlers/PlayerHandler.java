package mc.alk.bungeearena.Handlers;

import mc.alk.bungeearena.*;
import mc.alk.bungeearena.Communication.*;
import mc.alk.bungeearena.Util.*;
import net.md_5.bungee.api.connection.*;

import java.util.*;

/**
 * Created by Ben Byers on 7/20/2014.
 */
public class PlayerHandler {
    /**
     * I should investigate latency at some point.
     * Created by Ben Byers on 7/16/2014.
     */
    public PlayerHandler(byte[] data) {
        //Initialize data into converter. Dump raw string in... get good stuff back :)
        RawDataConverter newData = new RawDataConverter(data, true);
        //Get all of the necessary variables and define them here
        ArrayList<String> dat = newData.getArgs();
        ProxiedPlayer player = Main.getPlugin().getProxy().getPlayer(dat.get(2));
        String serverName = newData.getServerName();
        String server = player.getServer().getInfo().getName();
        ArrayList<String> serverOn = new ArrayList<>();
        String uuid = newData.getUuid();
        serverOn.add(server);
        new Transmitter("BattlePlayers", serverOn, uuid, serverName);
    }
}
