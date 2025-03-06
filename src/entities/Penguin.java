package tn.esprit.gestionzoo.entities;

import tn.esprit.gestionzoo.exceptions.InvalidAgeException;

public class Penguin extends Aquatic {
    protected float swimmingDepth;

    public Penguin() throws InvalidAgeException {
        super(); // Appel du constructeur de la classe parente Aquatic
        this.swimmingDepth = 0.0f;
    }

    public Penguin(String family, String name, int age, boolean isMammal, String habitat, float swimmingDepth) throws InvalidAgeException {
        super(family, name, age, isMammal, habitat); // Appel du constructeur de la classe parente Aquatic
        this.swimmingDepth = swimmingDepth;
    }

    @Override
    public String toString() {
        return super.toString() + ", Profondeur de nage : " + swimmingDepth + " m";
    }

    @Override
    public void swim() {
        System.out.println("Ce pingouin nage à une profondeur de " + swimmingDepth + " mètres.");
    }

    public float getSwimmingDepth() {
        return swimmingDepth;
    }
}