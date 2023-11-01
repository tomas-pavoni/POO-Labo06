public class Etudiant extends Personne {
    private int matricule;

    Etudiant() {

    }

    public String toString() {
        return super.toString() + Integer.toString(matricule);
    }
}
