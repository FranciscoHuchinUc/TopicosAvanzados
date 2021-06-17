package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import model.Diccionario;
import model.TextPlace;

import static service.ApiService.initFirebase;
import static service.ApiService.generateUUID;

public class RegistroDiccionario extends JFrame {

    private DatabaseReference mDatabase;

    public RegistroDiccionario () {
        initComponents();
        initFirebase();
    }

    private void initComponents() {
        // Action Close Window
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.getContentPane().setLayout(new GridLayout());

        imgFondo = new JLabel();
        imgFondo.setIcon(new ImageIcon(getClass().getResource("/img/Fondo.png")));

        lblTitle = new JLabel("DICCIONARIO MAYA");
        btnConectar = new JButton("Conectar");
        lblInformacion = new JLabel("Rellene el formulario");
        txtPalabra = new JTextField();
        txtSignificado = new JTextArea();
        btnEnviar = new JButton();
        lblMenssagge = new JLabel("Bienvenido...");

        // Borde of JTextField
        Border line = BorderFactory.createLineBorder(new Color(84, 68, 23));
        Border empty = new EmptyBorder(0, 8, 0, 8);
        CompoundBorder border = new CompoundBorder(line, empty);

        lblTitle.setForeground(new Color(255, 255, 255));
        lblTitle.setFont(new Font("Gilroy-Heavy", 0, 20));
        imgFondo.add(lblTitle);
        lblTitle.setBounds(283, 45, 235, 32);

        btnConectar.setBackground(new Color(0, 0, 0, 0));
        btnConectar.setIcon(new ImageIcon(getClass().getResource("/img/Conectar.png")));
        btnConectar.setBorder(null);
        btnConectar.setBorderPainted(false);
        btnConectar.setContentAreaFilled(false);
        btnConectar.setFocusable(false);
        imgFondo.add(btnConectar);
        btnConectar.setBounds(626, 67, 140, 30);

        lblInformacion.setForeground(new Color(255, 255, 255));
        lblInformacion.setFont(new Font("Gilroy-Medium", 0, 16));
        imgFondo.add(lblInformacion);
        lblInformacion.setBounds(200, 124, 250, 19);

        txtPalabra.setBackground(new Color(84, 68, 23));
        txtPalabra.setForeground(new Color(255, 255, 255));
        txtPalabra.setFont(new Font("Gilroy-Medium", 0, 18));
        txtPalabra.setCaretColor(new Color(255, 255, 255));
        txtPalabra.setBorder(border);
        txtPlace = new TextPlace("Palabra o frase", txtPalabra);   
        imgFondo.add(txtPalabra);
        txtPalabra.setBounds(200, 165, 400, 52);

        txtSignificado.setBackground(new Color(84, 68, 23));
        txtSignificado.setForeground(new Color(255, 255, 255));
        txtSignificado.setFont(new Font("Gilroy-Medium", 0, 18));
        txtSignificado.setCaretColor(new Color(255, 255, 255));
        txtSignificado.setBorder(border);
        txtPlace = new TextPlace("Significado de la palabra o frase", txtSignificado);   
        imgFondo.add(txtSignificado);
        txtSignificado.setBounds(200, 247, 400, 115);

        btnEnviar.setBackground(new Color(0, 0, 0, 0));
        btnEnviar.setIcon(new ImageIcon(getClass().getResource("/img/Enviar.png")));
        btnEnviar.setBorder(null);
        btnEnviar.setBorderPainted(false);
        btnEnviar.setContentAreaFilled(false);
        btnEnviar.setFocusable(false);
        imgFondo.add(btnEnviar);
        btnEnviar.setBounds(337, 400, 126, 30);
        btnEnviar.addActionListener(e -> btnEnviarActionPerformed(e));

        lblMenssagge.setForeground(new Color(255, 255, 255));
        lblMenssagge.setFont(new Font("Gilroy-Medium", 0, 15));
        imgFondo.add(lblMenssagge);
        lblMenssagge.setBounds(10, 432, 250, 18);


        this.getContentPane().add(imgFondo);


        // Setting Window
        this.setSize(new Dimension(800, 500));
        this.setTitle("Diccionario");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }

    // Listeners
    private void btnEnviarActionPerformed (ActionEvent e) {
        if(!txtPalabra.getText().isEmpty() && !txtSignificado.getText().isEmpty()) {
            lblMenssagge.setText("Ingresando Registro");
            nuevoRegistroDb(txtPalabra.getText(), txtSignificado.getText());
        } else {
            lblMenssagge.setText("No puede dejar ningun campo vacio");
        }
    }

    // Metodos
    public void nuevoRegistroDb(String palabra, String significado) {

        mDatabase = FirebaseDatabase.getInstance().getReference().child("Diccionario");
        
        Diccionario dic = new Diccionario();
        dic.setPalabra(palabra);
        dic.setSignificado(significado);

        mDatabase.child(generateUUID()).setValue(dic, new DatabaseReference.CompletionListener(){
            @Override
            public void onComplete(DatabaseError error, DatabaseReference ref) {
                System.out.println("Finish");
            }
        });
        
    }


    // Variable Declaration
    JLabel imgFondo;
    JLabel lblTitle;
    JButton btnConectar;
    JLabel lblInformacion;
    JTextField txtPalabra;
    JTextArea txtSignificado;
    TextPlace txtPlace;
    JButton btnEnviar;
    JLabel lblMenssagge;
    // End Variable
    
}
