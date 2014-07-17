package mc.alk.bungeearena.Util;

import mc.alk.bungeearena.*;
import net.md_5.bungee.api.config.*;
import net.md_5.bungee.api.connection.*;

import java.io.*;
import java.util.*;

/**
 * Created by Ben Byers on 7/17/2014.
 */
public class NamesFormatter {
    public ArrayList<String> Names = new ArrayList<>();
    public String serverName = "";
    public ServerInfo server;
    public NamesFormatter(byte[] bytes){
        try {
            ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
            DataInputStream in = new DataInputStream(bais);
            serverName = in.readUTF();
            while (in.available()-1 > 0) {
                Names.add(in.readUTF());
            }
        }catch (IOException e){}
    }

    public ArrayList<String> getNames() {
        return Names;
    }

    public String getServerName() {
        return serverName;
    }

    public ServerInfo getServer() {
        server = Main.getPlugin().getProxy().getServerInfo(serverName);
        return server;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
