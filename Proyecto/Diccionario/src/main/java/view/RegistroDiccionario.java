package view;

import java.awt.*;
import javax.swing.*;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import model.Diccionario;

import static service.ApiService.generateUUID;

public class RegistroDiccionario extends JFrame {

    private DatabaseReference mDatabase;

    public RegistroDiccionario () {
        initComponents();
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
        txtSignificado = new JTextField();
        btnEnviar = new JButton();
        lblMenssagge = new JLabel("Mensaje de accion realizada");

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



        lblMenssagge.setForeground(new Color(255, 255, 255));
        lblMenssagge.setFont(new Font("Gilroy-Medium", 0, 15));
        imgFondo.add(lblMenssagge);
        lblMenssagge.setBounds(10, 432, 250, 18);


        this.getContentPane().add(imgFondo);


        // Setting Window
        this.setSize(new Dimension(800, 500));
        this.setTitle("Diccionario");
        //this.setIconImage(new ImageIcon(getClass().getResource("/img/LogoD.png")));
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }

    // Metodos
    public void writeNewUser(String palabra, String significado) {

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
    JTextField txtSignificado;
    JButton btnEnviar;
    JLabel lblMenssagge;
    // End Variable
    
}
