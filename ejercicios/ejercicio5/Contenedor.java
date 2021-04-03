//package ejercicios.ejercicio5;

import java.awt.*;

public class Contenedor extends Canvas {

    /**
     * @FranciscoHuchinUc
     */
    private static final long serialVersionUID = -8122885429252598488L;

    private int xx, yy;
    private int h, w;
    private boolean isClicked;

    public Contenedor() {
        xx = 30;
        yy = 30;
        isClicked = false;
    }

    public void paint(Graphics g) {
        g.setColor(Color.BLUE);
        g.drawRect(xx, yy, w, h);
        g.fillOval(xx, yy, w, h);
    }

    public int setX(int x) {
        return xx = x;
    }

    public int setY(int y) {
        return yy = y;
    }

    public int setW(int width) {
        return w = width;
    }

    public int setH(int heigth) {
        return h = heigth;
    }

    public boolean isClicked() {
        return isClicked;
    }

    public void setClicked() {
        this.isClicked = !this.isClicked;
    }

}
