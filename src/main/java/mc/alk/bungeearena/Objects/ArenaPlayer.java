package mc.alk.bungeearena.Objects;

import net.md_5.bungee.api.connection.*;

/**
 * Created by Ben Byers on 7/28/2014.
 */
public class ArenaPlayer {
    //TODO this class will contain all of the arena player traits in string/int format for easy movement. In addition it will also carry players previous server, current sever, and next server.
    static int count = 0;

    final int id = count++;
    /**
     * The BungeeCord player, refreshed with each new event having the player
     */
    ProxiedPlayer player;

}
