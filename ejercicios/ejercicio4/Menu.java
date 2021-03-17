package ejercicios.ejercicio4;

import java.awt.Frame;
import java.awt.*;
import java.awt.Button;
import java.awt.event.*;

public class Menu extends Frame implements ActionListener {

    /**
     *
     */
    private static final long serialVersionUID = 3479693991437663945L;

    public Menu() {
        initComponet();
        this.setSize(400, 300);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    public void initComponet() {
        this.setLayout(new BorderLayout());

        btn_aceptar = new Button("Aceptar");
        btn_aceptar.addActionListener(this);

        lbl_msg = new Label("Texto");

        txt_in = new TextField(" ");

        txt_result = new TextArea("");

        btn_clear = new Button("Limpiar");
        btn_clear.addActionListener(this);

        // Contenedores
        panel_superior = new Panel();
        panel_superior.setLayout(new BorderLayout());
        panel_superior.add(btn_aceptar, BorderLayout.EAST);
        panel_superior.add(txt_in, BorderLayout.CENTER);
        panel_superior.add(lbl_msg, BorderLayout.WEST);
        this.add(panel_superior, BorderLayout.NORTH);

        panel_central = new Panel();
        panel_central.setLayout(new BorderLayout());
        panel_central.add(txt_result, BorderLayout.CENTER);
        this.add(panel_central, BorderLayout.CENTER);

        panel_inferior = new Panel();
        panel_inferior.setLayout(new BorderLayout());
        panel_inferior.add(btn_clear, BorderLayout.EAST);
        this.add(panel_inferior, BorderLayout.SOUTH);

    }

    public static void main(String[] args) {
        Menu m = new Menu();
        m.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //
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