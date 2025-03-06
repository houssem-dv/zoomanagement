package tn.esprit.gestionzoo.entities;

import tn.esprit.gestionzoo.exceptions.InvalidAgeException;

public class Dolphin extends Aquatic {
    protected float swimmingSpeed;

    public Dolphin() throws InvalidAgeException {
        super(); // Appel du constructeur de la classe parente Aquatic
        this.swimmingSpeed = 0.0f;
    }

    public Dolphin(String family, String name, int age, boolean isMammal, String habitat, float swimmingSpeed) throws InvalidAgeException {
        super(family, name, age, isMammal, habitat); // Appel du constructeur de la classe parente Aquatic
        this.swimmingSpeed = swimmingSpeed;
    }

    @Override
    public String toString() {
        return super.toString() + ", Vitesse de nage : " + swimmingSpeed + " m/s";
    }

    @Override
    public void swim() {
        System.out.println("Ce dauphin nage rapidement à " + swimmingSpeed + " m/s.");
    }
}