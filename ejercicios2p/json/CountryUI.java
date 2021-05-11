package ejercicios2p.json;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

public class CountryUI extends JFrame {

    CountriesController ctrl;

    public CountryUI() {
        initComponets();
        try {
            ctrl = new CountriesController();
            populateCountries();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initComponets() {
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        lblLista = new JLabel("País");
        cmbCountry = new JComboBox<>();
        area = new JTextArea();

        pnlUp = new JPanel();
        pnlUp.setLayout(new FlowLayout());
        pnlUp.add(lblLista);
        pnlUp.add(cmbCountry);

        this.add(pnlUp, BorderLayout.NORTH);
        this.add(area, BorderLayout.CENTER);

        // Settings Window
        this.setSize(600, 200);
        this.setVisible(true);
    }

    private void populateCountries() {
        if(ctrl.list() != null){
            for (Country country : ctrl.list()) {
                cmbCountry.addItem(country);
            }
        }
    }

    // Variables declatation
    JLabel lblLista;
    JComboBox<Country> cmbCountry;
    JTextArea area;
    JPanel pnlUp;
    // End Variables

}
