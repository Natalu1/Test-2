package com.company.ex3;

import com.company.ex2.Person;
import io.vavr.collection.HashSet;
import io.vavr.collection.List;
import io.vavr.collection.Set;
import io.vavr.control.Option;
import util.Utils;

import java.util.Collection;
import java.util.Comparator;

public class Excercise3 {


    public static void main(String[] args) {
        ex_3_1();
        System.out.println(ex_3_2());
        System.out.println(ex_3_3());
        System.out.println(ex_3_4());
        System.out.println(ex_3_5());
        Utils<AnimalId> utils = new Utils<>();
        utils.printCollectionInColumn(ex_3_5());
    }

    //Create one instance of Bird and two instances of Cat

    //run method giveVoice() on each created object
    private static void ex_3_1() {
        Bird bird = new Bird("bird",
                HashSet.of(new Person("Adam", "Nowak", 25)), 5);
        Cat cat = new Cat("Cat",
                HashSet.of(new Person("Adam", "Nowak", 25)), 3);
        Cat cat2 = new Cat("Cat",
                HashSet.of(new Person("Adam", "Nowak", 25)), 3);
        List<Animal> animals = List.of(bird, cat, cat2);
        animals.forEach(Animal::giveVoice);
    }

    //Create one instance of Bird and two instances of Cat together with owners
    //Write method returning Set of Person - it should be the oldest owner of the animal
    private static Set<Person> ex_3_2() {
        Bird bird = new Bird("bird",
                HashSet.of(new Person("Adam", "Nowak", 25)), 5);
        Cat cat = new Cat("Cat",
                HashSet.of(new Person("Ewa", "Nowak", 25)), 3);
        Cat cat2 = new Cat("Cat",
                HashSet.of(new Person("Alla", "Nowak", 35),
                        new Person("Max", "Kowal", 30)), 3);
        List<Animal> animals = List.of(bird, cat, cat2);
        return animals.map(animal -> animal.getOwners())
                .map(people -> getOldOfPerson(people)).toSet();
    }

    private static Person getOldOfPerson(Set<Person> people) {
        return people.maxBy(person -> person.getAge())
                .get();
//                people.maxBy(Comparator.comparingInt(Person::getAge)).get();
    }

    //Create one instance of Bird and two instances of Cat together with owners
    //One of animals should be homeless (without owners)
    //Write method returning List of string (owner names) - if Animal doesn't have the owner it should return "UNKNOWN" instead of owner name
    private static List<String> ex_3_3() {
        Bird bird = new Bird("bird",
                HashSet.of(new Person("Adam", "Nowak", 25)), 5);
        Cat cat = new Cat("Cat",
                HashSet.of(), 5);
        Cat cat2 = new Cat("Cat",
                HashSet.of(new Person("Alla", "Nowak", 35),
                        new Person("Max", "Kowal", 30)), 3);
        List<Animal> animals = List.of(bird, cat, cat2);
        return animals.map(animal -> animal.getOwners())
                .map(people -> getOldOfPerson1(people))
                .map(person -> person.isEmpty() ? "UNKNOWN" : person.get().fullName());

    }

    private static Option<Person> getOldOfPerson1(Set<Person> people) {
        return people.maxBy(person -> person.getAge());

//                people.maxBy(Comparator.comparingInt(Person::getAge));
    }

    //Create one instance of Bird and two instances of Cat together with owners
    //One of animals should be homeless (without owners)
    //Write method returning Set of objects - AnimalId - it should contain Animal name and the oldest person fullName

    private static Set<AnimalId> ex_3_4() {
        Bird bird = new Bird("bird",
                HashSet.of(new Person("Adam", "Nowak", 25)), 5);
        Cat cat = new Cat("Cat",
                HashSet.of(), 5);
        Cat cat2 = new Cat("Cat",
                HashSet.of(new Person("Alla", "Nowak", 35),
                        new Person("Max", "Kowal", 30)), 3);
        List<Animal> animals = List.of(bird, cat, cat2);

        return animals.map(animal -> new AnimalId(animal.getName(),
                getOldOfPersonFullName(animal.getOwners()))).toSet();
    }

    private static String getOldOfPersonFullName(Set<Person> people) {
        Option<Person> oldOfPerson1 = getOldOfPerson1(people);
        return oldOfPerson1.isEmpty() ? "UNKNOWN" : oldOfPerson1.get().fullName();
    }

    //DLA CHĘTNYCH!!!
    //Create one instance of Bird and two instances of Cat together with owners
    //One of animals should be homeless (without owners)
    //Write method returning List of objects - AnimalId - it should contain Animal name and the oldest person fullName
    //List should be sorted by cat's tail length or bird's flySpeed.
    //Fly speed should be pointed twice, so for list of animals with their attribute:
    // Cat(3)
    // Cat(5)
    // Cat(7)
    // Cat(13)
    // Bird(1)
    // Bird(2)
    // Bird(4)
    // Bird(5)


    // It should return list of animalId with order:
    // Bird(1)
    // Cat(3)
    // Bird(2)
    // Cat(5)
    // Cat(7)
    // etc...
    private static List<AnimalId> ex_3_5() {
        Bird bird1 = new Bird("bird1",
                HashSet.of(new Person("Adam", "Nowak", 25)), 1);
        Bird bird2 = new Bird("bird2",
                HashSet.of(new Person("Ola", "Nowak", 25)), 2);
        Bird bird4 = new Bird("bird4",
                HashSet.of(new Person("Ewa", "Nowak", 25)), 4);
        Bird bird5 = new Bird("bird5",
                HashSet.of(new Person("Karl", "Nowak", 25)), 5);
        Cat cat3 = new Cat("Cat3",
                HashSet.of(), 3);
        Cat cat5 = new Cat("Cat5",
                HashSet.of(new Person("Alla", "Nowak", 35),
                        new Person("Max", "Kowal", 30)), 5);
        Cat cat7 = new Cat("Cat7",
                HashSet.of(new Person("Max", "Nowak", 35),
                        new Person("Jana", "Kowal", 30)), 7);
        Cat cat13 = new Cat("Cat13",
                HashSet.of(new Person("Nik", "Nowak", 35),
                        new Person("Alla", "Kowal", 30)), 13);

        List<Animal> animals = List.of(bird1, bird2, bird4, bird5, cat3, cat5, cat7, cat13);

       return animals.sorted(Comparator.comparingInt(Animal::getSortAttribute))
                .map(animal -> new AnimalId(animal.getName(),
                        getOldOfPersonFullName(animal.getOwners())));
    }
}
