public class Etudiant extends Personne {
    private final int matricule;

    private Groupe groupe;

    Etudiant(String prenom, String nom, int matricule) {
        this.prenom = prenom;
        this.nom = nom;
        this.matricule = matricule;
    }

    void definirGroupe(Groupe groupe){ //TODO visibilité
        this.groupe = groupe;
    }

    public String toString() {
        return "Etud. " + super.toString() + " (#" + matricule + ")" + (groupe == null ? "" : " - " + groupe.nom());
    }
}
