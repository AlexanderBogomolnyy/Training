package ua.training.patterns.adapter;

/**
 * <p> The adapter class for raster graphics with vector graphics interface.
 * This class uses inheritance for implementation Adapter pattern idiom.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 23.11.2016.
 */
public class VectorAdapterFromRaster extends RasterGraphics implements VectorGraphicsInterface{

    @Override
    public void drawLine() {
        drawRasterLine();
    }

    @Override
    public void drawSquare() {
        drawRasterSquare();
    }
}
