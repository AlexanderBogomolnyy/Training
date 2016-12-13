package ua.training.textparser.model.entity.data;

import ua.training.textparser.model.entity.note.NoteFactory;
import ua.training.textparser.model.entity.note.Document;
import ua.training.textparser.model.entity.note.NoteType;

import java.io.*;
import java.util.Objects;

/**
 * <p> The File Resource class.
 * This class implements Resource interface.
 * THis class provides method for getting text document from external text file.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 05.12.2016.
 */
public class FileResource implements Resource{

    /**
     * A constant holding the message about file not founding
     */
    public static final String FILE_NOT_FOUND_MESSAGE = "File: '%s' does not exists. Please check the path.";

    /**
     * A constant holding the message about error during working with file
     */
    public static final String IO_EXCEPTION_MESSAGE = "Something wrong happened during data loading.";

    /**
     * This field contains information about path to processed file
     */
    private File path;

    FileResource(File path) {
        this.path = path;
    }

    /**
     * This method sets path to data file
     * @param path - path to data file
     */
    public void setPath(File path) {
        this.path = path;
    }

    /**
     * This method gets text data from the file and returns them as new Document
     *
     * @return new Document
     */
    @Override
    public Document getDocument() {
        StringBuilder builder = new StringBuilder();
        Objects.requireNonNull(path);
        if(!path.exists() || path.isDirectory()) {
            throw new RuntimeException(new FileNotFoundException(String.format(FILE_NOT_FOUND_MESSAGE, path.getPath())));
        }
        try (BufferedReader in = new BufferedReader(new FileReader(path))) {
            String str;

            while ((str = in.readLine()) != null) {
                builder.append(str).append("\n");
            }
        } catch (IOException ex) {
            throw new RuntimeException(IO_EXCEPTION_MESSAGE, ex);
        }
        return (Document) NoteFactory.getInstance().getNote(builder.toString(), NoteType.DOCUMENT);
    }

}
