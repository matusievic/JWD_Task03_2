package by.tc.task03_2.dao;

import by.tc.task03_2.dao.impl.PersonDAOImpl;

public final class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();
    private final PersonDAO personDAO = new PersonDAOImpl();

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        return instance;
    }

    public PersonDAO getPersonDAO() {
        return personDAO;
    }
}
