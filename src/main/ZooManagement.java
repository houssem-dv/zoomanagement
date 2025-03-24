package tn.esprit.gestionzoo.main;

import tn.esprit.gestionzoo.entities.*;
import tn.esprit.gestionzoo.exceptions.InvalidAgeException;
import tn.esprit.gestionzoo.exceptions.ZooFullException;

import java.util.Scanner;

public class ZooManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez le nom du zoo : ");
        String zooName = scanner.nextLine();

        System.out.print("Entrez la ville du zoo : ");
        String city = scanner.nextLine();

        int nbrCages = 3;
        Zoo myZoo = new Zoo(zooName, city, nbrCages);

        try {

            Aquatic shark = new Dolphin("Requinidae", "Sharky", 7, true, "Océan", 15.0f);
            Penguin happyFeet = new Penguin("Spheniscidae", "Happy Feet", 4, true, "Antarctique", 30.0f);
            Terrestrial bear = new Terrestrial("Ursidae", "Baloo", 10, true, 4);


            shark.eatMeat(Food.MEAT);
            shark.eatMeat(Food.PLANT);
            bear.eatPlantAndMeat(Food.BOTH);
            bear.eatMeat(Food.MEAT);
            bear.eatPlant(Food.PLANT);

            happyFeet.eatMeat(Food.MEAT);

            myZoo.addAquaticAnimal(shark);
            myZoo.addAquaticAnimal(happyFeet);
            myZoo.addAnimal(bear);

        } catch (ZooFullException | InvalidAgeException e) {
            System.out.println("Erreur : " + e.getMessage());
        }

        scanner.close();
    }
}