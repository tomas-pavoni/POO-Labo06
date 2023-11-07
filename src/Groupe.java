public class Groupe {
    private int numero;//todo final ?
    private String orientation;
    private int trimestre;
    private final Etudiant[] etudiants;
    private Lecon[] lecons;

    Groupe(int numero, String orientation, int trimestre, Etudiant[] etudiants) {
        if(etudiants.length == 0) {
            throw new RuntimeException("Groupe must contain at least 1 student");
        }
        this.numero = numero;
        this.orientation = orientation;
        this.trimestre = trimestre;
        this.etudiants = etudiants;
    }

    //public String horaire(){ return null; }

    public String nom(){
        return orientation + trimestre + "-" + numero;
    }

    public int nombreEtudiants(){
        return etudiants.length;
    }

    public void definirLecons(){}

    public Groupe(){
        etudiants = null;
    }
}
