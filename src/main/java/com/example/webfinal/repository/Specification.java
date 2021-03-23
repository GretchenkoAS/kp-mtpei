package com.example.webfinal.repository;

import com.example.webfinal.entity.Person;

public interface Specification {
    boolean specify(Person person);
}
