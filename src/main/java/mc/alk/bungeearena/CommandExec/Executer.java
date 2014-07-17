package mc.alk.bungeearena.CommandExec;

import mc.alk.bungeearena.Communication.*;
import net.md_5.bungee.api.*;
import net.md_5.bungee.api.chat.*;

/**
 * This will not change much.
 * Created by Ben Byers on 7/15/2014.
 */
public class Executer {
    public Executer(CommandSender sender, String[] args, String command, String... alias) {
        if (Receiver.getGameNames().contains(command.toLowerCase())) {
            GameExecutor.Execute(sender, command, args);

        } else if (Receiver.getEventNames().contains(command.toLowerCase())) {
            new EventExecutor(sender, command, args);
        } else if (command.equalsIgnoreCase("arena")) {
            new ArenaExecutor(sender, command, args);
            /* More actions can go here, we will check things like join so we can move them onto another server. */
        } else if (command.equalsIgnoreCase("team")) {
            new TeamExecutor(sender, command, args);
            /* More actions can go here, we will check things like join so we can move them onto another server. */
        }
        /*
        In Here we will perform all actions needed in the command system. All we need now is if
        statements to compare the command. To create a command all you need to do is Commands
        command = new Commands(command,permission,alias) permission default is null.
         */
    }
}
