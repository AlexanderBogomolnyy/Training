package ua.training.patterns.builder;

/**
 * <p> Ford Mondeo Builder class (builder for real car).
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 22.11.2016.
 */
class FordMondeoBuilder extends AbstractCarBuilder {

    @Override
    void buildMake() {
        car.setMake("Ford Mondeo");
    }

    @Override
    void buildTransmission() {
        car.setTransmission(Transmission.AUTO);
    }

    @Override
    void buildMaxSpeed() {
        car.setMaxSpeed(260);
    }
}
