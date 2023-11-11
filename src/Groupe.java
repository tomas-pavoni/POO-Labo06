import java.util.ArrayList;

/** Cette classe définit les méthodes et données membres d'un groupe tel que défini dans la donnée
 */
public class Groupe {
    private final int numero;
    private final String orientation;
    private final int trimestre;
    private final Etudiant[] etudiants;
    private final ArrayList<Lecon> lecons;

    /** Constructeur de groupe. Celui-ci affecte aussi le groupe aux étudiants lors de son appel.
     * @param numero numéro du groupe
     * @param orientation nom de l'orientation du groupe
     * @param trimestre numéro du trimestre
     * @param etudiants tableau contenant les étudiants à ajouter au groupe.
     * @throws RuntimeException en cas de paramètres posant problème pour l'affichage ou en cas de groupe sans étudiant.
     */
    Groupe(int numero, String orientation, int trimestre, Etudiant[] etudiants) {
        if(etudiants.length == 0) {
            throw new RuntimeException("Groupe doit contenir au moins un étudiant");
        }
        if(orientation == null){
            throw new RuntimeException("L'orientation d'un groupe doit être définie.");
        }
        for(Etudiant e : etudiants){
            if(e == null){
                throw new RuntimeException("Un étudiant du groupe ne peut pas être null.");
            }
            e.definirGroupe(this);
        }
        this.numero = numero;
        this.orientation = orientation;
        this.trimestre = trimestre;
        this.etudiants = etudiants;
        this.lecons = new ArrayList<>();
    }

    /** Setter pour les leçons du groupe
     * @param lecons
     * @throws RuntimeException en cas de définition sans leçon.
     */
    public void definirLecons(ArrayList<Lecon> lecons){
        if(lecons.isEmpty()) {
            throw new RuntimeException("Doit contenir au moins un cours");
        }
        this.lecons.addAll(lecons);
    }

    /** Retourne l'horaire à afficher pour le groupe, précédé d'une ligne d'informations.
     * @returns la chaîne de caractères à afficher
     */
    public String horaire(){
        return "-- Horaire du groupe " + this.nom() + " (" + this.nombreEtudiants() + " etudiants)\n\n"
                + Lecon.horaire(this.lecons);
    }

    /** Retourne le nom du groupe pour affichage par les autres classes.
     * @returns la chaîne de caractères définie comme nom du groupe
     */
    public String nom(){
        return orientation + trimestre + "-" + numero;
    }

    /** Méthode permettant de connaître le nombre d'étudiants dans un groupe.
     * @returns le nombre d'étudiants
     */
    public int nombreEtudiants(){
        return etudiants.length;
    }
}