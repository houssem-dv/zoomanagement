public class Main {
    public static void main(String[] args) {
        SocieteArrayList societe = new SocieteArrayList();

        societe.ajouterEmploye(new Employe(1, "dridi", "houssem", "IT", 3));
        societe.ajouterEmploye(new Employe(2, "dridi", "Ahmed", "RH", 2));
        societe.ajouterEmploye(new Employe(3, "ouerghi", "saloua", "Finance", 4));

        System.out.println("Liste des employés:");
        societe.displayEmploye();

        System.out.println("\nRecherche de 'ouerghi': " + societe.rechercherEmploye("ouerghi"));

        // Tri par ID
        System.out.println("\nTri par ID:");
        societe.trierEmployeParId();
        societe.displayEmploye();

        // Tri par département et grade
        System.out.println("\nTri par département et grade:");
        societe.trierEmployeParNomDepartementEtGrade();
        societe.displayEmploye();
    }
}