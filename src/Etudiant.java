public class Etudiant extends Personne {
    private final int matricule;

    private final Groupe groupe;

    Etudiant(String prenom, String nom, int matricule, Groupe groupe) {
        this.prenom = prenom;
        this.nom = nom;
        this.matricule = matricule;
        this.groupe = groupe;
    }

    public String toString() {
        return "Etud. " + super.toString() + " (#" + matricule + ")";
    }
}
