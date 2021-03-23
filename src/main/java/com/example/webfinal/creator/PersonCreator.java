package com.example.webfinal.creator;

import com.example.webfinal.entity.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonCreator {
    public List<Person> createPersons() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Andry", 20));
        persons.add(new Person("Ola", 25));
        persons.add(new Person("Alex", 20));
        persons.add(new Person("Yana", 17));
        persons.add(new Person("Anastasia", 12));
        persons.add(new Person("Liza", 18));
        persons.add(new Person("Pasha", 30));
        persons.add(new Person("Stepan", 42));
        persons.add(new Person("Alisa", 20));
        persons.add(new Person("Vlad", 33));
        return persons;
    }
}
