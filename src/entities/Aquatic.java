package tn.esprit.gestionzoo.entities;

import tn.esprit.gestionzoo.exceptions.InvalidAgeException;

public abstract class Aquatic extends Animal implements Carnivore<Food> {
    protected String habitat;

    public Aquatic() throws InvalidAgeException {
        super("", "", 0, false);
        this.habitat = "";
    }

    public Aquatic(String family, String name, int age, boolean isMammal, String habitat) throws InvalidAgeException {
        super(family, name, age, isMammal);
        this.habitat = habitat;
    }

    @Override
    public String toString() {
        return super.toString() + ", Habitat : " + habitat;
    }

    public abstract void swim();

    @Override
    public void eatMeat(Food meat) {
        if (meat == Food.MEAT || meat == Food.BOTH) {
            System.out.println(this.getName() + " (Aquatique) mange de la viande.");
        } else {
            System.out.println(this.getName() + " ne mange pas de végétaux.");
        }
    }
}