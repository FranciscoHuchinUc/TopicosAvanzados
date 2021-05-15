package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;   

public class Connect {

    private static Connection conn;
    ResultSet resul = null;

    
    public void connectionDB() {
        try {
            Class.forName("org.sqlite.JDBC");
            String dbURL = "jdbc:sqlite:D:/Developer/Repositorio/TopicosAvanzados/practicas/java/practica5/db/autentificacion.db";
            conn = DriverManager.getConnection(dbURL);
            if (conn != null) {
                System.out.println("Connected to the database");
            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public boolean accesDB(String user, String pass) {
        try {
            PreparedStatement st = conn.prepareStatement("SELECT USUARIO, PASSWORD FROM User");
            resul = st.executeQuery();

            while (resul.next()) {
                if(user.equals(resul.getString("USUARIO")) && pass.equals(resul.getString("PASSWORD"))){
                    return true;
                } else {
                    return false;
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public ResultSet getResul() {
        return resul;
    }

    public void setResul(ResultSet resul) {
        this.resul = resul;
    }    

}
