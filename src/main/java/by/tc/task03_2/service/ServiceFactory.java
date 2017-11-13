package by.tc.task03_2.service;

import by.tc.task03_2.service.impl.PersonServiceImpl;

public final class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();
    private final PersonService personService = new PersonServiceImpl();

    private ServiceFactory() {

    }

    public static ServiceFactory getInstance() {
        return instance;
    }

    public PersonService getPersonService() {
        return personService;
    }
}
