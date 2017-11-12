package by.tc.task03_2.dao;

import by.tc.task03_2.entity.Person;

public interface PersonDAO {
    Person[] find(String name, String surname);
}
