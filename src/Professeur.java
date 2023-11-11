import java.util.ArrayList;

/** Cette classe hérite de personne et définit un professeur tel que demandé dans la donnée
 */
public class Professeur extends Personne{
    private final String abreviation;
    private final ArrayList<Lecon> lecons;

    /** Constructeur de professeur.
     * @param prenom prénom à donner au professeur
     * @param nom nom à donner au professeur
     * @param abreviation abréviation du professeur
     * @throws RuntimeException en cas de d'initialisation de nom, prénom ou matricule à null, ce qui pourrait poser
     * problème pour l'affichage
     */
    Professeur(String prenom, String nom, String abreviation) {
        if(prenom == null || nom == null || abreviation == null){
            throw new RuntimeException("Prénom, nom ou abréviation mal initialisé.");
        }
        this.prenom = prenom;
        this.nom = nom;
        this.abreviation = abreviation;
        this.lecons = new ArrayList<>();
    }

    /** Méthode permettant d'affecter une leçon à un professeur.
     * @param lecon leçon à affecter au professeur
     * @throws RuntimeException en cas d'ajout d'une leçon null.
     */
    void ajouterLecon(Lecon lecon){
        if(lecon == null){
            throw new RuntimeException("La leçon ajoutée ne peut pas être null.");
        }
        this.lecons.add(lecon);
    }

    /** Getteur pour l'abréviation du professeur.
     * @returns l'abréviation du professeur
     */
    public String abreviation() {
        return abreviation;
    }

    /** Retourne l'horaire à afficher pour le professeur, précédé d'une ligne d'informations.
     * @returns la chaîne de caractères à afficher
     */
    public String horaire() {
        return "-- Horaire du Prof. " + this + "\n\n"
                +  Lecon.horaire(this.lecons);
    }

    /** Retourne les informations à afficher pour le professeur.
     * @returns la chaîne de caractères à afficher
     */
    public String toString() {
        return "Prof. " + super.toString() + " (" + abreviation + ")";
    }
}
