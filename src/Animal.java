public class Animal {
    String family;
    String name;
    int age;
    boolean isMammal;

    // Constructeur paramétré
    public Animal(String family, String name, int age, boolean isMammal) {
        this.family = family;
        this.name = name;
        this.age = age;
        this.isMammal = isMammal;
    }

    // Méthode d'affichage
    public void displayAnimal() {
        System.out.println("Animal : " + name + ", Famille : " + family + ", Âge : " + age + ", Mammifère : " + (isMammal ? "Oui" : "Non"));
    }
}
