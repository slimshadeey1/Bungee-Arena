package mc.alk.bungeearena.Communication;

import com.google.common.io.*;
import mc.alk.bungeearena.*;
import net.md_5.bungee.api.config.*;
import net.md_5.bungee.api.plugin.*;

import java.io.*;
import java.util.*;

/**
 * Beta
 * Created by Ben Byers on 7/15/2014.
 */
public class Transmitter {
/* Perform Transmitting */
    private Plugin plugin = Main.getPlugin();
    public Transmitter(String subChannel,ArrayList<String> message,Integer id,String server) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream(); //Converted
        DataOutputStream data = new DataOutputStream(bytes); //Message will be
        ByteArrayDataOutput out = ByteStreams.newDataOutput();

        //Define Sub Channel
        out.writeUTF(subChannel);

        try {
            for (String s:message) {
                data.writeUTF(s);
            }
            data.writeShort(id);
        }catch (IOException e){}
        out.writeShort(bytes.toByteArray().length);
        out.write(bytes.toByteArray());

        plugin.getProxy().getServerInfo(server).sendData("BattleArena",out.toByteArray());
    }
    public Transmitter(String subChannel, String command, String playerName, ArrayList<String> args, String server) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream(); //Converted
        DataOutputStream data = new DataOutputStream(bytes); //Message will be
        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        //Define Sub Channel
        out.writeUTF(subChannel);
        out.writeUTF(server);
        try {
                data.writeUTF(playerName);
                data.writeUTF(command);
                ByteArrayOutputStream bytes1 = new ByteArrayOutputStream(); //Converted
                DataOutputStream subOut = new DataOutputStream(bytes1);
                for (String s : args) {
                    subOut.writeUTF(s);
                }
                data.writeInt(bytes1.toByteArray().length);
                data.write(bytes1.toByteArray());
            } catch (IOException e) {
            out.writeShort(bytes.toByteArray().length);
            out.write(bytes.toByteArray());
        }


        plugin.getProxy().getServerInfo(server).sendData("BattleArena",out.toByteArray());
    }
}

