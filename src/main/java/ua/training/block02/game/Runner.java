package ua.training.block02.game;

/**
 * <p> The application Main class.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 30.10.2016.
 */
public class Runner {

    public static void main(String[] args) {
        //Initializing model, view and controller
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);

        //Start game play
        controller.start();
    }

}
