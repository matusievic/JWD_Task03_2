package by.tc.task03_2.dao.impl;

import by.tc.task03_2.dao.PersonDAO;
import by.tc.task03_2.entity.Person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonDAOImpl implements PersonDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/persones";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public Person[] find(String name, String surname) throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        PreparedStatement statement = connection.prepareStatement("SELECT *FROM Persones WHERE NAME=? AND SURNAME=?");
        statement.setString(1, name);
        statement.setString(2, surname);
        ResultSet resultSet = statement.executeQuery();
        statement.clearParameters();

        List<Person> personList = new ArrayList<>();

        while (resultSet.next()) {
            Person person = new Person();

            person.setName(resultSet.getString("NAME"));
            person.setSurname(resultSet.getString("SURNAME"));
            person.setPhone(resultSet.getString("PHONE"));
            person.setEmail(resultSet.getString("EMAIL"));

            personList.add(person);
        }

        Person[] result = new Person[personList.size()];
        return personList.toArray(result);
    }
}
