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

    int getDebut(){
        return periodeDebut;
    }

    int getDuree(){
        return duree;
    }

    int getJourSemaine(){
        return jourSemaine;
    }

    String getNom(){
        return matiere;
    }

    String getSalle(){
        return salle;
    }

    Professeur getProfesseur(){
        return professeur;
    }

    //public STATIC String horaire() {}
    // La méthode horaire() dans la classe Leçon est statique (indépendante de tout objet).
}
