package fr.esiee;

import fr.esiee.dao.EasyTrainDAO;
import fr.esiee.modele.*;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.List;

public class TestDAO {
    public static void main(String[] args) {
        EasyTrainDAO dao = new EasyTrainDAO();

        // --- Tests pour la gestion des utilisateurs ---
        System.out.println("\n=== Tests Utilisateur ===");

        // Test 1: Ajouter un utilisateur
        System.out.println("Test 1: Ajouter un utilisateur");
        Utilisateur utilisateur = new Utilisateur(0, "test4", "password123", "Doe", "John", LocalDate.now(), Role.EMPLOYE);
        boolean isUserAdded = dao.ajouterUtilisateur(utilisateur);
        System.out.println("Utilisateur ajouté : " + isUserAdded);
        if (isUserAdded) {
            System.out.println("ID de l'utilisateur ajouté : " + utilisateur.getId());
        }

        // Test 2: Récupérer un utilisateur par ID
        System.out.println("\nTest 2: Récupérer un utilisateur par ID");
        int userId = 1;
        Utilisateur retrievedUser = dao.getUtilisateurById(userId);
        if (retrievedUser != null) {
            System.out.println("Utilisateur trouvé : " + retrievedUser.getNom() + " " + retrievedUser.getPrenom());
        } else {
            System.out.println("Utilisateur avec l'ID " + userId + " non trouvé.");
        }

        // Test 3: Récupérer tous les utilisateurs
        System.out.println("\nTest 3: Récupérer tous les utilisateurs");
        List<Utilisateur> utilisateurs = dao.getAllUtilisateurs();
        if (!utilisateurs.isEmpty()) {
            for (Utilisateur u : utilisateurs) {
                System.out.println("Utilisateur : " + u.getNom() + " " + u.getPrenom());
            }
        } else {
            System.out.println("Aucun utilisateur trouvé.");
        }

        // --- Tests pour la gestion des arrêts ---
        System.out.println("\n=== Tests Arret ===");

        // Test 1: Ajouter un arrêt
        System.out.println("\nTest 1: Ajouter un arrêt");
        Arret newArret = new Arret(0, "Strasbourg");
        boolean isArretAdded = dao.ajouterArret(newArret);
        System.out.println("Arrêt ajouté : " + isArretAdded);
        if (isArretAdded) {
            System.out.println("ID de l'arrêt ajouté : " + newArret.getId());
        }

        // Test 2: Récupérer un arrêt par ID
        System.out.println("\nTest 2: Récupérer un arrêt par ID");
        int arretId = 1;
        Arret arret = dao.getArretById(arretId);
        if (arret != null) {
            System.out.println("Arrêt trouvé : " + arret.getNom());
        } else {
            System.out.println("Arrêt avec l'ID " + arretId + " non trouvé.");
        }

        // Test 3: Récupérer tous les arrêts
        System.out.println("\nTest 3: Récupérer tous les arrêts");
        List<Arret> arrets = dao.getAllArrets();
        if (!arrets.isEmpty()) {
            for (Arret a : arrets) {
                System.out.println("Arrêt : " + a.getNom());
            }
        } else {
            System.out.println("Aucun arrêt trouvé.");
        }

        // --- Tests pour la gestion des trajets ---
        System.out.println("\n=== Tests Trajet ===");

// Test 1: Ajouter un trajet
        System.out.println("\nTest 1: Ajouter un trajet");
        Arret arretDepart = new Arret(1, "Paris");
        Arret arretArrivee = new Arret(2, "Lyon");
        Trajet trajet = new Trajet(LocalDateTime.of(2024, 9, 30, 8, 0), "T006", LocalDateTime.of(2024, 9, 30, 10, 0), arretDepart, arretArrivee);
        boolean isTrajetAdded = dao.ajouterTrajet(trajet);
        System.out.println("Trajet ajouté : " + isTrajetAdded);
        if (isTrajetAdded) {
            System.out.println("Code du trajet ajouté : " + trajet.getCode());
        }

// Test 2: Récupérer un trajet par code
        System.out.println("\nTest 2: Récupérer un trajet par code");
        String trajetCode = "T001";
        Trajet retrievedTrajet = dao.getTrajetById(trajetCode);
        if (retrievedTrajet != null) {
            System.out.println("Trajet trouvé : " + retrievedTrajet.getCode() + ", " +
                    retrievedTrajet.getArretDepart().getNom() + " -> " + retrievedTrajet.getArretArrivee().getNom());
        } else {
            System.out.println("Trajet avec le code " + trajetCode + " non trouvé.");
        }

// Test 3: Récupérer tous les trajets
        System.out.println("\nTest 3: Récupérer tous les trajets");
        List<Trajet> trajets = dao.getAllTrajets();
        if (!trajets.isEmpty()) {
            for (Trajet t : trajets) {
                System.out.println("Trajet : " + t.getCode() + " - " + t.getArretDepart().getNom() + " -> " + t.getArretArrivee().getNom());
            }
        } else {
            System.out.println("Aucun trajet trouvé.");
        }
    }
}
