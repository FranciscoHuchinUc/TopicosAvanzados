package ejercicios.ejercicio4;

import java.awt.Frame;
import java.awt.*;
import java.awt.Button;
import java.awt.event.*;

public class Menu4p1 extends Frame implements ActionListener {

    /**
     *
     */
    private static final long serialVersionUID = 354389205474008567L;

    public Menu4p1() {
        initComponet();
        this.setSize(400, 300);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    public void initComponet() {
        this.setLayout(new GridLayout(3, 3));

        btn_aceptar = new Button("Aceptar");
        btn_aceptar.addActionListener(this);

        lbl_msg = new Label("Introdusca el Texto");

        txt_in = new TextField("");

        txt_result = new TextArea("");

        btn_clear = new Button("Limpiar");
        btn_clear.addActionListener(this);

        this.add(lbl_msg, 0, 0);
        this.add(txt_in, 0, 1);
        this.add(btn_aceptar, 0, 2);
        this.add(txt_result, 1, 1);
        this.add(btn_clear, 2, 2);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("");

    }

    public static void main(String[] args) {
        Menu4p1 m = new Menu4p1();
        m.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    Button btn_aceptar;
    Button btn_clear;
    TextField txt_in;
    Label lbl_msg;
    TextArea txt_result;

    Panel panel_superior;
    Panel panel_central;
    Panel panel_inferior;

}