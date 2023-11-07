public class Professeur extends Personne{
    private final String abreviation;

    private final Lecon[] lecons;

    Professeur(String prenom, String nom, String abreviation, Lecon[] lecons) {
        this.prenom = prenom;
        this.nom = nom;
        this.abreviation = abreviation;
        this.lecons = lecons;
    }

    public String getAbreviation() {
        return abreviation;
    }

    //public String horaire() {}

    public String toString() {
        return "Prof. " + super.toString() + " (" + abreviation + ")";
    }
}
