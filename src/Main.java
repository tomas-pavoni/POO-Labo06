import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //1
        Professeur dre = new Professeur("Daniel", "Rossier", "DRE");
        Professeur pdo = new Professeur("Pier", "Donini", "PDO");

        //2
        Lecon poo1 = new Lecon("POO", "H02", 3, 6, 2, pdo);
        Lecon poo2 = new Lecon("POO", "H02", 4, 6, 2, pdo);
        Lecon poo3 = new Lecon("POO", "H02", 4, 8, 2, pdo);
        Lecon sye1 = new Lecon("SYE", "G01", 1, 1, 2, dre);
        Lecon sye2 = new Lecon("SYE", "A09", 4, 3, 2, dre);
        Lecon tic = new Lecon("TIC", "F06", 2, 10, 1, null);

        //3
        Etudiant jl = new Etudiant("John", "Lennon", 1234);
        Etudiant pm = new Etudiant("Paul", "McCartney", 2341);
        Etudiant rs = new Etudiant("Ringo", "Starr", 3241);
        Etudiant gh = new Etudiant("George", "Harisson", 4321);
        Etudiant rw = new Etudiant("Roger", "Waters", 1324);
        Etudiant dg = new Etudiant("David", "Gilmour", 4312);

        //4
        Groupe il61 = new Groupe(1, "IL", 6, new Etudiant[]{jl, pm, rs, gh});
        Groupe si61 = new Groupe(1, "SI", 6, new Etudiant[]{rw, dg});

        //5
        ArrayList<Lecon> pooLecons = new ArrayList<>();
        pooLecons.add(poo1);
        pooLecons.add(poo2);
        pooLecons.add(poo3);

        ArrayList<Lecon> lecons = new ArrayList<>(pooLecons);
        lecons.add(sye1);
        lecons.add(sye2);
        lecons.add(tic);

        il61.definirLecons(lecons);
        si61.definirLecons(pooLecons);


        //6
        System.out.println("-- Membres de l'ecole\n");
        Personne[] personnes = {pdo, dre, jl, pm, rs, gh, rw, dg};
        for(Personne p : personnes){
            System.out.println(p);
        }

        //7
        System.out.println();
        System.out.println(il61.horaire());

        //8
        System.out.println();
        System.out.println(pdo.horaire());
    }
}
