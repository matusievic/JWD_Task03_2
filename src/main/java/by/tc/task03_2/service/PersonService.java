package by.tc.task03_2.service;

import by.tc.task03_2.entity.Person;

import java.sql.SQLException;

public interface PersonService {
    Person[] find(String name, String surname) throws SQLException, IllegalAccessException, InstantiationException, ClassNotFoundException;
}
