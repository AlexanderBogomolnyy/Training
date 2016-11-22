package ua.training.patterns.builder;

/**
 * <p> Car Builder class.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 22.11.2016.
 */
public class CarBuilder {

    String make = "Default";
    Transmission transmission = Transmission.MANUAL;
    int maxSpeed = 120;

    CarBuilder buildMake(String make) {
        this.make = make;
        return this;
    }

    CarBuilder buildTransmission(Transmission transmission) {
        this.transmission = transmission;
        return this;
    }

    CarBuilder buildMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
        return this;
    }

    /**
     * This method builds car utilizing class fields.
     * @return - car with set parameters.
     */
    Car build() {
        Car car = new Car();
        car.setMake(make);
        car.setTransmission(transmission);
        car.setMaxSpeed(maxSpeed);
        return car;
    }

}
