package mliot.monitor.util;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Util {

    public static final int MONITOR_PORT_NUMBER = 1771;
    private static final Logger logger = Logger.getLogger(Util.class.getCanonicalName());

    public static String getIpAddress() {
        try(final DatagramSocket socket = new DatagramSocket()){
            socket.connect(InetAddress.getByName("google.com"), 443);
            return socket.getLocalAddress().getHostAddress();
        } catch (UnknownHostException | SocketException e) {
            logger.log(Level.SEVERE, "Error while reading server's IP address", e);
            return null;
        }
    }
}
