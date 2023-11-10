import java.util.ArrayList;
import java.util.Arrays;

public class Groupe {
    private int numero;//todo final ?
    private String orientation;
    private int trimestre;
    private final Etudiant[] etudiants;
    private final ArrayList<Lecon> lecons;//todo difference betwen 0..* and 1..*


    Groupe(int numero, String orientation, int trimestre, Etudiant[] etudiants) {
        if(etudiants.length == 0) {
            throw new RuntimeException("Groupe must contain at least 1 student");
        }
        this.numero = numero;
        this.orientation = orientation;
        this.trimestre = trimestre;
        this.etudiants = etudiants;
        for(Etudiant e : etudiants){
            e.definirGroupe(this);
        }
        this.lecons = new ArrayList<>();
    }

    public void definirLecons(Lecon lecon){
        this.lecons.add(lecon);
    }

    public String horaire(){
        String[][] emploiDuTemps = new String[11][5];

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

        // Génération de l'horaire
        StringBuilder schedule = new StringBuilder();

        String sepLine = "     |-------------|-------------|-------------|-------------|-------------|\n";
        String header = "     | Lun         | Mar         | Mer         | Jeu         | Ven         |\n";

        schedule.append(header);
        schedule.append(sepLine);

        String[] heuresPeriodes = new String[]{" 8:30", " 9:15", "10:25", "11:15", "12:00", "13:15", "14:00",
                "14:55", "15:45", "16:35", "17:20"};
        for (int i = 0; i < 11; i++) {
            String time = heuresPeriodes[i];
            schedule.append(time);

            for (int j = 0; j < 5; j++) {
                schedule.append("|");

                if (emploiDuTemps[i][j] != null && !emploiDuTemps[i][j].isEmpty()) {
                    schedule.append(emploiDuTemps[i][j]);
                } else {
                    schedule.append("             ");
                }
            }
            schedule.append("|\n");
            schedule.append(sepLine);
        }

        return schedule.toString();
    }

    public String nom(){
        return orientation + trimestre + "-" + numero;
    }

    public int nombreEtudiants(){
        return etudiants.length;
    }
}
