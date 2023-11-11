import java.util.ArrayList;

public class Groupe {
    private final int numero;//todo final ?
    private final String orientation;
    private final int trimestre;
    private final Etudiant[] etudiants;
    private final ArrayList<Lecon> lecons;


    Groupe(int numero, String orientation, int trimestre, Etudiant[] etudiants) {
        if(etudiants.length == 0) {
            throw new RuntimeException("Groupe doit contenir au moins un étudiant");
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

    public void definirLecons(ArrayList<Lecon> lecons){
        if(lecons.isEmpty()) {
            throw new RuntimeException("Doit contenir au moins un cours");
        }
        this.lecons.addAll(lecons);
    }

    public String horaire(){
        return "-- Horaire du groupe " + this.nom() + " (" + this.nombreEtudiants() + " etudiants)\n\n"
                + Lecon.horaire(this.lecons);
    }

    public String nom(){
        return orientation + trimestre + "-" + numero;
    }

    public int nombreEtudiants(){
        return etudiants.length;
    }
}
