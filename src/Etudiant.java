/** Cette classe hérite de personne et définit un étudiant tel que demandé dans la donnée
 */
public class Etudiant extends Personne {
    private final int matricule;
    private Groupe groupe;

    /** Constructeur d'étudiant
     * @param prenom prénom à donner à l'étudiant
     * @param nom nom à donner à l'étudiant
     * @param matricule matricule à donner à l'étudiant
     * @throws RuntimeException en cas de d'initialisation de nom ou prénom à null, ce qui pourrait poser problème
     * pour l'affichage
     */
    Etudiant(String prenom, String nom, int matricule) {
        if(prenom == null || nom == null){
            throw new RuntimeException("Prénom ou nom mal initialisé.");
        }
        this.prenom = prenom;
        this.nom = nom;
        this.matricule = matricule;
    }

    /** Méthode permettant d'affecter l'étudiant à son groupe.
     * @param groupe groupe auquel affecter l'étudiant
     */
    void definirGroupe(Groupe groupe){ //TODO visibilité
        this.groupe = groupe;
    }

    /** Retourne les informations à afficher pour l'étudiant.
     * @return la chaîne de caractères à afficher
     */
    public String toString() {
        return "Etud. " + super.toString() + " (#" + matricule + ")" + (groupe == null ? "" : " - " + groupe.nom());
    }
}
