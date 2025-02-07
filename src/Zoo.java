public class Zoo {
    String name;
    String city;
    int nbrCages;
    Animal[] animals;

    // Constructeur paramétré
    public Zoo(String name, String city, int nbrCages) {
        this.name = name;
        this.city = city;
        this.nbrCages = nbrCages;
        this.animals = new Animal[25]; // Max 25 animaux
    }

    // Méthode d'affichage
    public void displayZoo() {
        System.out.println("Zoo : " + name + "  Ville : " + city + "  Cages : " + nbrCages);
    }
}
