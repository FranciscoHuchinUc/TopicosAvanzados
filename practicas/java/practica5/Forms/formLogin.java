package Forms;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

import Conexion.Connect;

import java.awt.event.*;

public class formLogin extends JFrame {

    public formLogin() {
        initComponents();
    }

    private void initComponents() {
        getContentPane().setLayout(new GridLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Borde
        line = BorderFactory.createLineBorder(new Color(237, 237, 238));
        empty = new EmptyBorder(0, 10, 0, 0);
        border = new CompoundBorder(line, empty);

        // Inicializacion de las Variables
        lblTittle = new JLabel("Sign In");
        lblUsuario = new JLabel("Usuario");
        txtUsuario = new JTextField();
        placeHolder = new TextPlaceHolder("Nombre de Usuario", txtUsuario);
        lblPassword = new JLabel("Password");
        txtPassword = new JPasswordField();
        placeHolder = new TextPlaceHolder("Contraseña", txtPassword);
        btnLogin = new JButton("LOGIN");

        pnlLogin = new JPanel();
        pnlLogin.setLayout(null);
        pnlLogin.setBackground(Color.WHITE);
        pnlLogin.setSize(400, 500);

        // Titulo del Form
        lblTittle.setForeground(new Color(48, 55, 70));
        lblTittle.setFont(new Font("Segoe UI", 1, 25));
        pnlLogin.add(lblTittle);
        lblTittle.setBounds(170, 50, 98, 40);

        // Usuario
        lblUsuario.setForeground(new Color(48, 55, 70));
        lblUsuario.setFont(new Font("Segoe UI", 0, 15));
        pnlLogin.add(lblUsuario);
        lblUsuario.setBounds(53, 150, 67, 27);

        txtUsuario.setForeground(new Color(48, 55, 70));
        txtUsuario.setBackground(new Color(240, 240, 249));
        txtUsuario.setBorder(border);
        txtUsuario.setFont(new Font("Segoe UI", 0, 15));
        pnlLogin.add(txtUsuario);
        txtUsuario.setBounds(140, 150, 198, 35);

        // Password
        lblPassword.setForeground(new Color(48, 55, 70));
        lblPassword.setFont(new Font("Segoe UI", 0, 15));
        pnlLogin.add(lblPassword);
        lblPassword.setBounds(53, 220, 67, 27);

        txtPassword.setForeground(new Color(48, 55, 70));
        txtPassword.setBackground(new Color(237, 237, 238));
        txtPassword.setBorder(border);
        txtPassword.setFont(new Font("Segoe UI", 0, 15));
        pnlLogin.add(txtPassword);
        txtPassword.setBounds(140, 220, 198, 35);

        // Boton Login
        btnLogin.setBackground(new Color(48, 55, 70));
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setFont(new Font("Segoe UI", 1, 15));
        btnLogin.setFocusable(false);
        btnLogin.setBorder(null);
        pnlLogin.add(btnLogin);
        btnLogin.setBounds(50, 300, 290, 37);
        btnLogin.addActionListener(e -> btnLoginActionPerformed(e));

        imgLogo = new JLabel();

        imgLogo.setIcon(new ImageIcon(getClass().getResource("/src/login.jpg")));

        getContentPane().add(imgLogo, BorderLayout.WEST);
        getContentPane().add(pnlLogin, BorderLayout.EAST);

        // Setting Window
        this.setSize(800, 500);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void btnLoginActionPerformed(ActionEvent e) {
        try {
            Connect connect = new Connect();
            connect.connectionDB();
            String user = txtUsuario.getText();
            String pass = txtPassword.getText();
            
            if(connect.accesDB(user, pass)){
                new formLoginOk(this, true);
            } else {
                new formLoginError(this, true);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // Variables declaration

    JLabel lblTittle;
    JLabel lblUsuario;
    JTextField txtUsuario;
    JLabel lblPassword;
    JPasswordField txtPassword;
    JLabel strMensaje;
    JLabel imgLogo;
    JPanel pnlLogin;
    JButton btnLogin;
    TextPlaceHolder placeHolder;
    Border line;
    Border empty;
    CompoundBorder border;

    // End of variables declaration

}
