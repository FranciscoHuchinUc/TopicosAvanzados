package ejercicios2p.ejercicio2;

import java.io.*;
import java.net.*;

public class Atendedor extends Thread {

    Socket c;
    BufferedReader in;
    PrintWriter out;

    public Atendedor(Socket client) throwsIOException {
        this.c = client;
        in = new BufferedReader(new InputStreamReader(c.getInputStream()));
        out = new PrintWriter(c.getOutputStream());
    }

    @Override
    public void run() {
        String line = "";
        while (!line.equals("adios")) {
            try {
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
                        in.close();
                        out.close();
                        break;
                    case "cual es mi calificacion":
                        System.out.println("Solo para eso veniste?");
                        out.println("0");
                        out.flush();
                        break;
                    default:
                        System.out.println(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
