package com.example.webfinal.repository;

import com.example.webfinal.entity.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PersonRepository {
    private List<Person> persons;

    public PersonRepository() {
        persons  = new ArrayList<>();
    }

    public List<Person> getPersons() {
        return Collections.unmodifiableList(persons);
    }

    public void addPerson(Person person) {
        persons.add(person);
    }

    public void removePerson(Person person) {
        persons.remove(person);
    }

    public Person get(int index) {
        return persons.get(index);
    }

    public Person set(int index, Person element) {
        return persons.set(index, element);
    }

    public List<Person> query(Specification specification) {
        List<Person> list = persons.stream().filter(specification::specify).collect(Collectors.toList());
        return list;
    }

    public List<Person> sort(Comparator<Person> type) {
        List<Person> sortedList = persons.stream().sorted(type).collect(Collectors.toList());
        return sortedList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("PersonRepository\n");
        sb.append(persons);
        return sb.toString();
    }
}
