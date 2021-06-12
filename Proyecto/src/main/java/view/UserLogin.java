package view;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import model.Laberinto;
import model.Usuario;
// import static service.ApiService.initFirebase;

public class UserLogin extends JDialog {

    private DatabaseReference mDatabase;

    public UserLogin (JFrame frame, boolean modal) {
        super(frame, modal);
        initComponents();
        // initFirebase();
    }

    public void initComponents () {
        // Layout Window
        this.getContentPane().setLayout(new GridLayout());

        laberinto = new Laberinto();

        //Create Varibles And Add Window
        jPBackground = new JLabel();
        jPBackground.setIcon(new ImageIcon(getClass().getResource("/img/fondoLogin.jpg")));
        
        btnCerrar = new JButton();
        lblTiulo = new JLabel("<html>Bienvenido <P>Inicie Sesion</html>");
        lblUser = new JLabel("Usuario");
        txtUserName = new JTextField();
        lblPassword = new JLabel("Constraseña");
        txtPassword = new JPasswordField();
        btnLogin = new JButton("Iniciar Sesion");
        lblMessage = new JLabel("");
        
        // Borde of JTextField
        Border line = BorderFactory.createLineBorder(Color.WHITE);
        Border empty = new EmptyBorder(0, 8, 0, 8);
        CompoundBorder border = new CompoundBorder(line, empty);
        
        btnCerrar.setIcon(new ImageIcon(getClass().getResource("/img/icon_close.png")));
        btnCerrar.setToolTipText("Salir");
        btnCerrar.setBorder(null);
        btnCerrar.setBorderPainted(false);
        btnCerrar.setContentAreaFilled(false);
        btnCerrar.setFocusable(false);
        btnCerrar.setBounds(560, 10, 25, 25);
        jPBackground.add(btnCerrar);
        btnCerrar.addActionListener (e -> btnCerrarActionPerformed(e));
        
        lblTiulo.setForeground(new Color(0, 0, 0));
        lblTiulo.setFont(new Font("SF Pro Display", 5, 30));
        jPBackground.add(lblTiulo);
        lblTiulo.setBounds(300, 39, 250, 72);

        lblUser.setForeground(new Color(112, 112, 112));
        lblUser.setFont(new Font("SF Pro Display Medium", 0, 15));
        jPBackground.add(lblUser);
        lblUser.setBounds(304, 126, 51, 18);

        txtUserName.setBackground(new Color(229, 229, 229));
        txtUserName.setFont(new Font("SF Display", 1, 15));
        txtUserName.setBorder(border);
        jPBackground.add(txtUserName);
        txtUserName.setBounds(304, 144, 197, 30);

        lblPassword.setForeground(new Color(112, 112, 112));
        lblPassword.setFont(new Font("SF Pro Display Medium", 0, 15));
        jPBackground.add(lblPassword);
        lblPassword.setBounds(304, 196, 90, 15);

        txtPassword.setBackground(new Color(229, 229, 229));
        txtPassword.setFont(new Font("SF Pro Display", 1, 15));
        txtPassword.setBorder(border);
        jPBackground.add(txtPassword);
        txtPassword.setBounds(304, 214, 197, 30);

        lblMessage.setForeground(new Color(112, 112, 112));
        lblMessage.setFont(new Font("SF Pro Display Regular", 0, 15));
        jPBackground.add(lblMessage);
        lblMessage.setBounds(23, 315, 250, 18);

        btnLogin.setBackground(new Color(80, 218, 32));
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setFont(new Font("SF Pro Display", 5, 20));
        btnLogin.setBorder(border);
        btnLogin.setFocusable(false);
        jPBackground.add(btnLogin);
        btnLogin.setBounds(320, 273, 166, 35);
        btnLogin.addActionListener(e -> btnLoginActionPerformed(e));


        this.getContentPane().add(jPBackground);


        // Settings Window
        this.setSize(600, 350);
        this.setUndecorated(true);
        this.setBackground(new Color(0, 0, 0, 0));
        this.setLocationRelativeTo(null);
        //this.setOpacity(0.9f);
        this.setVisible(true);
    }

    // Metodos and Listeners
    private void btnCerrarActionPerformed(ActionEvent evt) {
        this.dispose();
    }


    private void btnLoginActionPerformed(ActionEvent e){
        if(!txtUserName.getText().isEmpty() && !txtPassword.getText().isEmpty()){
            lblMessage.setText("Iniciando Sesion...");
            readDataLogin();
        } else {
            lblMessage.setText("No puede dejar ningun campo vacio");
        }
    }
    
    
    private void readDataLogin() {
        
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Usuarios");
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    Usuario user = ds.getValue(Usuario.class);
                    if(user.getUsername().equals(txtUserName.getText()) && user.getPassword().equals(txtPassword.getText())){
                        try {
                            lblMessage.setText("Inicio de Sesion Correcto");
                            new ViewGame();
                            laberinto.setNameUser(user.getUsername());
                            laberinto.repaint();
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        dispose();
                        break;
                    } else {
                        lblMessage.setText("Error de Usuario y/o Contraseña");
                    }
                }
            }
            @Override
            public void onCancelled(DatabaseError de) {
                System.out.println(de.getDetails());
            }
        });
        
    }



    // Variable Declaration
    JLabel jPBackground;
    JButton btnCerrar;
    JLabel lblTiulo;
    JLabel lblUser;
    JTextField txtUserName;
    JLabel lblPassword;
    JPasswordField txtPassword;
    JLabel lblMessage;
    JButton btnLogin;
    Laberinto laberinto;
    // End Variables

    
}
