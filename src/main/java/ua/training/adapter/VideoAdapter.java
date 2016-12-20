package ua.training.adapter;

/**
 * <p> The adapter class for converting interface from SVGA to DVI.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 20.12.2016.
 */
public class VideoAdapter implements DVI {

    /**
     * SVGA interface which provides analog signal
     */
    private SVGA svga;

    public VideoAdapter(SVGA svga) {
        this.svga = svga;
    }

    /**
     * This method returns digital signal
     *
     * @return - string with digital signal
     */
    @Override
    public String getDigitalSignal() {
        return "DVI: (\"" + svga.getAnalogSignal() + "\")";
    }

}
