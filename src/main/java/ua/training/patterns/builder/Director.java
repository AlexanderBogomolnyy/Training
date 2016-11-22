package ua.training.patterns.builder;

/**
 * <p> Director class.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 22.11.2016.
 */
public class Director {

    AbstractCarBuilder builder;

    /**
     * This method sets builder.
     *
     * @param builder - some kind of builder (extends AbstractCarBuilder)
     */
    void setBuilder(AbstractCarBuilder builder) {
        this.builder = builder;
    }

    /**
     * This method returns real car object.
     * The car is constructed utilizing CarBuilder methods.
     * The car parameters is set in specific order defined by builder.
     *
     * @return - new car
     */
    Car buildCar() {
        builder.createCar();
        builder.buildMake();
        builder.buildTransmission();
        builder.buildMaxSpeed();
        Car car = builder.getCar();
        return car;
    }
}
