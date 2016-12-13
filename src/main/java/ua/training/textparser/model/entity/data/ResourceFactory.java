package ua.training.textparser.model.entity.data;

import java.io.File;

/**
 * <p> The Document Resource Factory class.
 * This is singleton class. It provides methods for getting different
 * kinds of external resources.
 * There is two getting resources methods.
 * One for getting File resource and another for getting Data Base resource.
 * Data Base resource doesn't support at the moment.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 05.12.2016.
 */
public class ResourceFactory {

    /**
     * A constant holding the message about unsupported operation
     */
    private static final String UNSUPPORTED_OPERATION = "Unsupported resource";

    /**
     * This field contains single factory instance
     */
    private static ResourceFactory instance;

    /**
     * This method creates new factory instance
     *
     * @return new factory instance
     */
    public static ResourceFactory getInstance() {
        if (instance == null) {
            instance = new ResourceFactory();
        }
        return instance;
    }

    /**
     * This method generates new file resource for the text file.
     *
     * @param path - path to file
     * @return - new file resource
     */
    public Resource getFileResource(File path) {
        return new FileResource(path);
    }

    /**
     * This method generates new Data Base resource for the text data.
     * At the moment this method throws Exception - UnsupportedOperationException.
     * This method will be implemented in future versions of application.
     *
     * @return - new data base resource
     */
    public Resource getDataBaseResource() {
        throw new UnsupportedOperationException(UNSUPPORTED_OPERATION);
    }

}