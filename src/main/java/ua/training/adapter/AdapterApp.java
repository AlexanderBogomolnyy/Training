package ua.training.adapter;

/**
 * <p> The Video interface adapter application class.
 * This class provides main executive method for application.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 20.12.2016.
 */
public class AdapterApp {

    public static void main(String[] args) {
        String signal = "SVGA: 0110 0110 1001 0110 1111";
        // Initializing SVGA output which provides analog signal
        SVGAOutput output = new SVGAOutput(signal);
        // Initializing DVI input which adopts digital signal
        DVIInput input = new DVIInput();
        // Reading analog signal through adapter
        input.readSignal(new VideoAdapter(output.createSignal()));
    }

}
