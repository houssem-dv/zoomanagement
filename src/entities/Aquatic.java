package tn.esprit.gestionzoo.entities;

import tn.esprit.gestionzoo.exceptions.InvalidAgeException;

public abstract class Aquatic extends Animal {
    protected String habitat;

    public Aquatic() throws InvalidAgeException {
        super("", "", 0, false); // Appel du constructeur de la classe parente Animal
        this.habitat = "";
    }

    public Aquatic(String family, String name, int age, boolean isMammal, String habitat) throws InvalidAgeException {
        super(family, name, age, isMammal); // Appel du constructeur de la classe parente Animal
        this.habitat = habitat;
    }

    @Override
    public String toString() {
        return super.toString() + ", Habitat : " + habitat;
    }

    public abstract void swim();
}