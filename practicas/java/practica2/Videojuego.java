package practica2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Videojuego extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    
    public Videojuego(){
        initComponets();
    }

    public void initComponets(){

        this.setLayout(new BorderLayout());

        btnCirculo = new JButton("Circulo");
        btnCirculo.setFocusable(false);
        btnCirculo.setFont(new Font("Open Sans", 0, 14));
        btnCirculo.setPreferredSize(new Dimension(90,30));

        btnCuadrado = new JButton("Cuadrado");
        btnCuadrado.setFocusable(false);
        btnCuadrado.setFont(new Font("Open Sans", 0, 14));
        btnCuadrado.setPreferredSize(new Dimension(110,30));

        btnRombo = new JButton("Rombo");
        btnRombo.setFocusable(false);
        btnRombo.setFont(new Font("Open Sans", 0, 14));
        btnRombo.setPreferredSize(new Dimension(90,30));

        iconCircle = new JLabel();
        iconCircle.setIcon(new ImageIcon(getClass().getResource("/practica2/img/imgCircle.png")));

        iconSquare = new JLabel();
        iconSquare.setIcon(new ImageIcon(getClass().getResource("/practica2/img/imgSquare.png")));

        iconRectangle = new JLabel();
        iconRectangle.setIcon(new ImageIcon(getClass().getResource("/practica2/img/imgRectangle.png")));

        iconTriangle = new JLabel();
        iconTriangle.setIcon(new ImageIcon(getClass().getResource("/practica2/img/imgTriangle.png")));

        barraBoton = new JPanel();
        barraBoton.setBackground(new Color(216, 241, 255));
        barraBoton.add(btnCirculo);
        barraBoton.add(btnCuadrado);
        barraBoton.add(btnRombo);

        scrollPane = new JScrollPane();
        scrollPane.setBorder(null);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setFocusTraversalPolicyProvider(true);
        contOpciones = new JPanel();
        contOpciones.setPreferredSize(new Dimension(90, 400));
        contOpciones.setBackground(new Color(216, 241, 255));
        contOpciones.add(iconCircle);
        contOpciones.add(iconSquare);
        contOpciones.add(iconRectangle);
        contOpciones.add(iconTriangle);
        scrollPane.setViewportView(contOpciones);

        this.add(barraBoton, BorderLayout.NORTH);
        this.add(scrollPane, BorderLayout.EAST);

        //Personalizacion de la ventana
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        //this.setResizable(false);
        this.setVisible(true);

    }
    
    public static void main(String[] args) {
        Videojuego videojuego = new Videojuego();
        videojuego.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    // Variables declaration
    JButton btnCirculo;
    JButton btnRombo;
    JButton btnCuadrado;
    JLabel iconCircle;
    JLabel iconSquare;
    JLabel iconRectangle;
    JLabel iconTriangle;
    JPanel barraBoton;
    JPanel contDibujo;
    JPanel contOpciones;
    JScrollPane scrollPane;
    // End of variables declaration
    
}