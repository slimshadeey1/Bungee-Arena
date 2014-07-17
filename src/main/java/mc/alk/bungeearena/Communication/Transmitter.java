package mc.alk.bungeearena.Communication;

import net.md_5.bungee.api.config.*;

import java.io.*;

/**
 * Beta
 * Created by Ben Byers on 7/15/2014.
 */
public class Transmitter {
/* Perform Transmitting */

    public Transmitter(String channel, String subChannel, ServerInfo server, String msg) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        DataOutputStream data = new DataOutputStream(bytes);
        try {
            data.writeUTF(subChannel);
            data.writeShort(msg.length());
            data.writeUTF(msg);
            server.sendData(channel, bytes.toByteArray());
        } catch (IOException e) {
        }
    }
}

