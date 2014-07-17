package mc.alk.bungeearena.Commands;

import mc.alk.bungeearena.*;
import mc.alk.bungeearena.Communication.*;
import net.md_5.bungee.api.plugin.*;

/**
 * Command Handler 1.0
 * Created by Ben Byers on 7/15/2014.
 */
public class Commands {
    /*
    This class handles all commands (Makes them)
     */
    private static Plugin plugin = Main.getPlugin();
    private static PluginManager server = plugin.getProxy().getPluginManager();

    public static void enable() {

        for (String event : Receiver.getEventNames()) {
            server.registerCommand(plugin, new Commander(event, null));
        }
        for (String game : Receiver.getGameNames()) {
            server.registerCommand(plugin, new Commander(game, null));

        }
        /* These are all static commands */
        server.registerCommand(plugin, new Commander("team", null));
        server.registerCommand(plugin, new Commander("arena", null));


    }
}
