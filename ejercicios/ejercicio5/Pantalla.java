package ejercicios.ejercicio5;

import java.awt.*;
import java.awt.event.*;

public class Pantalla extends Frame implements MouseListener {

    /**
     *
     */
    private static final long serialVersionUID = -115386458637633357L;

    private Contenedor obj_pintable;

    public Pantalla() {
        initComponets();
    }

    public void initComponets() {

        obj_pintable = new Contenedor();
        this.add(obj_pintable);
        obj_pintable.addMouseListener(this);

        // Final de Ventana, Tamaño y Visibilidad
        this.setSize(500, 500);
        this.setVisible(true);
        
    }

    public static void main(String[] args) {
        Pantalla p = new Pantalla();
        p.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Click");
        obj_pintable.setX(e.getX());
        obj_pintable.setY(e.getY());
        obj_pintable.setW(e.getX());
        obj_pintable.setH(e.getY());
        obj_pintable.repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("Pressed");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("Liberado");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("Mouse Enter");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("Mouse Exit");
    }

}
