package by.tc.task03_2.entity;

import java.io.Serializable;

public class Person implements Serializable {
    private String name;
    private String surname;
    private String phone;
    private String email;

    public static long serialVersionUID = 1L;

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) { return true; }
        if (obj == null || getClass() != obj.getClass()) { return false; }

        Person person = (Person) obj;

        if (name != null ? !name.equals(person.name) : person.name != null) { return false; }
        if (surname != null ? !surname.equals(person.surname) : person.surname != null) { return false; }
        if (phone != null ? !phone.equals(person.phone) : person.phone != null) { return false; }
        if (email != null ? !email.equals(person.email) : person.email != null) { return false; }

        return true;
    }

    @Override
    public int hashCode() {
        double result = name != null ? name.hashCode() : 0;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return (int) result;
    }

    @Override
    public String toString() {
        return getClass().getName() + " [name=" + name + ", surname=" + surname + ", phone=" + phone + ",email=" + email;
    }
}
