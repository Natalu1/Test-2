package com.company.ex3;

public class AnimalId {
    private String animalName;
    private String ownerFullName;

    public AnimalId(String animalName, String ownerFullName) {
        this.animalName = animalName;
        this.ownerFullName = ownerFullName;
    }

    @Override
    public String toString() {
        return "Animal name: " + animalName  +
                ", owner full name: " + ownerFullName;
    }
}
