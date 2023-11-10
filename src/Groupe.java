import java.util.ArrayList;

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

    public String horaire(){ return null; }

    public String nom(){
        return orientation + trimestre + "-" + numero;
    }

    public int nombreEtudiants(){
        return etudiants.length;
    }
}
