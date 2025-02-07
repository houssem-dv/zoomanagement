public class Zoo {
    String name;
    String city;
    final int MAX_CAGES = 25;
    Animal[] animals;

    public Zoo(String name, String city, int nbrCages) {
        this.name = name;
        this.city = city;
        this.animals = new Animal[nbrCages];
    }

    public void displayZoo() {
        System.out.println("Zoo : " + name + "  Ville : " + city + "  Cages : " + MAX_CAGES);
    }

    public boolean addAnimal(Animal animal) {
        if (isZooFull()) {
            System.out.println("Le zoo est plein. Impossible d'ajouter l'animal.");
            return false;
        }

        if (searchAnimal(animal) != -1) {
            System.out.println("Cet animal existe déjà dans le zoo.");
            return false;
        }

        for (int i = 0; i < animals.length; i++) {
            if (animals[i] == null) {
                animals[i] = animal;
                System.out.println("L'animal " + animal.name + " a été ajouté au zoo.");
                return true;
            }
        }
        return false;
    }

    public void displayAnimals() {
        System.out.println("Animaux dans le zoo :");
        for (Animal animal : animals) {
            if (animal != null) {
                animal.displayAnimal();
            }
        }
    }

    public int searchAnimal(Animal animal) {
        for (int i = 0; i < animals.length; i++) {
            if (animals[i] != null && animals[i].name.equals(animal.name)) {
                return i;
            }
        }
        return -1;
    }

    public boolean removeAnimal(Animal animal) {
        int index = searchAnimal(animal);
        if (index != -1) {
            animals[index] = null;
            System.out.println("L'animal " + animal.name + " a été supprimé.");
            return true;
        } else {
            System.out.println("L'animal n'a pas été trouvé.");
            return false;
        }
    }

    public boolean isZooFull() {
        int animalCount = 0;
        for (Animal animal : animals) {
            if (animal != null) animalCount++;
        }
        return animalCount >= MAX_CAGES;
    }

    public static Zoo comparerZoo(Zoo z1, Zoo z2) {
        int countZ1 = 0, countZ2 = 0;
        for (Animal animal : z1.animals) {
            if (animal != null) countZ1++;
        }
        for (Animal animal : z2.animals) {
            if (animal != null) countZ2++;
        }
        return countZ1 >= countZ2 ? z1 : z2;
    }
}
