package model;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Diccionario {

    public String palabra;
    public String significado;

    public Diccionario() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public Diccionario(String palabra, String significado) {
        this.palabra = palabra;
        this.significado = significado;
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public String getSignificado() {
        return significado;
    }

    public void setSignificado(String significado) {
        this.significado = significado;
    }
    
}
