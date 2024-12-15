package fr.esiee;
import fr.esiee.modele.Role;
import fr.esiee.modele.Utilisateur;
import fr.esiee.modele.Arret;
import fr.esiee.modele.Trajet;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2024, 11, 29);
        // Création du premier utilisateur avec le constructeur par défaut
        Utilisateur utilisateur1 = new Utilisateur();
        utilisateur1.setId(1);
        utilisateur1.setLogin("user1");
        utilisateur1.setMdp("password1");
        utilisateur1.setNom("Dupont");
        utilisateur1.setPrenom("Jean");
        utilisateur1.setDateEmbauche(LocalDate.of(2020, 5, 15));
        utilisateur1.setRole(Role.EMPLOYE);


        Utilisateur utilisateur2 = new Utilisateur(2, "admin1", "adminpass", "Martin", "Alice", date, Role.ADMIN);

        // Affichage des informations des utilisateurs
        afficherUtilisateur(utilisateur1);
        afficherUtilisateur(utilisateur2);

        // Création des trajets
        Arret arret1Depart = new Arret(1, "Gare du Nord");
        Arret arret1Arrivee = new Arret(2, "Gare de Lyon");
        Arret arret2Depart = new Arret(3, "Châtelet");
        Arret arret2Arrivee = new Arret(4, "Montparnasse");

        Trajet trajet1 = new Trajet(LocalDateTime.of(2024, 9, 1, 10, 0), "TR001",
                LocalDateTime.of(2024, 9, 1, 11, 0), arret1Depart, arret1Arrivee);
        Trajet trajet2 = new Trajet(LocalDateTime.of(2024, 9, 5, 14, 0), "TR002",
                LocalDateTime.of(2024, 9, 5, 15, 0), arret2Depart, arret2Arrivee);

        // Affichage du trajet avant modification
        System.out.println("\nAvant modification du trajet:");
        System.out.println(trajet1);  // toString() sera implicitement appelé ici
        System.out.println(trajet2);

        // Modification du premier trajet
        trajet1.setCode("TR003");
        trajet1.setTempsDepart(LocalDateTime.of(2024, 9, 2, 9, 30));
        trajet1.setArretDepart(new Arret(5, "Opéra"));

        // Affichage des trajets après modification
        System.out.println("\nAprès modification du trajet:");
        System.out.println(trajet1);
        System.out.println(trajet2);
    }

    // Méthode pour afficher les informations d'un utilisateur
    private static void afficherUtilisateur(Utilisateur utilisateur) {
        System.out.println("\nUtilisateur:");
        System.out.println("ID: " + utilisateur.getId());
        System.out.println("Login: " + utilisateur.getLogin());
        System.out.println("Mot de passe: " + utilisateur.getMdp());
        System.out.println("Nom: " + utilisateur.getNom());
        System.out.println("Prénom: " + utilisateur.getPrenom());
        System.out.println("Date d'embauche: " + utilisateur.getDateEmbauche());
        System.out.println("Rôle: " + utilisateur.getRole());
    }
}
