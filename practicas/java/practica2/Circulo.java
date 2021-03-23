package practica2;

import java.awt.*;
import javax.swing.*;

public class Circulo extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    

    public void paint(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillRect(50, 50, 100, 100);
    }
    
}
