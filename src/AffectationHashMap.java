import java.util.*;

public class AffectationHashMap {
    private HashMap<Employe, Departement> affectations = new HashMap<>();

    // Instruction 2
    public void ajouterEmployeDepartement(Employe e, Departement d) {
        affectations.put(e, d); // Un employé ne peut avoir qu'un seul département
    }

    // Instruction 3
    public void afficherEmployesEtDepartements() {
        for (Map.Entry<Employe, Departement> entry : affectations.entrySet()) {
            System.out.println("Employé: " + entry.getKey());
            System.out.println("Département: " + entry.getValue());
            System.out.println("-----");
        }
    }

    // Instruction 4
    public void supprimerEmploye(Employe e) {
        affectations.remove(e);
    }

    // Instruction 5
    public void supprimerEmployeEtDepartement(Employe e, Departement d) {
        if (affectations.containsKey(e) && affectations.get(e).equals(d)) {
            affectations.remove(e);
        }
    }

    // Instruction 6
    public void afficherEmployes() {
        for (Employe e : affectations.keySet()) {
            System.out.println(e);
        }
    }

    // Instruction 7
    public void afficherDepartements() {
        for (Departement d : affectations.values()) {
            System.out.println(d);
        }
    }

    // Instruction 8
    public boolean rechercherEmploye(Employe e) {
        return affectations.containsKey(e);
    }

    // Instruction 9
    public boolean rechercherDepartement(Departement d) {
        return affectations.containsValue(d);
    }

    // Instruction 10
    public TreeMap<Employe, Departement> trierMap() {
        return new TreeMap<>(Comparator.comparingInt(Employe::getId)) {{
            putAll(affectations);
        }};
    }
}
