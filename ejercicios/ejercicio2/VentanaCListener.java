package ejercicios.ejercicio2;

import java.awt.Frame;
import java.awt.*;
import java.awt.Button;
import java.awt.event.*;
import java.util.ArrayList;

public class VentanaCListener extends Frame implements ActionListener {

    /**
     * Autor Francisco Huchin
     */
    private static final long serialVersionUID = 284453842348034814L;

    // Variables
    boolean isClicked;

    // Constructor
    public VentanaCListener() {
        init();
        this.setSize(400, 300);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    // Inicializamos Los Componentes Al Contenedor
    public void init() {
        this.setLayout(new BorderLayout());

        isClicked = false;
        btn_Click = new Button("Aceptar");
        btn_Click.addActionListener(this);
        btn_Click.setFocusable(false);
        this.add(btn_Click, BorderLayout.EAST);

        lbl_msg = new Label("Introdusca el Texto en el campo inferior de la ventana");
        this.add(lbl_msg, BorderLayout.NORTH);

        txt_in = new TextField("");
        this.add(txt_in, BorderLayout.SOUTH);

        txt_result = new TextArea("");
        this.add(txt_result, BorderLayout.CENTER);

        btn_clear = new Button("Limpiar");
        btn_clear.addActionListener(this);
        btn_clear.setFocusable(false);
        this.add(btn_clear, BorderLayout.WEST);

        array = new ArrayList<>();

    }

    public static void main(String args[]) {
        VentanaCListener v = new VentanaCListener();
        v.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn_Click) {
            String texto = txt_in.getText();
            if (texto.equals("SUMAR")) { 
                if (array.size() > 0) {
                    Integer i = 0;
                    for(Integer n: array) {
                        i = i + n;
                    }
                    texto = txt_in.getText() + (" " + i.toString());
                }
            } else {
                try{
                    Integer i = Integer.parseInt(texto);
                    array.add(i);
                    }catch(Exception ex) {

                    }
            }
            
            txt_result.append(texto + "\n");
        }
        if (e.getSource() == btn_clear) {
            txt_result.setText("");
            txt_in.setText("");
        }
    }

    /**
     * Creacion de los Componentes
     */
    Button btn_Click;
    Button btn_clear;
    TextField txt_in;
    Label lbl_msg;
    TextArea txt_result;
    
    ArrayList<Integer> array;

}
