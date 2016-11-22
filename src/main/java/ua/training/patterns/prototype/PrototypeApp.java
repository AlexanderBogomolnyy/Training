package ua.training.patterns.prototype;

/**
 * <p> The Prototype pattern sample.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 22.11.2016.
 */
public class PrototypeApp {

    public static void main(String[] args) {
        Human original = new Human(18, "Vasya");
        System.out.println(original);
        Human copy = (Human) original.copy();
        System.out.println(copy);
        System.out.println("original = copy ? " + original.equals(copy));

        HumanFactory factory = new HumanFactory(copy);
        Human h1 = factory.makeCopy();
        System.out.println(h1);
        System.out.println("copy = h1 ? " + copy.equals(h1));

        Human lady = new Human(30, " Valerya");
        factory.setPrototype(lady);
        System.out.println(lady);
        Human h2 = factory.makeCopy();
        System.out.println(h2);
        System.out.println("lady = h2 ? " + lady.equals(h2));
    }

}
