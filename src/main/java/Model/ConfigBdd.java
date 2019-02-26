package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigBdd {

    public ConfigBdd() {
    }

    public  Connection connect () {
        Connection conn = null;
        try {
            // TODO: Faire un fichier de conf pour le path
            String url = "jdbc:sqlite:C:/Users/Jérémy/Desktop/Cours/B3/MSPR JAVA/go-securi-app/db.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
}
