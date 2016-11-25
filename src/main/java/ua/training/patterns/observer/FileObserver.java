package ua.training.patterns.observer;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * <p> The class represents File Observer and implements Observer interface.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 25.11.2016.
 */
public class FileObserver implements Observer {
    @Override
    public void handleEvent(int temperature, int presser) {
        File file;
        try {
            file = File.createTempFile("TempPresser", "_txt"); //creating file in temp folder
            PrintWriter printWriter = new PrintWriter(file);
            printWriter.print("The weather has changed. Temperature = " + temperature + ", Presser = " + presser + ".");
            printWriter.println();
            printWriter.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
