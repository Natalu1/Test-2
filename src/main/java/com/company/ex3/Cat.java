package com.company.ex3;

import com.company.ex2.Person;
import io.vavr.collection.Set;




public class Cat extends Animal {

    private int tailLength;

    public Cat(String name, Set<Person> owners) {
        super(name, owners);
    }


    public Cat(String name, Set<Person> owners, int tailLength) {
        super(name, owners);
        this.tailLength = tailLength;
    }

    @Override
    void giveVoice() {
        System.out.println("Miau");
    }

    @Override
    int getSortAttribute() {
        return tailLength;
    }
}
