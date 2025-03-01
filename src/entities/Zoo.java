package tn.esprit.gestionzoo.entities;

public class Zoo {
    private String name;
    private String city;
    private final int MAX_CAGES = 25;
    private Animal[] animals;
    private Aquatic[] aquaticAnimals; // Tableau pour les animaux aquatiques

    public Zoo(String name, String city, int nbrCages) {
        setName(name);
        this.city = city;
        this.animals = new Animal[nbrCages];
        this.aquaticAnimals = new Aquatic[10]; // Initialisation du tableau avec une capacité de 10
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Erreur : Le nom du zoo ne peut pas être vide.");
        }
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public boolean isZooFull() {
        int count = 0;
        for (Animal animal : animals) {
            if (animal != null) count++;
        }
        return count >= MAX_CAGES;
    }

    public boolean addAnimal(Animal animal) {
        if (isZooFull()) {
            System.out.println("Erreur : Le zoo est plein. Impossible d'ajouter l'animal.");
            return false;
        }

        if (searchAnimal(animal) != -1) {
            System.out.println("Erreur : Cet animal existe déjà dans le zoo.");
            return false;
        }

        for (int i = 0; i < animals.length; i++) {
            if (animals[i] == null) {
                animals[i] = animal;
                System.out.println("L'animal " + animal.getName() + " a été ajouté au zoo.");
                return true;
            }
        }
        return false;
    }

    public int searchAnimal(Animal animal) {
        for (int i = 0; i < animals.length; i++) {
            if (animals[i] != null && animals[i].getName().equals(animal.getName())) {
                return i;
            }
        }
        return -1;
    }

    public void displayZoo() {
        System.out.println("Zoo : " + name + " | Ville : " + city);
    }

    public void displayAnimals() {
        System.out.println("Animaux dans le zoo :");
        for (Animal animal : animals) {
            if (animal != null) {
                animal.displayAnimal();
            }
        }
    }

    public boolean addAquaticAnimal(Aquatic aquatic) {
        for (int i = 0; i < aquaticAnimals.length; i++) {
            if (aquaticAnimals[i] == null) {
                aquaticAnimals[i] = aquatic;
                System.out.println("L'animal aquatique " + aquatic.getName() + " a été ajouté au zoo.");
                return true;
            }
        }
        System.out.println("Erreur : Le tableau d'animaux aquatiques est plein.");
        return false;
    }

    public void displayAquaticAnimals() {
        System.out.println("Animaux aquatiques dans le zoo :");
        for (Aquatic aquatic : aquaticAnimals) {
            if (aquatic != null) {
                aquatic.swim();
            }
        }
    }

    public float maxPenguinSwimmingDepth() {
        float maxDepth = 0.0f;
        for (Aquatic aquatic : aquaticAnimals) {
            if (aquatic instanceof Penguin) {
                Penguin penguin = (Penguin) aquatic;
                if (penguin.getSwimmingDepth() > maxDepth) {
                    maxDepth = penguin.getSwimmingDepth();
                }
            }
        }
        return maxDepth;
    }

    public void displayNumberOfAquaticsByType() {
        int dolphinCount = 0;
        int penguinCount = 0;

        for (Aquatic aquatic : aquaticAnimals) {
            if (aquatic instanceof Dolphin) {
                dolphinCount++;
            } else if (aquatic instanceof Penguin) {
                penguinCount++;
            }
        }

        System.out.println("Nombre de dauphins : " + dolphinCount);
        System.out.println("Nombre de pingouins : " + penguinCount);
    }
}