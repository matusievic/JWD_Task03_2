package by.tc.task03_2.service.impl;

import by.tc.task03_2.dao.DAOFactory;
import by.tc.task03_2.dao.PersonDAO;
import by.tc.task03_2.entity.Person;
import by.tc.task03_2.service.PersonService;

public class PersonServiceImpl  implements PersonService {
    @Override
    public Person[] find(String name, String surname) {
        if (name == null || name.isEmpty()) { return null; }
        if (surname == null || surname.isEmpty()) { return null; }

        PersonDAO personDAO = DAOFactory.getInstance().getPersonDAO();
        Person[] persones = personDAO.find(name, surname);

        return persones;
    }
}
