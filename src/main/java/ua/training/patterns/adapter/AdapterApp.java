package ua.training.patterns.adapter;

/**
 * <p> The Adapter pattern sample.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 23.11.2016.
 */
public class AdapterApp {

    public static void main(String[] args) {
        // 1st way through inheritance
        VectorGraphicsInterface graphics1 = new VectorAdapterFromRaster();
        graphics1.drawLine();
        graphics1.drawSquare();
        //2nd way through composition
        VectorGraphicsInterface graphics2 = new VectorAdapterFromRaster2(new RasterGraphics());
        graphics2.drawLine();
        graphics2.drawSquare();
    }

}
