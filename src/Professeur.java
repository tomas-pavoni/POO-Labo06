import java.util.ArrayList;

public class Professeur extends Personne{
    private final String abreviation;

    private final ArrayList<Lecon> lecons;//todo difference betwen 0..* and 1..*

    Professeur(String prenom, String nom, String abreviation) {
        this.prenom = prenom;
        this.nom = nom;
        this.abreviation = abreviation;
        this.lecons = new ArrayList<>();
    }

    public String abreviation() {
        return abreviation;
    }

    private void ajouterLecon(Lecon lecon){
        this.lecons.add(lecon);
    }

    public String horaire() {return null;}

    public String toString() {
        return "Prof. " + super.toString() + " (" + abreviation + ")";
    }
}
