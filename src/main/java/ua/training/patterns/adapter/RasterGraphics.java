package ua.training.patterns.adapter;

/**
 * <p> The class for raster graphics.
 * This is Adaptee class for Adapter
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 23.11.2016.
 */
class RasterGraphics {

    /**
     * This method imitates drawing of raster line
     */
    void drawRasterLine() {
        System.out.println("Draw line");
    }

    /**
     * This method imitates drawing of raster square
     */
    void drawRasterSquare() {
        System.out.println("Draw square");
    }
}
