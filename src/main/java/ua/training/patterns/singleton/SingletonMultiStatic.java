package ua.training.patterns.singleton;

/**
 * <p> The Singleton class.
 * This is multi thread implementation of Singleton utilizing static initialization
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 02.12.2016.
 */
public class SingletonMultiStatic {
    public static int counter = 0;

    private static volatile SingletonMultiStatic instance = new SingletonMultiStatic();

    private SingletonMultiStatic() {
        counter++;
    }

    public static SingletonMultiStatic getInstance() {
        return instance;
    }
}
