package Forms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class formLoginError extends JDialog {

    public formLoginError(JFrame jframe, boolean modal) {
        initComponents();
    }

    private void initComponents() {
        getContentPane().setLayout(new GridLayout());

        imgDialog = new JLabel();
        imgDialog.setIcon(new ImageIcon(getClass().getResource("/src/JDialogForm.png")));

        imgError = new JLabel();
        imgError.setIcon(new ImageIcon(getClass().getResource("/src/ERROR.png")));
        imgError.setBounds(130, 25, 120, 120);
        imgDialog.add(imgError);

        strMensaje = new JLabel("Error de Contraseña y/o Usuario");
        strMensaje.setFont(new Font("Segoe UI", 0, 15));
        strMensaje.setBounds(90, 140, 250, 27);
        imgDialog.add(strMensaje);

        btnAceptar = new JButton("Aceptar");
        btnAceptar.setBackground(new Color(244, 67, 54));
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
        formLoginError f = new formLoginError(new JFrame(), true);
    }

    public void btnAceptarActionPerformed(ActionEvent e){
        this.dispose();
    }

    // Variables declaration

    JLabel imgDialog;
    JLabel imgError;
    JLabel strMensaje;
    JButton btnAceptar;

    // End of variables declaration
    
}
