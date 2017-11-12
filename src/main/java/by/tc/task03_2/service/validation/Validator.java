package by.tc.task03_2.service.validation;

public final class Validator {
    private static final String NAME_REGEX = "[A-Z][a-z]+";
    public static boolean nameValidator(String name, String surname) {
        if (name == null || name.isEmpty() || !name.matches(NAME_REGEX)) { return false; }
        if (surname == null || surname.isEmpty() || !surname.matches(NAME_REGEX)) { return false; }
        return true;
    }
}
