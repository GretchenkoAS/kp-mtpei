package com.example.webfinal.command.impl;

import com.example.webfinal.command.Command;
import com.example.webfinal.command.PagePath;
import com.example.webfinal.creator.PersonCreator;
import com.example.webfinal.entity.Person;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ShowPersonsCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        String page = PagePath.PERSONS;
        PersonCreator creator = new PersonCreator();
        List<Person> persons = creator.createPersons();
        request.setAttribute("persons", persons);
        return page;
    }
}
