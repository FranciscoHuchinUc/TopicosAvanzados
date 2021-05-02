package ejercicios2p;

import javax.swing.*;
import javax.swing.*;

public class User extends JFrame {

    public User(){
        initComponents();
    }

    public void initComponents(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new GridLayout());

        contPanel = new JPanel();
        imgFondo = new JLabel();
        btnAceptar = new JButton();

        contPanel.setLayout(null);}

        imgFondo.setText("Hola Mundo");
        contPanel.add(imgFondo);
        imgFondo.setBounds(160,70,180,128);

        btnAceptar.setText("Aceptar");
        contPanel.add(btnAceptar);
        btnAceptar.setBounds(170,120,73,23);

        getContentPane().add(contPanel);
    }

    public static void main(String args[]) {
        User user = new User();
    }

    // Variable
    JPanel contPanel;
    JLabel imgFondo;
    JButton btnAceptar;
    // End Variable
    
}