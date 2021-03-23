package com.example.webfinal.comparator;

import com.example.webfinal.entity.Person;

import java.util.Comparator;

public enum PersonComparatorType {
    AGE((p1, p2) ->  p1.getAge() - p2.getAge());

    private final Comparator<Person> comparator;

    PersonComparatorType(Comparator<Person> comparator) {
        this.comparator = comparator;
    }

    public Comparator<Person> getComparator() {
        return comparator;
    }
}
