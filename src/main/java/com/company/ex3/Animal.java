package com.company.ex3;

import com.company.ex2.Person;

import java.util.Set;

public abstract class Animal {
    private String name;
    private Set<Person> owners;
    abstract void giveVoice();

    public Animal(String name, Set<Person> owners) {
        this.name = name;
        this.owners = owners;
    }
}
