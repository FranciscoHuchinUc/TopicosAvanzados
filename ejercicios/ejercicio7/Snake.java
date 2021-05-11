package ejercicios.ejercicio7;

import java.awt.*;
import java.awt.event.*;

public class Snake extends Frame implements KeyListener{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private Sprite sprite;

    public Snake() {
        initComponets();
    }

    public void initComponets() {

        sprite = new Sprite();
        
        sprite.addKeyListener(this);
        this.addKeyListener(this);
        this.add(sprite);

        // Final de Ventana, Tamaño y Visibilidad
        this.setSize(500, 500);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        Snake s = new Snake();
        s.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }


    @Override
    public void keyPressed(KeyEvent e) {
        
        System.out.println("Presionando " + e.getKeyChar());
        switch(e.getKeyChar()) {
            case 'd':
            case 'D':
                sprite.setX(sprite.getX() + 3);

                break;
            case 'a':
            case 'A':
                sprite.setX(sprite.getX() - 3);
                break;
            case 'w':
            case 'W':
                sprite.setY(sprite.getY() - 3);

                break;
            case 's':
            case 'S':
                sprite.setY(sprite.getY() + 3);
                break;

                default:
                break;

        }
        sprite.repaint();

    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }


}
