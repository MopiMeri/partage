package fr.esiee.modele;
import java.time.LocalDateTime;

public class Trajet {
    private String code;
    private LocalDateTime tempsDepart;
    private LocalDateTime tempsArrivee;
    private Arret arretDepart;
    private Arret arretArrivee;

    public Trajet(LocalDateTime tempsDepart, String code, LocalDateTime tempsArrivee, Arret arretDepart, Arret arretArrivee) {
        this.tempsDepart = tempsDepart;
        this.code = code;
        this.tempsArrivee = tempsArrivee;
        this.arretDepart = arretDepart;
        this.arretArrivee = arretArrivee;
    }

    public Trajet(){
        this.tempsDepart = null;
        this.tempsArrivee = null;
        this.arretDepart = null;
        this.arretArrivee = null;
        this.code = null;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDateTime getTempsDepart() {
        return tempsDepart;
    }

    public void setTempsDepart(LocalDateTime tempsDepart) {
        this.tempsDepart = tempsDepart;
    }

    public LocalDateTime getTempsArrivee() {
        return tempsArrivee;
    }

    public void setTempsArrivee(LocalDateTime tempsArrivee) {
        this.tempsArrivee = tempsArrivee;
    }

    public Arret getArretDepart() {
        return arretDepart;
    }

    public void setArretDepart(Arret arretDepart) {
        this.arretDepart = arretDepart;
    }

    public Arret getArretArrivee() {
        return arretArrivee;
    }

    public void setArretArrivee(Arret arretArrivee) {
        this.arretArrivee = arretArrivee;
    }

    @Override
    public String toString() {
        return "Trajet{" +
                "code='" + code + '\'' +
                ", tempsDepart=" + tempsDepart +
                ", tempsArrivee=" + tempsArrivee +
                ", arretDepart=" + arretDepart +
                ", arretArrivee=" + arretArrivee +
                '}';
    }
}
