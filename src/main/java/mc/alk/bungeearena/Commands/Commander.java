package mc.alk.bungeearena.Commands;

/**
 * Cleaned up
 * Created by Ben Byers on 7/15/2014.
 */

import mc.alk.bungeearena.CommandExec.*;
import net.md_5.bungee.api.*;
import net.md_5.bungee.api.plugin.*;

public class Commander extends Command {
    String name;
    String[] aliases;

    public Commander(String name, String permission, String... Alias) {
        super(name, permission, Alias);
        this.name = name;
        this.aliases = Alias;
        //null is for permissions, null = everyone
    }

    public String getCommand() {
        return name;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        Executer executor = new Executer(sender, args, this.getName(), getAliases());
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String[] getAliases() {
        return this.aliases;
    }
}
