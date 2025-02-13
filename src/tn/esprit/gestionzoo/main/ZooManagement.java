package tn.esprit.gestionzoo.main;

import tn.esprit.gestionzoo.entities.Zoo;
import tn.esprit.gestionzoo.entities.Animal;
import java.util.Scanner;

public class ZooManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez le nom du zoo : ");
        String zooName = scanner.nextLine().trim();

        System.out.print("Entrez la ville du zoo : ");
        String city = scanner.nextLine().trim();

        int nbrCages;
        do {
            System.out.print("Entrez le nombre de cages (doit être positif) : ");
            while (!scanner.hasNextInt()) {
                System.out.println("Veuillez entrer un nombre valide : ");
                scanner.next();
            }
            nbrCages = scanner.nextInt();
        } while (nbrCages <= 0);

        Zoo myZoo = new Zoo(zooName, city, nbrCages);

        // Création d'animaux
        Animal lion = new Animal("Félins", "Lion", 5, true);
        Animal tiger = new Animal("Félins", "Tigre", 4, true);

        // Ajout des animaux au zoo
        myZoo.addAnimal(lion);
        myZoo.addAnimal(tiger);

        // Affichage des informations du zoo
        System.out.println("\nInformations du zoo :");
        myZoo.displayZoo();

        // Affichage des animaux du zoo
        System.out.println("\nInformations des animaux :");
        myZoo.displayAnimals();

        // Vérifier si le zoo est plein
        if (myZoo.isZooFull()) {
            System.out.println("\nLe zoo est plein.");
        } else {
            System.out.println("\nLe zoo n'est pas plein.");
        }

        scanner.close();
    }
}
