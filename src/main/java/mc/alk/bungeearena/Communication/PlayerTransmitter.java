package mc.alk.bungeearena.Communication;

import net.md_5.bungee.api.connection.*;

import java.io.*;

/**
 * Created by Ben Byers on 7/16/2014.
 */
public class PlayerTransmitter {
    private ProxiedPlayer player;
    private String channel;
    private ByteArrayOutputStream bytes;

    public PlayerTransmitter(ProxiedPlayer player, String channel, String subChannel, String msg) {
        bytes = new ByteArrayOutputStream();
        DataOutputStream data = new DataOutputStream(bytes);
        player = player;
        try {
            data.writeUTF(subChannel);
            data.writeShort(msg.length());
            data.writeUTF(msg);
            player.sendData(channel, bytes.toByteArray());
        } catch (IOException e) {
        }
    }
}
