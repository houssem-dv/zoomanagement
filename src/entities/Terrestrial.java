package tn.esprit.gestionzoo.entities;

import tn.esprit.gestionzoo.exceptions.InvalidAgeException;

public class Terrestrial extends Animal {
    protected int nbrLegs;

    public Terrestrial() throws InvalidAgeException {
        super("", "", 0, false); // Appel du constructeur de la classe parente Animal
        this.nbrLegs = 0;
    }

    public Terrestrial(String family, String name, int age, boolean isMammal, int nbrLegs) throws InvalidAgeException {
        super(family, name, age, isMammal); // Appel du constructeur de la classe parente Animal
        this.nbrLegs = nbrLegs;
    }

    @Override
    public String toString() {
        return super.toString() + ", Nombre de pattes : " + nbrLegs;
    }
}