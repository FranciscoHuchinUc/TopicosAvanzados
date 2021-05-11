package ejercicios.ejercicio8;

import java.awt.*;
import java.awt.event.*;

public class Game extends Frame implements KeyListener{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    
    SpritePlayer obj_pintable;

    public Game() {
        initComponents();
    }

    public void initComponents() {
        obj_pintable = new SpritePlayer();
        obj_pintable.addKeyListener(this);
        this.addKeyListener(this);
        this.add(obj_pintable);

        this.setSize(1024,500);
        this.setVisible(true);
    }

    public static void main(String args[]) {
        Game g = new Game();
        g.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public void keyPressed(KeyEvent arg0) {
        System.out.println("Presionando " + arg0.getKeyChar());
        if (!obj_pintable.isClicked()) {
            switch(arg0.getKeyChar()) {
                case 'd':
                case 'D':
                    obj_pintable.setX(obj_pintable.getX() + 1);
                    obj_pintable.tick();
                    break;
                case 'a':
                case 'A':
                    obj_pintable.setX(obj_pintable.getX() - 1);
                    obj_pintable.tick();
                    break;
                case 'w':
                case 'W':
                    obj_pintable.setY(obj_pintable.getY() - 1);

                    break;
                case 's':
                case 'S':
                    obj_pintable.setY(obj_pintable.getY() + 1);
                    break;
                default:
                break;
            }
            obj_pintable.repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent arg0) {
        System.out.println("Liberando " + arg0.getKeyChar());
    }

    @Override
    public void keyTyped(KeyEvent arg0) {
        System.out.println("Tecleada: " + arg0.getKeyChar());
    }

}