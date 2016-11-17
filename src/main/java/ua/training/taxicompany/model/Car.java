package ua.training.taxicompany.model;

/**
 * <p> The Car model class.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 14.11.2016.
 */
public class Car {

    /**
     * Car model
     */
    private String model;

    /**
     * Car type
     */
    private Type type;

    /**
     * License plate number of the car
     */
    private String numberPlate;

    /**
     * Prime cost of car
     */
    private int primeCost;

    /**
     * Car fuel rate
     */
    private double fuelRate;

    /**
     * Maximum car speed
     */
    private int fullSpeed;

    public Car() {
    }

    public Car(String model, Type type, String numberPlate, int primeCost, double fuelRate, int fullSpeed) {
        this.model = model;
        this.type = type;
        this.numberPlate = numberPlate;
        this.primeCost = primeCost;
        this.fuelRate = fuelRate;
        this.fullSpeed = fullSpeed;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public int getPrimeCost() {
        return primeCost;
    }

    public void setPrimeCost(int primeCost) {
        this.primeCost = primeCost;
    }

    public double getFuelRate() {
        return fuelRate;
    }

    public void setFuelRate(double fuelRate) {
        this.fuelRate = fuelRate;
    }

    public int getFullSpeed() {
        return fullSpeed;
    }

    public void setFullSpeed(int fullSpeed) {
        this.fullSpeed = fullSpeed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;

        Car car = (Car) o;

        if (Double.compare(car.fuelRate, fuelRate) != 0) return false;
        if (fullSpeed != car.fullSpeed) return false;
        if (primeCost != car.primeCost) return false;
        if (model != null ? !model.equals(car.model) : car.model != null) return false;
        if (!numberPlate.equals(car.numberPlate)) return false;
        if (type != car.type) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = model != null ? model.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + numberPlate.hashCode();
        result = 31 * result + primeCost;
        temp = Double.doubleToLongBits(fuelRate);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + fullSpeed;
        return result;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", type=" + type +
                ", numberPlate='" + numberPlate + '\'' +
                ", primeCost=" + primeCost +
                ", fuelRate=" + fuelRate +
                ", fullSpeed=" + fullSpeed +
                '}';
    }

    /**
     * Enum of car types
     */
    public enum Type {
        SEDAN, WAGON, MINIVAN,  HATCHBACK, CABRIOLET, SUV
    }
}
