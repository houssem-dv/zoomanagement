import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        DepartementHashSet gestion = new DepartementHashSet();

        Departement d1 = new Departement(1, "Informatique", 20);
        Departement d2 = new Departement(2, "RH", 10);
        Departement d3 = new Departement(3, "Finance", 15);

        gestion.ajouterDepartement(d1);
        gestion.ajouterDepartement(d2);
        gestion.ajouterDepartement(d3);

        System.out.println("Liste des départements :");
        gestion.displayDepartement();

        System.out.println("\nRecherche du département 'RH': " + gestion.rechercherDepartement("RH"));

        System.out.println("\nDépartements triés par ID :");
        TreeSet<Departement> sorted = gestion.trierDepartementById();
        for (Departement d : sorted) {
            System.out.println(d);
        }
    }
}
