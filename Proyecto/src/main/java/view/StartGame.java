package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static service.ApiService.initFirebase;

public class StartGame extends JFrame {

    public StartGame () {
        initFirebase();
        initComponents();
    }

    public void initComponents () {
        // Action Close Window
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.getContentPane().setLayout(new GridLayout());

        imgBackground = new JLabel();
        imgBackground.setIcon(new ImageIcon(getClass().getResource("/img/Background.jpg")));

        imgLogo = new JLabel();
        imgLogo.setIcon(new ImageIcon(getClass().getResource("/img/Logo.png")));
        imgBackground.add(imgLogo);
        imgLogo.setBounds(341, 62, 129, 139);

        btnLogin = new JButton();
        btnLogin.setIcon(new ImageIcon(getClass().getResource("/img/Login.png")));
        btnLogin.setBorder(null);
        btnLogin.setBorderPainted(false);
        btnLogin.setContentAreaFilled(false);
        btnLogin.setFocusable(false);
        imgBackground.add(btnLogin);
        btnLogin.setBounds(306, 236, 198, 35);
        btnLogin.addActionListener(e -> btnLoginActionPerformed(e));
        
        btnRegister = new JButton();
        btnRegister.setIcon(new ImageIcon(getClass().getResource("/img/Register.png")));
        btnRegister.setBorder(null);
        btnRegister.setBorderPainted(false);
        btnRegister.setContentAreaFilled(false);
        btnRegister.setFocusable(false);
        imgBackground.add(btnRegister);
        btnRegister.setBounds(306, 297, 198, 35);
        btnRegister.addActionListener(e -> btnRegisterActionPerformed(e));

        btnExit = new JButton();
        btnExit.setIcon(new ImageIcon(getClass().getResource("/img/iconExit.png")));
        btnExit.setToolTipText("Salir");
        btnExit.setBorder(null);
        btnExit.setBorderPainted(false);
        btnExit.setContentAreaFilled(false);
        btnExit.setFocusable(false);
        imgBackground.add(btnExit);
        btnExit.setBounds(765, 355, 35, 35);
        btnExit.addActionListener(e -> btnExitActionPerformed(e));


        this.getContentPane().add(imgBackground);


        // Settings Window
        this.setSize(810, 400);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setUndecorated(true);
        this.setVisible(true);

    }

    // Metodos and Listeners
    private void btnExitActionPerformed(ActionEvent e) {
        System.exit(0);
    }

    private void btnRegisterActionPerformed(ActionEvent e){
        new UserRegister(this, true);
    }

    private void btnLoginActionPerformed(ActionEvent e){
        new UserLogin(this, true);
    }

    // Variable Declaration
    JLabel imgBackground;
    JLabel imgLogo;

    
    JButton btnLogin;
    JButton btnRegister;
    JButton btnExit;
    // End Variable
    
}
