public class Main {
    public static void main(String[] args) {
        //TODO
        System.out.println("-- Membres de l'ecole\n");

        //1
        Professeur pdo = new Professeur("Pier", "Donini", "PDO");
        Professeur dre = new Professeur("Daniel", "Rossier", "DRE");

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
        il61.definirLecons(poo1);
        il61.definirLecons(poo2);
        il61.definirLecons(poo3);
        il61.definirLecons(sye1);
        il61.definirLecons(sye2);
        il61.definirLecons(tic);
        si61.definirLecons(poo1);
        si61.definirLecons(poo2);
        si61.definirLecons(poo1);

        //6
        Personne[] personnes = {pdo, dre, jl, pm, rs, gh, rw, dg};
        for(Personne p : personnes){
            System.out.println(p);
        }

        //7
        System.out.println("\n-- Horaire du groupe " + il61.nom() + " (" + il61.nombreEtudiants() + (" etudiants)") );
        System.out.println(il61.horaire());

        //8
        System.out.println("-- Horaire " + pdo);
        System.out.println(pdo.horaire());
    }
}
