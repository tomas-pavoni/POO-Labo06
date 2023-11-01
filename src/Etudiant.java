public class Etudiant extends Personne {
    private int matricule;

    Etudiant(int matricule) {
        this.matricule = matricule;
    }

    public String toString() {
        return super.toString() + Integer.toString(matricule);
    }
}
