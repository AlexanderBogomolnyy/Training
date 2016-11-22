package ua.training.patterns.builder;

/**
 * <p> Ferrari Builder class (builder for real car).
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 22.11.2016.
 */
public class FerrariBuilder extends AbstractCarBuilder {

    @Override
    void buildMake() {
        car.setMake("Ferrari LaFerrari");
    }

    @Override
    void buildTransmission() {
        car.setTransmission(Transmission.AUTO);
    }

    @Override
    void buildMaxSpeed() {
        car.setMaxSpeed(350);
    }
}
