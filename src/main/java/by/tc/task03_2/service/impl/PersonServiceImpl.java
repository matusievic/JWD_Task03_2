package by.tc.task03_2.service.impl;

import by.tc.task03_2.dao.DAOFactory;
import by.tc.task03_2.dao.PersonDAO;
import by.tc.task03_2.entity.Person;
import by.tc.task03_2.service.PersonService;
import by.tc.task03_2.service.validation.Validator;

import java.sql.SQLException;

public class PersonServiceImpl  implements PersonService {
    @Override
    public Person[] find(String name, String surname) throws SQLException, IllegalAccessException, InstantiationException, ClassNotFoundException {
        PersonDAO personDAO = DAOFactory.getInstance().getPersonDAO();
        Person[] persons = personDAO.find(name, surname);
        return persons;
    }
}
