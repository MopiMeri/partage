package fr.esiee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJDBC {
    public static void main(String[] args) {
        String urlLocal = "jdbc:mariadb://localhost:3306/easytrain";
        String userLocal = "root";
        String pwdLocal = "root";

        Connection co = null;

        try {
            co = DriverManager.getConnection(urlLocal, userLocal, pwdLocal);
            System.out.println("Connexion réussie.");

            Statement stmt = co.createStatement();

            // Exécuter la requête pour sélectionner le login avec id=2
            ResultSet resultSet = stmt.executeQuery("SELECT login FROM utilisateur WHERE id=2");
            if (resultSet.next()) {  // Vérifier qu'il y a une ligne dans le ResultSet
                System.out.println(resultSet.getString("login"));
            }

            // Insertion d'une nouvelle ligne dans la table arret
            int rowAffected = stmt.executeUpdate("INSERT INTO arret (nom) VALUES ('Mours')");
            System.out.println("Nombre de ligne(s) insérée(s) :" + rowAffected);

            // Affichage de la liste des logins
            resultSet = stmt.executeQuery("SELECT login FROM utilisateur");
            System.out.println("Voici la liste des logins :");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("login"));
            }

            resultSet.close();
            stmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (co != null) {
                try {
                    co.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
