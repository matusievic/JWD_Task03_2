package by.tc.task03_2.dao.impl;

import by.tc.task03_2.dao.PersonDAO;
import by.tc.task03_2.entity.Person;

public class PersonDAOImpl implements PersonDAO {
    @Override
    public Person[] find(String name, String surname) {
        return new Person[0];
    }
}
