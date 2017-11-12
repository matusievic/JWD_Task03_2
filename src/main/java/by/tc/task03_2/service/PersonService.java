package by.tc.task03_2.service;

import by.tc.task03_2.entity.Person;

public interface PersonService {
    Person[] find(String name, String surname);
}
