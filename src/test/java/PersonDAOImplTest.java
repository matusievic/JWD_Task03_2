import by.tc.task03_2.dao.DAOFactory;
import by.tc.task03_2.dao.PersonDAO;
import by.tc.task03_2.entity.Person;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonDAOImplTest {
    private static final String URL = "jdbc:mysql://localhost:3306/persones";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    PersonDAO personDAO = DAOFactory.getInstance().getPersonDAO();

    @BeforeAll
    static void setUp() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO Persones VALUES" +
                    "(999, 'Mikola', 'Vasilieuski', '+375338888888', 'vasilieuski@mail.com')," +
                    "(1000, 'Maryja', 'Babko', '+375298888888', 'babko@tut.by')," +
                    "(2000, 'Mikola', 'Vasilieuski', '+375448888888', 'vasilieuski@tut.by');");
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
    }

    @Test
    void findOnePersonTest() {
        Person actual = null, expected = null;

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Persones WHERE NAME='Maryja' AND SURNAME='Babko'");
            while (resultSet.next()) {
                actual = new Person();
                actual.setName(resultSet.getString("NAME"));
                actual.setSurname(resultSet.getString("SURNAME"));
                actual.setPhone(resultSet.getString("PHONE"));
                actual.setEmail(resultSet.getString("EMAIL"));
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }

        try {
            expected = personDAO.find("Maryja", "Babko")[0];
        } catch (SQLException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        assertEquals(expected, actual);
    }

    @Test
    void findTwoPersonsTest() {
        Person[] actual = new Person[2], expected = null;

        actual[0] = new Person();
        actual[0].setName("Mikola");
        actual[0].setSurname("Vasilieuski");
        actual[0].setPhone("+375338888888");
        actual[0].setEmail("vasilieuski@mail.com");

        actual[1] = new Person();
        actual[1].setName("Mikola");
        actual[1].setSurname("Vasilieuski");
        actual[1].setPhone("+375448888888");
        actual[1].setEmail("vasilieuski@tut.by");

        try {
            expected = personDAO.find("Mikola", "Vasilieuski");
        } catch (SQLException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        assertArrayEquals(expected, actual);
    }

    @Test
    void findNoPersonsTest() {
        Person[] actual = new Person[0], expected = null;

        try {
            expected = personDAO.find("432432", "e23e23");
        } catch (SQLException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        assertArrayEquals(expected, actual);
    }

    @AfterAll
    static void tearDown() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM Persones" +
                    " WHERE NAME='Maryja' AND SURNAME='Babko' AND PHONE='+375298888888' AND EMAIL='babko@tut.by'");
            statement.executeUpdate("DELETE FROM Persones" +
                    " WHERE NAME='Mikola' AND SURNAME='Vasilieuski' AND PHONE='+375338888888' AND EMAIL='vasilieuski@mail.com'");
            statement.executeUpdate("DELETE FROM Persones" +
                    " WHERE NAME='Mikola' AND SURNAME='Vasilieuski' AND PHONE='+375448888888' AND EMAIL='vasilieuski@tut.by'");
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
    }
}