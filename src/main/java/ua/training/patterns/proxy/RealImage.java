package ua.training.patterns.proxy;

/**
 * <p> The Real Image class.
 * This class represents Service implementation from Proxy pattern idiom.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 02.12.2016.
 */
class RealImage implements Image {

    private String file;

    public RealImage(String file) {
        this.file = file;
        load();
    }

    void load() {
        System.out.println(file + " loading...");
    }

    @Override
    public void display() {
        System.out.println("View: " + file);
    }
}
