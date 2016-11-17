package ua.training.taxicompany.model;

/**
 * <p> The taxi model class.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 14.11.2016.
 */
public class Taxi extends Car {

    /**
     * Taxi car regular number in company
     */
    private String regularNumber;

    public Taxi(String regularNumber) {
        this.regularNumber = regularNumber;
    }

    public Taxi(String model, Type type, String numberPlate, int primeCost, double fuelRate, int fullSpeed, String regularNumber) {
        super(model, type, numberPlate, primeCost, fuelRate, fullSpeed);
        this.regularNumber = regularNumber;
    }

    public String getRegularNumber() {
        return regularNumber;
    }

    public void setRegularNumber(String regularNumber) {
        this.regularNumber = regularNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Taxi)) return false;
        if (!super.equals(o)) return false;

        Taxi taxi = (Taxi) o;

        if (!regularNumber.equals(taxi.regularNumber)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + regularNumber.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Taxi{" +
                super.toString() + ", " +
                "regularNumber='" + regularNumber + '\'' +
                '}';
    }
}


