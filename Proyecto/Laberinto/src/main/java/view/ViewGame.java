package view;

import javax.swing.*;
import java.awt.*;

import model.Laberinto;

public class ViewGame extends JFrame {

    public ViewGame () {
        initComponents();
    }

    private void initComponents() {
        // Action Close Window
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new GridLayout());

        laberinto = new Laberinto();

        this.getContentPane().add(laberinto);


        // Setting Window
        this.setSize(new Dimension(940, 560));
        this.setTitle("Laberinto");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new ViewGame();
    }

    // Variable Declaration
    Laberinto laberinto;
    // End Variable
    
}
