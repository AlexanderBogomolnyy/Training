package ua.training.patterns.proxy;

/**
 * <p> The Proxy Image class.
 * This proxy provides lazy loading of image, only when user wants to display image
 * and not when he only chose it.
 * This class represents Service proxy from Proxy pattern idiom.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 02.12.2016.
 */
class ProxyImage implements Image {

    private String file;
    private RealImage image;

    public ProxyImage(String file) {
        this.file = file;
    }

    @Override
    public void display() {
        if (image == null) {
            image = new RealImage(file);
        }
        image.display();
    }
}
