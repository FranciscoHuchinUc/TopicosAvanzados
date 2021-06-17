package model;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Diccionario {

    public String Palabra;
    public String Significado;

    public Diccionario() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public Diccionario(String Palabra, String Significado) {
        this.Palabra = Palabra;
        this.Significado = Significado;
    }

    public String getPalabra() {
        return Palabra;
    }

    public void setPalabra(String palabra) {
        Palabra = palabra;
    }

    public String getSignificado() {
        return Significado;
    }

    public void setSignificado(String significado) {
        Significado = significado;
    }
}
