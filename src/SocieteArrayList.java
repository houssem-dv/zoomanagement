import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SocieteArrayList implements IGestion<Employe> {
    private ArrayList<Employe> employes = new ArrayList<>();

    @Override
    public void ajouterEmploye(Employe t) {
        employes.add(t);
    }

    @Override
    public boolean rechercherEmploye(String nom) {
        for (Employe e : employes) {
            if (e.getNom().equals(nom)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean rechercherEmploye(Employe t) {
        return employes.contains(t);
    }

    @Override
    public void supprimerEmploye(Employe t) {
        employes.remove(t);
    }

    @Override
    public void displayEmploye() {
        for (Employe e : employes) {
            System.out.println(e);
        }
    }

    @Override
    public void trierEmployeParId() {
        Collections.sort(employes, new Comparator<Employe>() {
            @Override
            public int compare(Employe o1, Employe o2) {
                return Integer.compare(o1.getId(), o2.getId());
            }
        });
    }

    @Override
    public void trierEmployeParNomDepartementEtGrade() {
        Collections.sort(employes, new Comparator<Employe>() {
            @Override
            public int compare(Employe o1, Employe o2) {
                int result = o1.getNomDepartement().compareTo(o2.getNomDepartement());
                if (result == 0) {
                    return Integer.compare(o1.getGrade(), o2.getGrade());
                }
                return result;
            }
        });
    }
}