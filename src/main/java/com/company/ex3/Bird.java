package com.company.ex3;

import com.company.ex2.Person;
import io.vavr.collection.Set;


public class Bird extends Animal{

    private int flySpeed;

    @Override
    void giveVoice() {
        System.out.println("ćwir ćwir");
    }

    @Override
    int getSortAttribute() {
        return flySpeed*2;
    }

    public Bird(String name, Set<Person> owners, int flySpeed) {
        super(name, owners);
        this.flySpeed = flySpeed;
    }
}
