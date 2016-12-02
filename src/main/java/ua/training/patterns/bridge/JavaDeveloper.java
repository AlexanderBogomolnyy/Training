package ua.training.patterns.bridge;

/**
 * <p> The Java Developer interface.
 * This class implements Developer interface
 * This class represents Java developer.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 02.12.2016.
 */
public class JavaDeveloper implements Developer {
    @Override
    public void writeCode() {
        System.out.println("Java developer writes Java code...");
    }
}
