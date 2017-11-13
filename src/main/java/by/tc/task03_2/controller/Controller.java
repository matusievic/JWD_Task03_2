package by.tc.task03_2.controller;

import by.tc.task03_2.dao.DAOFactory;
import by.tc.task03_2.entity.Person;
import by.tc.task03_2.service.ServiceFactory;
import by.tc.task03_2.service.validation.Validator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class Controller extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Controller() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");

        if (!Validator.nameValidator(name, surname)) {
            req.setAttribute("incorrectDataMessage", "Please, provide a valid name or surname");
            req.getRequestDispatcher("/").forward(req, resp);
        }

        Person[] persons = null;
        try {
            persons = ServiceFactory.getInstance().getPersonService().find(name, surname);
        } catch (Exception e) {
            req.getRequestDispatcher("/500").forward(req, resp);
        }

        req.setAttribute("persons", persons);
        req.getRequestDispatcher("/result").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}