package practica2;

import java.awt.*;

public class Circulo extends Canvas{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public void paint(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(150, 150, 30, 30);
    }
    
}
