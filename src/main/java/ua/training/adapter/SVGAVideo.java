package ua.training.adapter;

/**
 * <p> The SVGAVideo class.
 * This class represents video stream with analog signal.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 20.12.2016.
 */
public class SVGAVideo implements SVGA {

    /**
     * Some kind of abstract signal
     */
    private String signal;

    public SVGAVideo(String signal) {
        this.signal = signal;
    }

    /**
     * This method returns analog signal
     *
     * @return - string with analog signal
     */
    @Override
    public String getAnalogSignal() {
        return signal;
    }
}
