package ua.training.patterns.singleton;

/**
 * <p> The Singleton class.
 * This is single thread implementation of Singleton
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 02.12.2016.
 */
class SingletonSingle {

    public static int counter = 0;

    private static SingletonSingle instance;

    private SingletonSingle() {
        counter++;
    }

    public static SingletonSingle getInstance() {
        if (instance == null) {
            instance = new SingletonSingle();
        }
        return instance;
    }
}
