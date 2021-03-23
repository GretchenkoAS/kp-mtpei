package com.example.webfinal.repository.impl;

import com.example.webfinal.entity.Person;
import com.example.webfinal.repository.Specification;

public class AgePersonSpecification implements Specification {
    private int from;
    private int to;

    public AgePersonSpecification(int from, int to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public boolean specify(Person person) {
        boolean result = person.getAge() >= from && person.getAge() <= to;
        return result;
    }
}
