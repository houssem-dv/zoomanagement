import java.util.Scanner;

public class ZooManagement {
    public static void main(String[] args) {
        int nbrCages = 20;
        String zooName = "my zoo";
        System.out.println(zooName + " comporte " + nbrCages + " cages");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez le nom du zoo : ");
        zooName = scanner.nextLine();

        System.out.print("Entrez la ville du zoo : ");
        String city = scanner.nextLine();

        do {
            System.out.print("Entrez le nombre de cages : ");
            while (!scanner.hasNextInt()) {
                System.out.println("Veuillez entrer un nombre valide : ");
                scanner.next();
            }
            nbrCages = scanner.nextInt();
            if (nbrCages <= 0) {
                System.out.println("Le nombre de cages doit être supérieur à 0. Réessayez.");
            }
        } while (nbrCages <= 0);

        Zoo myZoo = new Zoo(zooName, city, nbrCages);

        Animal lion = new Animal("Félins", "Lion", 5, true);
        Animal tiger = new Animal("Félins", "Tigre", 4, true);

        myZoo.addAnimal(lion);
        myZoo.addAnimal(tiger);
        System.out.println(zooName + " comporte " + nbrCages + " cages");

        System.out.println("\nInformations du zoo :");
        myZoo.displayZoo();

        System.out.println("\nInformations des animaux :");
        myZoo.displayAnimals();

        int index = myZoo.searchAnimal(lion);
        System.out.println("\nIndex de l'animal Lion: " + index);

        myZoo.removeAnimal(tiger);
        System.out.println("\nAprès suppression de l'animal Tigre :");
        myZoo.displayAnimals();

        if (myZoo.isZooFull()) {
            System.out.println("\nLe zoo est plein.");
        } else {
            System.out.println("\nLe zoo n'est pas plein.");
        }

        Zoo zoo2 = new Zoo("Zoo Lyon", "Lyon", 15);
        zoo2.addAnimal(new Animal("Oiseaux", "Perroquet", 3, false));
        zoo2.addAnimal(new Animal("Mammifères", "Elephant", 8, true));

        Zoo winnerZoo = Zoo.comparerZoo(myZoo, zoo2);
        System.out.println("\nLe zoo avec le plus d'animaux est : " + winnerZoo.name);

        scanner.close();
    }
}
