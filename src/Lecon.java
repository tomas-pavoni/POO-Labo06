public class Lecon {
    private final String matiere;
    private final String salle;
    private final int jourSemaine;
    private final int periodeDebut;
    private final int duree;
    private final Professeur professeur;

    Lecon(String matiere, String salle, int jourSemaine, int periodeDebut,
          int duree, Professeur professeur) {
        this.matiere = matiere;
        this.salle = salle;
        this.jourSemaine = jourSemaine;
        this.periodeDebut = periodeDebut;
        this.duree = duree;
        this.professeur = professeur;
    }

    //public STATIC String horaire() {}
    // La méthode horaire() dans la classe Leçon est statique (indépendante de tout objet).
}
