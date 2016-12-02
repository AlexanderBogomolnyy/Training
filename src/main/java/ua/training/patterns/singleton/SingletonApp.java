package ua.training.patterns.singleton;

/**
 * <p> The Singleton pattern sample.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 02.12.2016.
 */
public class SingletonApp {
    public static void main(String[] args) throws InterruptedException {

        final int SIZE = 1000;
//        System.out.println(SingletonSingle.counter);
//        SingletonSingle[] singletons = new SingletonSingle[SIZE];
//        for( int i = 0; i < SIZE; i++) {
//            singletons[i] = SingletonSingle.getInstance();
//        }
//        System.out.println(SingletonSingle.counter);


//        System.out.println(Singleton.counter);
//        System.out.println(SingletonSingle.counter);
        System.out.println(SingletonMultiLazy.counter);

        Thread[] threads = new Thread[SIZE];
        for( int i = 0; i < SIZE; i++) {
            threads[i] = new Thread(new Runner());
            threads[i].start();
        }
        for( int i = 0; i < SIZE; i++) {
            threads[i].join();
        }
//        System.out.println(Singleton.counter);
//        System.out.println(SingletonSingle.counter);
        System.out.println(SingletonMultiLazy.counter);
    }
}
