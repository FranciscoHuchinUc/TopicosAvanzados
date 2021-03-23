package ejercicios.ejercicio1;

import java.awt.*;
import java.awt.event.*;

public class Main extends Frame {

    /**
     * Francisco Huchin
     */
    private static final long serialVersionUID = 1L;

    public Main() {
        
        //Declaracion del Tamaño de la ventana y si es Visible  o No
        this.setSize(300, 200);
        this.setVisible(true);
        
    }

    public static void main(String[] args) {
        Main window = new Main();
        window.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

}
