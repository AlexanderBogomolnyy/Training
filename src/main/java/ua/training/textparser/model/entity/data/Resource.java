package ua.training.textparser.model.entity.data;

import ua.training.textparser.model.entity.note.Document;

/**
 * <p> The data resource interface.
 * This interface provides method to get Document
 * from some kind of resource like File or Data base.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 05.12.2016.
 */
public interface Resource {

    /**
     * This method gets Document from the external resource
     *
     * @return - document, which implements Document interface
     */
    Document getDocument();

}
