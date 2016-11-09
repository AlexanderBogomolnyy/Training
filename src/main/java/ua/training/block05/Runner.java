package ua.training.block05;

import ua.training.block05.controller.Controller;
import ua.training.block05.entity.TextWindow;
import ua.training.block05.model.MetaData;
import ua.training.block05.view.View;

/**
 * <p> The main started class.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 08.11.2016.
 */
public class Runner {

    public static void main(String[] args) {
        //Initializing model, view and controller
        MetaData metaData = new MetaData(TextWindow.class);  //model
        View view = new View();
        Controller controller = new Controller(metaData, view);
        // Run the controller
        controller.execute();
    }

}
