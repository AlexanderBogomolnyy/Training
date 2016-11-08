package ua.training.block04;

import ua.training.block04.controller.Controller;
import ua.training.block04.model.Notebook;
import ua.training.block04.view.View;

/**
 * <p> The main started class.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 06.11.2016.
 */
public class Runner {

    public static void main(String[] args) {
        //Initializing model, view and controller
        Notebook notebook = new Notebook();  //model
        View view = new View();
        Controller controller = new Controller(notebook, view);

        // Run the controller
        controller.execute();
    }

}
