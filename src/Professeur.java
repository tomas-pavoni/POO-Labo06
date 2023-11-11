import java.util.ArrayList;

public class Professeur extends Personne{
    private final String abreviation;

    private final ArrayList<Lecon> lecons;

    Professeur(String prenom, String nom, String abreviation) {
        this.prenom = prenom;
        this.nom = nom;
        this.abreviation = abreviation;
        this.lecons = new ArrayList<>();
    }

    void ajouterLecon(Lecon lecon){
        this.lecons.add(lecon);
    }

    public String abreviation() {
        return abreviation;
    }

    public String horaire() {
        return "-- Horaire du Prof. " + this + "\n\n"
                +  Lecon.horaire(this.lecons);
    }

    public String toString() {
        return "Prof. " + super.toString() + " (" + abreviation + ")";
    }
}
