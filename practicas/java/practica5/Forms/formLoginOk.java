package Forms;

import javax.swing.*;
import java.awt.*;

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
        imgAccepted.setBounds(149, 100, 98, 98);

        
        getContentPane().add(imgDialog, BorderLayout.CENTER);
        getContentPane().add(imgAccepted, BorderLayout.AFTER_LAST_LINE);

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

    // Variables declaration

    JLabel imgDialog;
    JLabel imgAccepted;

    // End of variables declaration
    
}
