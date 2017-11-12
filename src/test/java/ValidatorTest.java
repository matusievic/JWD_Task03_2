import by.tc.task03_2.service.validation.Validator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {
    @Test
    void nullNameValidatorTest() {
        assertFalse(Validator.nameValidator(null, "Janouski"));
    }

    @Test
    void nullSurnameValidatorTest() {
        assertFalse(Validator.nameValidator("Jan", null));
    }
    @Test
    void incorrectNameValidatorTest() {
        assertFalse(Validator.nameValidator("jan", "Janouski"));
    }
    @Test
    void incorrectSurnameValidatorTest() {
        assertFalse(Validator.nameValidator("Jan", "34janouski"));
    }
    @Test
    void correctValidatorTest() {
        assertTrue(Validator.nameValidator("Jan", "Janouski"));
    }

}