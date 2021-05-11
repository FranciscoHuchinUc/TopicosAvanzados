package practicas.java.practica3.ip;

import java.net.*;

public class DireccionIp {
    public String direccion(String host) {
        try {
            //Obtencion de ip con el objeto socket
            Socket socket = new Socket(host, 80);
            String ip = socket.getInetAddress().getHostAddress();
            return ip;
        } catch (Exception e) {
        }
        return null;
    }
}
