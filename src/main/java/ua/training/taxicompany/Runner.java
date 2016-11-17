package ua.training.taxicompany;

import ua.training.taxicompany.controller.Controller;
import ua.training.taxicompany.model.TaxiCompany;
import ua.training.taxicompany.view.ConsoleView;

/**
 * <p> The main class.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 14.11.2016.
 */
public class Runner {
    public static void main(String[] args) {
        //Initializing model, view and controller
        TaxiCompany company = new TaxiCompany("Fast Cabbing");
        ConsoleView view = new ConsoleView();
        Controller controller = new Controller(company, view);

        //Activating the controller
        controller.execute();
    }
}