package ua.training.block04.model;

/**
 * <p> This class represents address.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 06.11.2016.
 */
public class Address {

    /**
     * The zip code
     */
    private String zip;

    /**
     * The city name
     */
    private String city;

    /**
     * The street name
     */
    private String street;

    /**
     * The building number
     */
    private String building;

    /**
     * The apartment number
     */
    private int apartment;

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public int getApartment() {
        return apartment;
    }

    public void setApartment(int apartment) {
        this.apartment = apartment;
    }

    @Override
    public String toString() {
        return "Address{" +
                "zip=" + zip +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", building='" + building + '\'' +
                ", apartment=" + apartment +
                '}';
    }

}
