package practica3.ventana;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class UserInterface extends JFrame {

    public UserInterface() {
    }

    public void initComponets() {
        this.setLayout(new BorderLayout());

        btnIP = new JButton("Obtner Ip");

        btnDirectorio = new JButton("Directorios");

        btnDocPrincipal = new JButton("Documento Principal");

        btnTiempo = new JButton("Tiempo de Carga");

        // Personalizacion de la ventana
        this.setSize(800, 500);
        this.setLocationRelativeTo(null);
        // this.setResizable(false);
        this.setVisible(true);
    }

    // Variables declaration
    JButton btnIP;
    JButton btnDirectorio;
    JButton btnDocPrincipal;
    JButton btnTiempo;
    JPanel contButtons;
    JPanel contInterface;
    JTextField txtResultado;
    JScrollPane scrollPane;
    // End of variables declaration

}
