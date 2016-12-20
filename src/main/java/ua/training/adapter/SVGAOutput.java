package ua.training.adapter;

/**
 * <p> The SVGA output class.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 20.12.2016.
 */
public class SVGAOutput {

    /**
     * Some inner signal
     */
    private String signal;

    public SVGAOutput(String signal) {
        this.signal = signal;
    }

    /**
     * This method creates SVGA Video signal from class inner signal
     *
     * @return - new SVGA video signal
     */
    public SVGA createSignal() {
        return new SVGAVideo(signal);
    }
}
