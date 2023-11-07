public class Lecon {
    private final String matiere;
    private final String salle;
    private final int jourSemaine;
    private final int periodeDebut;
    private final int duree;
    private final Professeur professeur;
    private final Groupe[] groupes;

    Lecon(String matiere, String salle, int jourSemaine, int periodeDebut,
          int duree, Professeur professeur, Groupe[] groupes) {
        this.matiere = matiere;
        this.salle = salle;
        this.jourSemaine = jourSemaine;
        this.periodeDebut = periodeDebut;
        this.duree = duree;
        this.professeur = professeur;
        this.groupes = groupes;
    }

    //public String horaire() {}
}
