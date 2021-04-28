package ejercicios2p.ejercicio1;

import java.io.*;
import java.net.*;

public class Cliente {

    Socket socket;
    BufferedReader in;
    PrintWriter out;

    public Cliente() throws UnknownHostException, IOException {
        socket = new Socket("localhost", 5000);

        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream());
    }

    public void write( String mssg) throws IOException{
        out.println(mssg);
        out.flush();
        String line = in.readLine();
        System.out.println(line);
    }

    public void bye() throws IOException{
        in.close();
        out.close();
    }

    public static void main(String[] args){
        try {
            Cliente c = new Cliente();
            String line = "";
            while(!line.equals("adios")){
                BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
                line = in.readLine();
                c.write(line);
            }
            c.bye();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
