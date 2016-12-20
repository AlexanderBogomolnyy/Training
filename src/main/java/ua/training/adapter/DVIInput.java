package ua.training.adapter;

/**
 * <p> The DVI input class.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 20.12.2016.
 */
public class DVIInput {

    /**
     * This method reads digital signal through DVI interface
     *
     * @param signal - DVI source of signal
     */
    void readSignal(DVI signal) {
        System.out.println(signal.getDigitalSignal());
    }
}
