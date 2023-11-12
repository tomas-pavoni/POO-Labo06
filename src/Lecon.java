import java.util.ArrayList;

/** Cette classe définit les méthodes et données membres d'une leçon telle que définie dans la donnée.
 */
public class Lecon {
    private final String matiere;
    private final String salle;
    private final int jourSemaine;
    private final int periodeDebut;
    private final int duree;
    private final Professeur professeur;

    /** Constructeur de leçon. Celui-affecte également la leçon au professeur.
     * @param matiere nom de la matière
     * @param salle nom de la salle où aura lieu la leçon
     * @param jourSemaine jour de la semaine (1 = lundi, 5 = vendredi)
     * @param periodeDebut période (entre 1 et 11)
     * @param duree (entre 1 et 11)
     * @param professeur professeur auquel affecter la leçon
     * @throws RuntimeException en cas de paramètres posant problème pour l'affichage ou logiquement invalides.
     */
    Lecon(String matiere, String salle, int jourSemaine, int periodeDebut,
          int duree, Professeur professeur) {
        if(matiere == null || salle == null){
            throw new RuntimeException("La matière et la salle doivent avoir une valeur autre que null.");
        }
        if(jourSemaine < 1 || jourSemaine > 5){
            throw new RuntimeException("Le jour de la semaine doit être compris entre 1 (lundi) et 5 (vendredi)");
        }
        if(periodeDebut > 11 || periodeDebut < 1 || duree > 11 || duree < 1){
            throw new RuntimeException("La période de début et la durée doivent être comprises entre 1 et 11");
        }
        if (periodeDebut + duree > 11){
            throw new RuntimeException("Une leçon ne peut pas durer jusqu'à plus de la 11ème période");
        }
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

    /** Getter pour la période de début
     * @returns période de début de la leçon
     */
    int getDebut(){
        return periodeDebut;
    }

    /** Getter pour la durée
     * @returns durée de la leçon
     */
    int getDuree(){
        return duree;
    }

    /** Getter pour le jour de la semaine
     * @returns jour de la semaine de la leçon
     */
    int getJourSemaine(){
        return jourSemaine;
    }

    /** Getter pour le nom
     * @returns nom de la matière
     */
    String getNom(){
        return matiere;
    }

    /** Getter pour la salle
     * @returns salle dans laquelle est donnée la leçon
     */
    String getSalle(){
        return salle;
    }

    /** Getter pour le professeur
     * @returns professeur donnant la leçon
     */
    Professeur getProfesseur(){
        return professeur;
    }

    /** Méthode d'affichage d'horaire sous forme tabulaire.
     * @param lecons leçons à inclure dans l'horaire
     * @returns chaîne de caractères permettant d'afficher un horaire sous forme de table contenant les leçons
     */
    public static String horaire(ArrayList<Lecon> lecons) {
        int rows = 11;
        int columns = 5;
        String lines = "-------------";
        String spaces = "             ";
        String[][] emploiDuTemps = new String[rows][columns];
        Lecon[][] leconsArr = new Lecon[rows][columns];

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
                leconsArr[startCase + i - 1][day - 1] = lecon;
            }
        }
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns; j++) {
                if(emploiDuTemps[i][j] == null
                        || i > 0
                        && emploiDuTemps[i][j].equals(emploiDuTemps[i - 1][j])
                        && !emploiDuTemps[i][j].equals(spaces)) {
                    emploiDuTemps[i][j] = spaces;
                    leconsArr[i][j] = null;
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
            String sf1 = String.format("|%s|%s|%s|%s|%s|\n     ",
                    emploiDuTemps[i][0],
                    emploiDuTemps[i][1],
                    emploiDuTemps[i][2],
                    emploiDuTemps[i][3],
                    emploiDuTemps[i][4]);
            schedule.append(sf1);
            // Affiche un séparateur
            for (int j = 0; j < columns; j++) {
                String s = leconsArr[i][j] != null && leconsArr[i][j].getDuree() == 2 ? spaces : lines;
                String sf2 = String.format("|%s", s);
                schedule.append(sf2);
            }
            schedule.append("|\n");
        }

        return schedule.toString();
    }
}
