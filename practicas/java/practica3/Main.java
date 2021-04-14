package practica3;

import java.util.Arrays;

import practica3.directorio.Directorios;
import practica3.ip.DireccionIp;
import practica3.tiempo.TiempoCarga;

public class Main {

    public static void main(String[] args) {

        String host1 = "itescam.edu.mx";
        String host = "https://itescam.edu.mx";

        DireccionIp ip = new DireccionIp();
        System.out.println(ip.direccion(host1));
        
        TiempoCarga t = new TiempoCarga();
        System.out.println(t.carga(host));
        
        Directorios dir = new Directorios();
        System.out.println(Arrays.toString(dir.directoriosExtistentes(host)));
        System.out.println(dir.getTam());
    }
    
}
