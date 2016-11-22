package ua.training.patterns.builder;

/**
 * <p>Subaru Builder class (builder for real car).
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 22.11.2016.
 */
class SubaruBuilder extends AbstractCarBuilder {

    @Override
    void buildMake() {
        car.setMake("Subaru");
    }

    @Override
    void buildTransmission() {
        car.setTransmission(Transmission.MANUAL);
    }

    @Override
    void buildMaxSpeed() {
        car.setMaxSpeed(320);
    }
}
