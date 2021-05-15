package Forms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class formLoginOk extends JDialog {

    public formLoginOk(JFrame jframe, boolean modal) {
        initComponents();
    }

    private void initComponents() {
        getContentPane().setLayout(new GridLayout());

        imgDialog = new JLabel();
        imgDialog.setIcon(new ImageIcon(getClass().getResource("/src/JDialogForm.png")));

        imgAccepted = new JLabel();
        imgAccepted.setIcon(new ImageIcon(getClass().getResource("/src/OK.png")));
        imgAccepted.setBounds(130, 25, 120, 120);
        imgDialog.add(imgAccepted);

        strMensaje = new JLabel("Acceso Correcto");
        strMensaje.setFont(new Font("Segoe UI", 0, 15));
        strMensaje.setBounds(140, 140, 250, 27);
        imgDialog.add(strMensaje);

        btnAceptar = new JButton("Aceptar");
        btnAceptar.setBackground(new Color(76, 175, 80));
        btnAceptar.setForeground(Color.WHITE);
        btnAceptar.setFont(new Font("Segoe UI", 1, 15));
        btnAceptar.setFocusable(false);
        btnAceptar.setBorder(null);
        btnAceptar.setBounds(100, 180, 183, 31);
        btnAceptar.addActionListener(e -> btnAceptarActionPerformed(e));
        imgDialog.add(btnAceptar);

        
        getContentPane().add(imgDialog, BorderLayout.CENTER);

        // Setting Window
        this.setSize(400, 250);
        this.setUndecorated(true);
        this.getRootPane().setOpaque(false);
        this.setBackground(new Color(0,0,0,0));
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        formLoginOk f = new formLoginOk(new JFrame(), true);
    }

    public void btnAceptarActionPerformed(ActionEvent e){
        System.exit(1);
    }

    // Variables declaration

    JLabel imgDialog;
    JLabel imgAccepted;
    JLabel strMensaje;
    JButton btnAceptar;

    // End of variables declaration
    
}
