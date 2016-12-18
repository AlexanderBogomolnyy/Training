package ua.training.company;

import java.util.Date;

/**
 * <p> The Personal data class.
 * This class contains employee personal data like: name, surname and birthday
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 16.12.2016.
 */
public class PersonalData {

    private String name;
    private String surname;
    private Date birthday;

    public PersonalData(String name, String surname, Date birthday) {
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonalData)) return false;

        PersonalData that = (PersonalData) o;

        if (!birthday.equals(that.birthday)) return false;
        if (!name.equals(that.name)) return false;
        if (!surname.equals(that.surname)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + surname.hashCode();
        result = 31 * result + birthday.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "PersonalData{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
