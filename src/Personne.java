/** Cette classe, dont hériteront etudiant et professeur, définit les méthodes et variables communes à ces deux classes.
 */
public abstract class Personne {
    protected String nom;
    protected String prenom;

    /** Retourne le prénom et nom de la personne pour l'affichage
     * @returns la chaîne de caractères à afficher
     */
    public String toString() {
        return prenom + " " + nom;
    }

}
