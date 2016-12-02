package ua.training.patterns.proxy;

/**
 * <p> The Proxy pattern sample.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 02.12.2016.
 */
public class ProxyApp {
    public static void main(String[] args) {
//        Image image = new RealImage("/home/images/my.jpg");
        Image image = new ProxyImage("/home/images/my.jpg");
        image.display();
    }
}
