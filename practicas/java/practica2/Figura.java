package practica2;

import java.awt.*;

public class Figura extends Canvas {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private int x, y;
    private String isFigura;

    public Figura() {
        x = 50;
        y = 50;
    }

    public void paint(Graphics g) {
        try {
            switch (isFigura) {
                case "Circulo":
                    g.setColor(Color.RED);
                    g.fillOval(x, y, 100, 100);
                    break;
            }
        } catch (Exception e) {
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getIsFigura() {
        return isFigura;
    }

    public void setIsFigura(String isFigura) {
        this.isFigura = isFigura;
    }

}