package ua.training.patterns.state;

/**
 * <p> The class imitates Radio Rocks station.
 * This class implements Station interface.
 * This is a Concrete State class from State pattern idiom.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 25.11.2016.
 */
class RadioRoks implements Station{
    @Override
    public void play() {
        System.out.println("Radio Roks.... Rock! Only the Rock!...");
    }
}
