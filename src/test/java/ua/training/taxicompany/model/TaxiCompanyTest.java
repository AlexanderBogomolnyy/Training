package ua.training.taxicompany.model;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * <p> The Taxi Company model test class.
 * It contains tests for public methods of TaxiCompany.class
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 14.11.2016.
 */
public class TaxiCompanyTest {

    private ArrayList<Taxi> taxiInRange;
    private ArrayList<Taxi> sortedListOfTaxi;
    private ArrayList<Taxi> taxis = new ArrayList<Taxi>() {{
        add(new Taxi("RENAULT", Car.Type.SEDAN, "AA9999AA", 150000, 5.5, 165, "CAR-1"));
        add(new Taxi("SKODA", Car.Type.SEDAN, "AA3333II", 125000, 7.8, 185, "CAR-2"));
        add(new Taxi("FORD", Car.Type.HATCHBACK, "AI4356II", 165000, 6.5, 173, "CAR-3"));
        add(new Taxi("MITSUBISHI", Car.Type.SEDAN, "AP6316EE", 135000, 7.5, 178, "CAR-4"));
        add(new Taxi("TOYOTA", Car.Type.WAGON, "AI3456CO", 205000, 9.2, 192, "CAR-5"));
        add(new Taxi("BMW", Car.Type.SUV, "AB0777", 310000, 8.9, 221, "CAR-6"));
    }};

    private int totalCost;

    private Taxi taxi;
    private TaxiCompany company;
    private TaxiCompany companyWithoutCar;
    private TaxiCompany companyOneCar;

    /**
     * Initializing of test parameters
     *
     * @throws Exception - exception in test
     */
    @Before
    public void setUp() throws Exception {
        taxi = new Taxi("MITSUBISHI", Car.Type.SEDAN, "AP6316EE", 135000, 7.5, 178, "CAR-4");
        company = new TaxiCompany("Taxi Rank", taxis);
        companyWithoutCar = new TaxiCompany("Taxi Rank");
        companyOneCar = new TaxiCompany("Taxi Rank", new LinkedList<Taxi>() {{
            add(taxi);
        }});
        totalCost = 1090000 ;
        taxiInRange = new ArrayList<>();
        taxiInRange.add(taxis.get(1));
        taxiInRange.add(taxis.get(2));
        taxiInRange.add(taxis.get(3));
        sortedListOfTaxi = new ArrayList<>();
        sortedListOfTaxi.add(taxis.get(0));
        sortedListOfTaxi.add(taxis.get(2));
        sortedListOfTaxi.add(taxis.get(3));
        sortedListOfTaxi.add(taxis.get(1));
        sortedListOfTaxi.add(taxis.get(5));
        sortedListOfTaxi.add(taxis.get(4));
    }

    /**
     * Checking of {@link TaxiCompany#totalCarsCost()} method correct performing.
     *
     * @throws Exception - exception in test
     */
    @Test
    public void testTotalCarsCost() throws Exception {
        assertEquals(totalCost, company.totalCarsCost());
        assertEquals(0, companyWithoutCar.totalCarsCost());
        assertEquals(taxi.getPrimeCost(), companyOneCar.totalCarsCost());
    }

    /**
     * Checking of {@link TaxiCompany#getInSpeedRange(int, int)} method correct performing.
     * Both of method's parameters must be positive, and second parameter must be larger
     * then first one.
     *
     * @throws Exception - exception in test
     */
    @Test
    public void testGetInSpeedRange() throws Exception {
        assertThat(taxiInRange, is(company.getInSpeedRange(170, 190)));
        assertThat(new ArrayList<>(), is(company.getInSpeedRange(170, 170)));
        assertThat(new ArrayList<>(), is(company.getInSpeedRange(0, 0)));
        taxiInRange = new ArrayList<>();
        taxiInRange.add(taxis.get(1));
        assertThat(taxiInRange, is(company.getInSpeedRange(185, 185)));

    }

    /**
     * Checking of {@link TaxiCompany#getInSpeedRange(int, int)} method correct performing
     * with wrong parameters.
     * The method must throws exception if first parameter is negative.
     *
     * @throws Exception - exception in test
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetInSpeedRangeWithExceptionFirstNegative() throws Exception {
        company.getInSpeedRange(-10,100);
    }

    /**
     * Checking of {@link TaxiCompany#getInSpeedRange(int, int)} method correct performing
     * with wrong parameters.
     * The method must throws exception if second parameter is negative.
     *
     * @throws Exception - exception in test
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetInSpeedRangeWithExceptionSecondNegative() throws Exception {
        company.getInSpeedRange(100,-100);
    }

    /**
     * Checking of {@link TaxiCompany#getInSpeedRange(int, int)} method correct performing
     * with wrong parameters.
     * The method must throws exception if first lager then second.
     *
     * @throws Exception - exception in test
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetInSpeedRangeWithExceptionIllegalSequence() throws Exception {
        company.getInSpeedRange(100,10);
    }

    /**
     * Checking of {@link TaxiCompany#getSortedCarList(Comparator)} method correct performing.
     *
     * @throws Exception - exception in test
     */
    @Test
    public void testGetSortedCarList() throws Exception {
        assertThat(sortedListOfTaxi, is(company.getSortedCarList(new CarFuelRateComparator<>())));
        company = new TaxiCompany("New Company");
        assertThat(new LinkedList<>(), is(company.getSortedCarList(new CarFuelRateComparator<>())));
    }
}