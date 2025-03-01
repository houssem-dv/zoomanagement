package tn.esprit.gestionzoo.main;

import tn.esprit.gestionzoo.entities.*;

import java.util.Scanner;

public class ZooManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez le nom du zoo : ");
        String zooName = scanner.nextLine();

        System.out.print("Entrez la ville du zoo : ");
        String city = scanner.nextLine();

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

        Animal lion = new Animal("Félin", "Simba", 5, true);
        Animal tiger = new Animal("Félin", "Tigrou", 4, true);
        Aquatic genericAquatic = new Dolphin("Delphinidae", "Dolly", 3, true, "Océan", 12.0f);
        Terrestrial genericTerrestrial = new Terrestrial("Canidé", "Rex", 2, true, 4);
        Dolphin dolphin = new Dolphin("Delphinidae", "Flipper", 5, true, "Océan", 10.5f);
        Penguin penguin = new Penguin("Spheniscidae", "Pingu", 3, true, "Antarctique", 50.0f);

        myZoo.addAnimal(lion);
        myZoo.addAnimal(tiger);
        myZoo.addAnimal(genericAquatic);
        myZoo.addAnimal(genericTerrestrial);
        myZoo.addAquaticAnimal(dolphin);
        myZoo.addAquaticAnimal(penguin);

        System.out.println("\nInformations du zoo :");
        myZoo.displayZoo();

        System.out.println("\nInformations des animaux :");
        myZoo.displayAnimals();

        System.out.println("\nAnimaux aquatiques :");
        myZoo.displayAquaticAnimals();

        System.out.println("\nProfondeur maximale de nage des pingouins : " + myZoo.maxPenguinSwimmingDepth() + " mètres.");
        myZoo.displayNumberOfAquaticsByType();

        scanner.close();
    }
}