package mc.alk.bungeearena;

import mc.alk.bungeearena.Commands.*;
import mc.alk.bungeearena.Communication.*;
import net.md_5.bungee.api.plugin.*;

/**
 * Created by Ben Byers on 7/15/2014.
 */
public class Main extends Plugin {
    private static Plugin plugin;

    public static Plugin getPlugin() {
        return plugin;
    }

    @Override
    public void onEnable() {
        plugin = this;
        plugin.getProxy().registerChannel("BungeeCord");
        plugin.getProxy().registerChannel("BattleArena");
        Commands.enable();
        this.getProxy().getPluginManager().registerListener(this, new Receiver());
    }
}
