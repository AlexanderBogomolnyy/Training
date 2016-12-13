package ua.training.textparser;

import ua.training.textparser.controller.Controller;
import ua.training.textparser.model.entity.data.ResourceFactory;
import ua.training.textparser.model.entity.data.Resource;
import ua.training.textparser.view.ConsoleView;

import java.io.File;

/**
 * <p> The main class.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 05.12.2016.
 */
public class Runner {

    /**
     * A constant holding the path to the directory with resources fileName
     */
    public static final String DATA_RESOURCE_DIR = System.getProperty("user.dir") + "/src/main/resources/";

    public static void main(String[] args) {
        //Initializing model parameter, view and controller
        File file = new File(DATA_RESOURCE_DIR + "text.txt");
        ResourceFactory factory = ResourceFactory.getInstance();
        ConsoleView view = new ConsoleView();
        Controller controller = new Controller(factory, file, view);

        //Activating the controller
        controller.execute();
    }
}
