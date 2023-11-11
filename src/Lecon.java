import java.util.ArrayList;

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
        if (!(professeur == null)) {
            professeur.ajouterLecon(this);
        }
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

    public static String horaire(ArrayList<Lecon> lecons) {
        int rows = 11;
        int columns = 5;
        String lines = "-------------";
        String spaces = "             ";
        String[][] emploiDuTemps = new String[rows][columns];

        // Remplissage de l'emploi du temps avec les informations des leçons
        for (Lecon lecon : lecons) {
            int startCase = lecon.getDebut();
            int day = lecon.getJourSemaine();
            String printProf = "   ";
            if(lecon.getProfesseur() != null){
                printProf = lecon.getProfesseur().abreviation();
            }

            String lessonInfo = lecon.getNom() + "   " + lecon.getSalle() + " " + printProf;
            int duration = lecon.getDuree();

            for (int i = 0; i < duration; i++) {
                emploiDuTemps[startCase + i - 1][day - 1] = lessonInfo;
            }
        }
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns; j++) {
                if(emploiDuTemps[i][j] == null) {
                    emploiDuTemps[i][j] = spaces;
                }
            }
        }

        // Génération de l'horaire
        StringBuilder schedule = new StringBuilder();

        String header  = "     | Lun         | Mar         | Mer         | Jeu         | Ven         |\n";
        String sepLine = "     |-------------|-------------|-------------|-------------|-------------|\n";

        schedule.append(header);
        schedule.append(sepLine);

        String[] heuresPeriodes = new String[]{" 8:30", " 9:15", "10:25", "11:15", "12:00", "13:15", "14:00",
                "14:55", "15:45", "16:35", "17:20"};

        for (int i = 0; i < rows; ++i) {
            schedule.append(heuresPeriodes[i]);
            // Affiche un cours
            for (int k = 0; k < columns; k++) {
                String s = i > 0
                        && i < rows - 1
                        && emploiDuTemps[i][k].equals(emploiDuTemps[i - 1][k])
                        && !emploiDuTemps[i][k].equals(emploiDuTemps[i + 1][k])
                        && !emploiDuTemps[i][k].equals(spaces) ? spaces : emploiDuTemps[i][k];
                String sf1 = String.format("|%s", s);
                schedule.append(sf1);
            }
            schedule.append("|\n");
            schedule.append("     ");
            // Affiche un séparateur
            for (int j = 0; j < columns; j++) {
                String s = i < rows - 1
                        && emploiDuTemps[i][j].equals(emploiDuTemps[i + 1][j])
                        && !emploiDuTemps[i][j].equals(spaces) ? spaces : lines;
                String sf2 = String.format("|%s", s);
                schedule.append(sf2);
            }
            schedule.append("|\n");
        }

        return schedule.toString();
    }
}
