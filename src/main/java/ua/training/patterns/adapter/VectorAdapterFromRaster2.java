package ua.training.patterns.adapter;

/**
 * <p> The adapter class for raster graphics with vector graphics interface.
 * This class uses composition for implementation Adapter pattern idiom.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 23.11.2016.
 */
public class VectorAdapterFromRaster2 implements VectorGraphicsInterface{

    private RasterGraphics rasterGraphics = null; // new RasterGraphics();

    public VectorAdapterFromRaster2(RasterGraphics rasterGraphics) {
        this.rasterGraphics = rasterGraphics;
    }

    @Override
    public void drawLine() {
        rasterGraphics.drawRasterLine();
    }

    @Override
    public void drawSquare() {
        rasterGraphics.drawRasterSquare();
    }
}
