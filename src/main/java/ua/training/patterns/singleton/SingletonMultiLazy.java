package ua.training.patterns.singleton;

/**
 * <p> The Singleton class.
 * This is multi thread implementation of Singleton utilizing
 * lazy initialization in synchronized block
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 02.12.2016.
 */
public class SingletonMultiLazy {

    public static int counter = 0;

    private static SingletonMultiLazy instance;

    private SingletonMultiLazy() {
        counter++;
    }

//    public static synchronized SingletonMultiLazy getInstance() {
//        if (instance == null) {
//            instance = new SingletonMultiLazy();
//        }
//        return instance;
//    }

    public static SingletonMultiLazy getInstance() {
        // double checked locking
        if (instance == null) {
            synchronized (SingletonMultiLazy.class) {
                if (instance == null) {
                    instance = new SingletonMultiLazy();
                }
            }
        }
        return instance;
    }

}
