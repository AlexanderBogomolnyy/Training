package ua.training.patterns.singleton;

/**
 * <p> The Runner class for multithread test.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 02.12.2016.
 */
public class Runner implements Runnable {

    @Override
    public void run() {
//        SingletonSingle.getInstance();
//        SingletonMultiStatic.getInstance();
        SingletonMultiLazy.getInstance();
    }
}
