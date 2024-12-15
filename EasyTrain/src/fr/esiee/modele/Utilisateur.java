package fr.esiee.modele;
import java.time.LocalDate;

public class Utilisateur {
    private int id;
    private String login;
    private String mdp;
    private String nom;
    private String prenom;
    private LocalDate dateEmbauche;
    private Role role;

    // Les deux constructeurs de la classe.
    public Utilisateur() {
        this.id = 0;
        this.login = "";
        this.mdp = "";
        this.nom = "";
        this.prenom = "";
        this.dateEmbauche = LocalDate.now();
        this.role = null;
    }

    public Utilisateur(int id, String login, String mdp, String nom, String prenom, LocalDate dateEmbauche, Role role) {
        this.id = id;
        this.login = login;
        this.mdp = mdp;
        this.nom = nom;
        this.prenom = prenom;
        this.dateEmbauche = dateEmbauche;
        this.role = role;

    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getMdp() {
        return mdp;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public LocalDate getDateEmbauche() {
        return dateEmbauche;
    }

    public Role getRole() {
        return role;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setDateEmbauche(LocalDate dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
