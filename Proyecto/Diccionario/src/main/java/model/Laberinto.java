package model;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class Laberinto extends JPanel {

    private static final long serialVersionUID = 1L;
    
    private int fila;
    private int columna;
    private final int nFilas = 13;
    private final int nColumnas = 23;
    private int PersonajeEjeX = 0;
    private int PersonajeEjeY = 10;
    private final int movimiento = 40;
    private String nameUser = "Unknown";

    public Laberinto() {
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                teclaPresionada(e);
            }
        });

        this.setFocusable(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        int laberinto[][] = obtenerLaberinto();

        Image fondo = new ImageIcon(getClass().getResource("/img/jardin1.jpg")).getImage();
        g.drawImage(fondo, 0, 0, this);//pinta el fondo

        
        Image roca = new ImageIcon(getClass().getResource("/img/roca.png")).getImage();
        
        for (fila = 0; fila < nFilas; fila++) {
            for (columna = 0; columna < nColumnas; columna++) {
                if (laberinto[fila][columna] == 1) {
                    g.drawImage(roca, columna * 40, fila * 40, this); // pinta las rocas solo en las casilla con valor "1"
                }                                                     //ancho de cada casilla 40x40
            }
        }

        Image profile = new ImageIcon(getClass().getResource("/img/Profile.png")).getImage();
        g.drawImage(profile, 725, 14, this); // pinta la imagen de perfil de el usuario

        g.setFont(new Font("Gilroy-Bold", Font.BOLD, 20));
        g.setColor(Color.WHITE);
        g.drawString(nameUser, 765, 50);
        
        Image personaje = new ImageIcon(getClass().getResource("/img/g3.gif")).getImage();
        g.drawImage(personaje, PersonajeEjeX, PersonajeEjeY, 40, 60, this); //pinta el personaje superponiendolo al fondo y a las rocas

        Image gallina = new ImageIcon(getClass().getResource("/img/g5.gif")).getImage();
        g.drawImage(gallina, 880, 420, 40, 60, this); //pinta la gallina superponiendolo al fondo y a las rocas

    }

    @Override
    public void update(Graphics g) {
        super.update(g);
    }

    public int[][] obtenerLaberinto() { //crea el array que se usará como laberinto
        int laberinto[][] = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 1, 1, 3, 0, 0, 1, 1},
        {1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 1, 1},
        {1, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1},
        {1, 1, 0, 1, 1, 1, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 0, 1, 1},
        {1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1},
        {1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 1, 1},
        {1, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1, 0, 0, 1, 0, 0, 1, 0, 1, 1},
        {1, 1, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 1, 1},
        {1, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 1, 1},
        {1, 1, 0, 0, 0, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 1},
        {1, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 1, 0, 0, 0},
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
        };
        return laberinto;
    }

    public void teclaPresionada(KeyEvent e) {
        int direccion = e.getKeyCode();

        switch (direccion) {
            case KeyEvent.VK_RIGHT:
                PersonajeEjeX += 40;
                collisionCheck();
                break;
            case KeyEvent.VK_LEFT:
                PersonajeEjeX -= 40;
                collisionCheck();
                break;
            case KeyEvent.VK_UP:
                PersonajeEjeY -= 40;
                collisionCheck();
                break;
            case KeyEvent.VK_DOWN:
                PersonajeEjeY += 40;
                collisionCheck();
                break;
            default:
                break;
        }
    }

    public void collisionCheck() {
        //
        if (PersonajeEjeX + 90 >= getWidth()) {
            PersonajeEjeX = getWidth() - 90;
            Component comp = SwingUtilities.getRoot(this);
            ((Window) comp).dispose();
        }
        if (PersonajeEjeX <= 0) {
            PersonajeEjeX = 0;
        }
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }
    
}
