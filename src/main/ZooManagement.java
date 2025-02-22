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

        Animal lion = new Animal();
        Animal tiger = new Animal();
        Aquatic genericAquatic = new Aquatic();
        Terrestrial genericTerrestrial = new Terrestrial();
        Dolphin dolphin = new Dolphin();
        Penguin penguin = new Penguin();

        myZoo.addAnimal(lion);
        myZoo.addAnimal(tiger);
        myZoo.addAnimal(genericAquatic);
        myZoo.addAnimal(genericTerrestrial);
        myZoo.addAnimal(dolphin);
        myZoo.addAnimal(penguin);

        //Remarque (Instruction 22):
        //Lorsqu'on ajoute des constructeurs paramétrés dans les classes filles le constructeur par défaut n'existe plus automatiquement
        // car Java ne génère plus le constructeur par défaut.
        //Donc il faut redéfinir un constructeur par défaut en plus du constructeur paramétré.

        System.out.println("\nInformations du zoo :");
        myZoo.displayZoo();

        System.out.println("\nInformations des animaux :");
        myZoo.displayAnimals();

        genericAquatic.swim();
        dolphin.swim();
        penguin.swim();

        //Remarque (Instruction 24)
        //La méthode swim() de Penguin utilise celle de Aquatic, car elle n'est pas redéfinie
        // Penguin n'a pas sa propre version de swim(), donc il hérite celle de Aquatic.


        if (myZoo.isZooFull()) {
            System.out.println("\nLe zoo est plein.");
        } else {
            System.out.println("\nLe zoo n'est pas plein.");
        }

        scanner.close();
    }
}
