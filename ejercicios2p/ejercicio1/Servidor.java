package ejercicios2p.ejercicio1;

import java.io.*;
import java.net.*;

public class Servidor {

    ServerSocket server;
    BufferedReader in;
    PrintWriter out;

    public Servidor() throws IOException {
        // Crea un servidor en un puerto (5000)
        server = new ServerSocket(5000);
        // Acepta la peticon de un cliente y establecemos comunicaion con el
        Socket cc = server.accept();

        // establecemos la comunicaion
        in = new BufferedReader(new InputStreamReader(cc.getInputStream()));
        out = new PrintWriter(cc.getOutputStream());
    }

    public void read() throws IOException {
        String line = "";
        while (!line.equals("adios")) {
            line = in.readLine();
            switch (line) {
            case "hola":
                System.out.println("Me esta saludando");
                out.println("Hola tambien");
                out.flush();
                break;
            case "adios":
                System.out.println("Ya te vas?");
                out.println("Adios igual");
                out.flush();
                break;
            case "cual es mi calificacion":
                System.out.println("Solo para eso veniste?");
                out.println("0");
                out.flush();
                break;
            default:
                System.out.println(line);
                break;
            }
        }
        in.close();
        out.close();
    }

    public static void main(String args[]) {
        try {
            Servidor s = new Servidor();
            s.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}