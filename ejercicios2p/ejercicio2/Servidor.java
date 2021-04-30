package ejercicios2p.ejercicio2;

import java.io.*;
import java.net.*;

public class Servidor {

    ServerSocket server;
    BufferedReader in;
    PrintWriter out;

    public Servidor() throws IOException {
        // Crea un servidor en un puerto (5000)
        server = new ServerSocket(5000);

    }

    public void start() throws IOException {
        while (true) {
            System.out.println("Escuchando un nuevo cliente");
            // Acepta la peticon de un cliente
            Socket cc = server.accept();
            new Atendedor(cc).start();
        }
    }

    public static void main(String args[]) {
        try {
            Servidor s = new Servidor();
            s.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}