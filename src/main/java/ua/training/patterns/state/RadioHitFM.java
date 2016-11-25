package ua.training.patterns.state;

/**
 * <p> The class imitates Radio HitFM station.
 * This class implements Station interface.
 * This is a Concrete State class from State pattern idiom.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 25.11.2016.
 */
class RadioHitFM implements Station {
    @Override
    public void play() {
        System.out.println("HitFM.... The greatest and modern hits!...");
    }
}