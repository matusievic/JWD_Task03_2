package by.tc.task03_2.dao;

import by.tc.task03_2.entity.Person;

import java.sql.SQLException;

public interface PersonDAO {
    Person[] find(String name, String surname) throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException;
}
