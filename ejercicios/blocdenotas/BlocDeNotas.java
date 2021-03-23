package ejercicios.blocnenotas;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class BlocDeNotas extends JFrame implements ActionListener {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public BlocDeNotas() {
        initComponents();
    }

    public void initComponents() {

        Container contenedor = getContentPane();
        contenedor.setLayout(new FlowLayout());

        btnColor = new Button("Color");
        btnColor.setFocusable(false);
        btnColor.addActionListener(this);

        btnComilla = new Button("Comilla");
        btnComilla.setFocusable(false);
        btnComilla.addActionListener(this);

        btnTamanio = new Button("Tamaño");
        btnTamanio.setFocusable(false);
        btnTamanio.addActionListener(this);

        btnAbrir = new Button("Abrir");
        btnAbrir.setFocusable(false);
        btnAbrir.addActionListener(this);

        btnGuardar = new Button("Guardar");
        btnGuardar.setFocusable(false);
        btnGuardar.addActionListener(this);

        btnSalir = new Button("Salir");
        btnSalir.setFocusable(false);
        btnSalir.addActionListener(this);

        txtBlocNotas = new JTextArea();
        txtBlocNotas.setColumns(20);
        txtBlocNotas.setRows(5);
        txtBlocNotas.setFont(new Font("Open Sans", 1, 14));
        txtBlocNotas.setPreferredSize(new Dimension(450, 400));

        txtEstado = new JLabel(" Barra De Estado ");

        barraMenu = new JPanel();
        barraMenu.add(btnColor);
        barraMenu.add(btnComilla);
        barraMenu.add(btnTamanio);
        barraMenu.add(btnAbrir);
        barraMenu.add(btnGuardar);
        barraMenu.add(btnSalir);
        contenedor.add(barraMenu);

        contenedorTexto = new JPanel();
        contenedorTexto.add(txtBlocNotas);
        contenedor.add(contenedorTexto);

        barraEstado = new JPanel();
        barraEstado.add(txtEstado);
        contenedor.add(barraEstado);

        archivo = new File("Nota.txt");

        // Tamaño de la ventana
        this.setSize(500, 500);
        this.setUndecorated(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Acciones de los Botones
        if (e.getSource() == btnColor) {
            try {
                int c = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "Elija su Color Segun El Numero\n" + "0 - Black\n" + "1 - Blue\n" + "2 - Red\n" + "3 - Cyan\n"
                                + "4 - Gray\n" + "5 - Green\n" + "6 - Yellow\n"));
                cambiarColor(c);
            } catch (Exception exc) {
                System.out.println(exc);
            }
        }
        if (e.getSource() == btnComilla) {
            try {
                ponerComilla();
            } catch (Exception exc) {
                System.out.println(exc);
            }
        }
        if (e.getSource() == btnTamanio) {
            try {
                int tam = Integer.parseInt(
                        JOptionPane.showInputDialog(null, "Ingrese El Tamaño del Texto", JOptionPane.OK_OPTION));
                cambiarTamanio(tam);
            } catch (Exception exc) {
                System.out.println(exc);
            }
        }
        if (e.getSource() == btnAbrir) {
            String documento = abrirarchivo(archivo);
            txtBlocNotas.setText(documento);
        }
        if (e.getSource() == btnGuardar) {
            try {
                guardarArchivo();
            } catch (Exception exc) {
                System.out.println(exc);
            }
        }
        if (e.getSource() == btnSalir) {
            System.exit(0);
        }
    }

    public void cambiarColor(int c) {
        switch (c) {
        case 0:
            txtBlocNotas.setForeground(Color.BLACK);
            break;
        case 1:
            txtBlocNotas.setForeground(Color.BLUE);
            break;
        case 2:
            txtBlocNotas.setForeground(Color.RED);
            break;
        case 3:
            txtBlocNotas.setForeground(Color.CYAN);
            break;
        case 4:
            txtBlocNotas.setForeground(Color.GRAY);
            break;
        case 5:
            txtBlocNotas.setForeground(Color.GREEN);
            break;
        case 6:
            txtBlocNotas.setForeground(Color.YELLOW);
            break;
        default:
            txtBlocNotas.setForeground(Color.BLACK);
            txtEstado.setText("No Existe Ese Color");
            break;
        }
        txtEstado.setText("Color Cambiado");
    }

    private void cambiarTamanio(int tam) {
        txtBlocNotas.setFont(new Font("Open Sans", 1, tam));
        txtEstado.setText("Tamaño Cambiado");
    }

    private void ponerComilla() {
        String texto, parte;
        texto = txtBlocNotas.getText();
        parte = txtBlocNotas.getSelectedText();
        if (!parte.contains("'")) {
            txtBlocNotas.setText(texto.split(parte)[0]+ "'" + parte + "'" + texto.split(parte)[1]);
            txtEstado.setText("Comilla Puesta");
        }
    }

    private String abrirarchivo(File arc) {

        FileInputStream entrada;
        String document = "";
        try {
            entrada = new FileInputStream(arc);
            int ascci;
            while ((ascci = entrada.read()) != -1) {
                char caracter = (char) ascci;
                document += caracter;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        txtEstado.setText("Archivo Abierto");
        return document;
    }

    private void guardarArchivo() {
        try {
            File dir = new File("Nota.txt");
            FileWriter archivo = new FileWriter(dir, true);
            String texto = txtBlocNotas.getText() + "\n";
            archivo.write(texto);
            archivo.close();
            txtEstado.setText("Archivo Guardado en La Localizacion de Este Programa");
        } catch (Exception ex) {
            System.out.println("Error " + ex);
        }
    }

    public static void main(String[] args) {
        BlocDeNotas blocDeNotas = new BlocDeNotas();
        blocDeNotas.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    JPanel barraMenu;
    JPanel contenedorTexto;
    JPanel barraEstado;
    Button btnSalir;
    Button btnGuardar;
    Button btnColor;
    Button btnTamanio;
    Button btnAbrir;
    Button btnComilla;
    JTextArea txtBlocNotas;
    JLabel txtEstado;
    File archivo;

}