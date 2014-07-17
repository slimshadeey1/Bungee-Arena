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
        plugin.getProxy().registerChannel("BungeeCord");
        plugin = this;
        Commands.enable();
        this.getProxy().getPluginManager().registerListener(this, new Receiver());
        // You should not put an enable message in your plugin.
        // BungeeCord already does so
        getLogger().info("Yay! It loads!");
    }
}
