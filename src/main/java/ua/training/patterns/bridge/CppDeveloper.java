package ua.training.patterns.bridge;

/**
 * <p> The C++ Developer interface.
 * This class implements Developer interface
 * This class represents C++ developer.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 02.12.2016.
 */
public class CppDeveloper implements Developer {
    @Override
    public void writeCode() {
        System.out.println("C++ developer writes C++ code...");
    }
}
