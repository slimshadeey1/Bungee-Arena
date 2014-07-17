package mc.alk.bungeearena.Util;

import com.google.common.io.*;
import mc.alk.bungeearena.*;
import net.md_5.bungee.api.config.*;
import net.md_5.bungee.api.connection.*;

import java.io.*;
import java.util.*;

/**
 * This is a beta version and will be expanded as new string parsing jobs become necessary.
 * Created by Ben Byers on 7/16/2014.
 */
public class RawDataConverter {
    ProxiedPlayer player;
    ServerInfo server;
    String command;
    ArrayList<String> args;
    String serverName;
    String playerName;
    ArrayList<String> response;
    Integer argsLength;
    Integer resLength;



    public RawDataConverter(byte[] Commanddata,boolean commandresponse) {
        if(commandresponse) {
            try {
                ByteArrayInputStream bais = new ByteArrayInputStream(Commanddata);
                DataInputStream in = new DataInputStream(bais);
                serverName = in.readUTF();
                playerName = in.readUTF();
                command = in.readUTF();
                argsLength = in.readInt();
                byte[] bytes = new byte[argsLength];
                in.readFully(bytes);
                DataInputStream subIn = new DataInputStream(new ByteArrayInputStream(bytes));
                while (subIn.available() > 0) {
                    args.add(in.readUTF());
                }
                resLength = in.readInt();
                byte[] bytes1 = new byte[resLength];
                DataInputStream subIn1 = new DataInputStream(new ByteArrayInputStream(bytes1));
                while (subIn1.available() > 0) {
                    response.add(in.readUTF());
                }
            } catch (IOException e) {
            }
        }
                // Use the code sample in the 'Response' sections below to read
                // the data.

    }

    public ArrayList<String> getArgs() {
        return args;
    }

    public ArrayList<String> getResponse() {
        return response;
    }

    public String getResponseString() {
        String newResponse = "";
        for (String s : response) {
            newResponse = newResponse + " " + s;
        }
        return newResponse;
    }

    public ServerInfo getServer() {
        return server;
    }

    public String getCommand() {
        return command;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getServerName() {
        return serverName;
    }

    public ProxiedPlayer getPlayer() {
        return player;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
