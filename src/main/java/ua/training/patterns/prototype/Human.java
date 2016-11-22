package ua.training.patterns.prototype;

/**
 * <p> This class represents Human and implements Copyable interface.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 22.11.2016.
 */
class Human implements Copyable {
    int age;
    String name;

    public Human(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public Object copy() {
        Human copy = new Human(age, name);
        return copy;
    }

    @Override
    public String toString() {
        return "Human{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Human)) return false;
        Human human = (Human) o;
        if (age != human.age) return false;
        if (name != null ? !name.equals(human.name) : human.name != null) return false;

        return true;
    }
}
