public class Lecon {
    private String matiere;
    private String salle;
    private int jourSemaine;
    private int periodeDebut;
    private int duree;
    private Professeur professeur;

    private Groupe[] groupes;

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
