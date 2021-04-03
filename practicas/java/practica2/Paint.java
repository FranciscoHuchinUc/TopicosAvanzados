package practica2;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Francisco Huchin
 */
public class Paint extends JPanel {

    private int x, y;
    private int w, h;
    private String isFigura;
    boolean isClicked;

    public Paint() {
        x = y = 50;
        w = h = 100;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
            switch (isFigura) {
                case "Circulo":
                    g.setColor(Color.red);
                    g.fillOval(x, y, w, h);
                    break;
                case "Cuadrado":
                    g.setColor(Color.orange);
                    g.fillRect(x, y, w, h);
                    break;
                case "Rombo":
                    g.setColor(Color.pink);
                    g.fillArc(x, y, w, h, 60, 90);
                    break;
            }
        } catch (Exception e) {
        }
    }

    @Override
    public void update(Graphics g) {
        super.update(g);
        paintComponent(g);
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

    public Paint(LayoutManager layout) {
        super(layout);
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public String getIsFigura() {
        return isFigura;
    }

    public void setIsFigura(String isFigura) {
        this.isFigura = isFigura;
    }

    public boolean isClicked() {
        return isClicked;
    }

    public void setClicked() {
        this.isClicked = !this.isClicked;
    }
}