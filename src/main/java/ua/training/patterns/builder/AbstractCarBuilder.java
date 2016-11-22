package ua.training.patterns.builder;

/**
 * <p> Abstract Car Builder class.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 22.11.2016.
 */
abstract class AbstractCarBuilder {
    Car car;

    void createCar() {
        car = new Car();
    }

    // abstract methods for initializing car parameters
    abstract void buildMake();
    abstract void buildTransmission();
    abstract void buildMaxSpeed();

    Car getCar() {
        return car;
    }
}
