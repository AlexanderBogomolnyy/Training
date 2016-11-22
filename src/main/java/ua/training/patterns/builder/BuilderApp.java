package ua.training.patterns.builder;

/**
 * <p> The Builder pattern sample.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 22.11.2016.
 */
public class BuilderApp {
    public static void main(String[] args) {
        Car car = new CarBuilder()
                .buildMake("Mercedes")
                .buildTransmission(Transmission.AUTO)
                .buildMaxSpeed(280)
                .build();
        System.out.println(car);
        System.out.println(new CarBuilder().build());

        // build car utilizing Director
        Director director = new Director();
        director.setBuilder(new SubaruBuilder());
        System.out.println(director.buildCar());
        director.setBuilder(new FordMondeoBuilder());
        System.out.println(director.buildCar());
        director.setBuilder(new FerrariBuilder());
        System.out.println(director.buildCar());
    }
}
