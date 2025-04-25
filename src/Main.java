import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        AffectationHashMap gestion = new AffectationHashMap();

        Employe e1 = new Employe(1, "Dridi", "Houssem", "IT", 3);
        Employe e2 = new Employe(2, "ouerghi", "Saloua", "RH", 2);
        Employe e3 = new Employe(3, "Dridi", "Ines", "Finance", 1);

        Departement d1 = new Departement(101, "IT", 20);
        Departement d2 = new Departement(102, "RH", 15);
        Departement d3 = new Departement(103, "Finance", 10);

        gestion.ajouterEmployeDepartement(e1, d1);
        gestion.ajouterEmployeDepartement(e2, d2);
        gestion.ajouterEmployeDepartement(e3, d3);

        System.out.println("=== Affectations Initiales ===");
        gestion.afficherEmployesEtDepartements();

        gestion.ajouterEmployeDepartement(e1, d2);
        System.out.println(" Après Réaffectation d'e1 à un autre département :");
        gestion.afficherEmployesEtDepartements();
        // Vous remarquerez que e1 est désormais uniquement dans le dernier département (d2)

        gestion.supprimerEmploye(e2);

        System.out.println(" Après suppression d'e2 : ");
        gestion.afficherEmployesEtDepartements();

        System.out.println("e3 existe ? " + gestion.rechercherEmploye(e3));
        System.out.println("Département RH existe ? " + gestion.rechercherDepartement(d2));

        System.out.println(" Liste Employés: ");
        gestion.afficherEmployes();

        System.out.println("Liste Départements :");
        gestion.afficherDepartements();

        System.out.println(" Affectations triées par ID Employé :");
        TreeMap<Employe, Departement> sortedMap = gestion.trierMap();
        for (Map.Entry<Employe, Departement> entry : sortedMap.entrySet()) {
            System.out.println("Employé: " + entry.getKey() + "  Département: " + entry.getValue());
        }
    }
}
