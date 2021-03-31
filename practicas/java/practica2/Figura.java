package practica2;

import java.awt.*;

public class Figura extends Canvas {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    

    public void paint(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(50, 50, 100, 100);
    }
    
}
