public class Groupe {
    private int numero;

    private final Etudiant[] etudiants;

    private String orientation;

    private int trimestre;

    private String nom;

    public String horaire(){
        return null;
    }

    public String nom(){
        return nom;
    }

    public int nombreEtudiants(){
        return etudiants.length;
    }

    public void definirLecons(){

    }

    public Groupe(){
        etudiants = null;
    }
}
