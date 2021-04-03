package practica2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Videojuego extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public Videojuego() {
        initComponets();
    }

    public void initComponets() {

        this.setLayout(new BorderLayout());
        this.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                paintContainerKeyPressed(e);
            }
        });

        btnCirculo = new JButton("Circulo (a)");
        btnCirculo.setFocusable(false);
        btnCirculo.setFont(new Font("Open Sans", 0, 14));
        btnCirculo.setPreferredSize(new Dimension(110, 30));
        btnCirculo.addActionListener(e -> btnCirculoActionPerformed(e));

        btnCuadrado = new JButton("Cuadrado (s)");
        btnCuadrado.setFocusable(false);
        btnCuadrado.setFont(new Font("Open Sans", 0, 14));
        btnCuadrado.setPreferredSize(new Dimension(120, 30));
        btnCuadrado.addActionListener(e -> btnCuadradoActionPerformed(e));

        btnRombo = new JButton("Rombo (d)");
        btnRombo.setFocusable(false);
        btnRombo.setFont(new Font("Open Sans", 0, 14));
        btnRombo.setPreferredSize(new Dimension(110, 30));
        btnRombo.addActionListener(e -> btnRomboActionPerformed(e));

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

        paintContainer = new Paint();
        paintContainer.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                paintContainerMouseClicked(e);
            }
        });
        paintContainer.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                paintContainerMouseDragged(e);
            }
        });
        paintContainer.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                paintContainerKeyPressed(e);
            }
        });

        this.add(barraBoton, BorderLayout.NORTH);
        this.add(scrollPane, BorderLayout.EAST);
        this.add(paintContainer, BorderLayout.CENTER);

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

    private void btnCirculoActionPerformed(ActionEvent e) {
        paintContainer.setIsFigura("Circulo");
        JOptionPane.showMessageDialog(null, "Circulo");
    }

    private void btnCuadradoActionPerformed(ActionEvent e) {
        paintContainer.setIsFigura("Cuadrado");
        JOptionPane.showMessageDialog(null, "Cuadrado");
    }
    
    private void btnRomboActionPerformed(ActionEvent e) {
        paintContainer.setIsFigura("Rombo");
        JOptionPane.showMessageDialog(null, "Rombo");
    }

    private void paintContainerMouseClicked(MouseEvent e) {
        paintContainer.setClicked();
        paintContainer.repaint();
    }

    private void paintContainerMouseDragged(MouseEvent e) {
        if (!paintContainer.isClicked()) {
            paintContainer.setX(e.getX());
            paintContainer.setY(e.getY());

            paintContainer.repaint();
        }
    }

    private void paintContainerKeyPressed(KeyEvent e) {
        if (!paintContainer.isClicked()) {
            switch (e.getKeyCode()) {
                case 'a':
                case 'A':
                    btnCirculo.doClick();
                    break;
                case 's':
                case 'S':
                    btnCuadrado.doClick();
                    break;
                case 'd':
                case 'D':
                    btnRombo.doClick();
                    break;
                default:
                    break;
            }
        }
    }

    // Variables declaration
    JButton btnCirculo;
    JButton btnCuadrado;
    JButton btnRombo;
    JLabel iconCircle;
    JLabel iconSquare;
    JLabel iconRectangle;
    JLabel iconTriangle;
    JPanel barraBoton;
    Paint paintContainer;
    JPanel contOpciones;
    JScrollPane scrollPane;
    // End of variables declaration

}