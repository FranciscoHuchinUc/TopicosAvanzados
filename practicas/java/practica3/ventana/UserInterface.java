package practicas.java.practica3.ventana;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

import practicas.java.practica3.directorio.Directorios;
import practicas.java.practica3.docprincipal.DocumentoPrincipal;
import practicas.java.practica3.ip.DireccionIp;
import practicas.java.practica3.tiempo.TiempoCarga;

public class UserInterface extends JFrame {

    String host1 = "itescam.edu.mx";
    String host = "https://itescam.edu.mx";

    public UserInterface() {
        initComponets();
    }

    public void initComponets() {
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        btnIP = new JButton("Obtner Ip");
        btnIP.setFocusable(false);
        btnIP.addActionListener(e -> btnIPActionPerformed(e));

        btnDirectorio = new JButton("Directorios");
        btnDirectorio.setFocusable(false);
        btnDirectorio.addActionListener(e -> btnDirectorioActionPerformed(e));

        btnDocPrincipal = new JButton("Documento Principal");
        btnDocPrincipal.setFocusable(false);
        btnDocPrincipal.addActionListener(e -> btnDocPrincipalActionPerformed(e));

        btnTiempo = new JButton("Tiempo de Carga");
        btnTiempo.setFocusable(false);
        btnTiempo.addActionListener(e -> btnTiempoDeCargarActionPerformed(e));

        contButtons = new JPanel();
        contButtons.add(btnIP);
        contButtons.add(btnDirectorio);
        contButtons.add(btnDocPrincipal);
        contButtons.add(btnTiempo);

        txtResultado = new JTextArea();
        txtResultado.setFont(new Font("Monospaced", 0, 16));
        txtResultado.setMargin(new Insets(20, 20, 20, 20));
        txtResultado.setFocusable(false);
        txtResultado.setRequestFocusEnabled(false);

        scrollPane = new JScrollPane();
        scrollPane.setBorder(null);
        //scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setFocusTraversalPolicyProvider(true);
        scrollPane.setViewportView(txtResultado);

        add(contButtons, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Personalizacion de la ventana
        this.setSize(800, 500);
        this.setLocationRelativeTo(null);
        // this.setResizable(false);
        this.setVisible(true);
    }

    private void btnIPActionPerformed(ActionEvent e) {
        txtResultado.setText("");
        dirIP = new DireccionIp();
        txtResultado.setText("Direccion IP \n"
                + dirIP.direccion(host1));
    }

    private void btnDirectorioActionPerformed(ActionEvent e) {
        txtResultado.setText("");
        dirs = new Directorios();
        txtResultado.setText("Documento Principal \n"
                + Arrays.toString(dirs.directoriosExtistentes(host)));
    }

    private void btnDocPrincipalActionPerformed(ActionEvent e) {
        txtResultado.setText("");
        docP = new DocumentoPrincipal();
        txtResultado.setText("Documento principal: \n"
                + docP.getHTML(host));
    }

    private void btnTiempoDeCargarActionPerformed(ActionEvent e) {
        txtResultado.setText("");
        time = new TiempoCarga();
        txtResultado.setText("Tiempo de Carga \n"
                + time.carga(host1) + " Segundos");
    }

    // Variables declaration
    JButton btnIP;
    JButton btnDirectorio;
    JButton btnDocPrincipal;
    JButton btnTiempo;
    JPanel contButtons;
    JScrollPane scrollPane;
    JTextArea txtResultado;
    DireccionIp dirIP;
    Directorios dirs;
    DocumentoPrincipal docP;
    TiempoCarga time;
    // End of variables declaration
}
