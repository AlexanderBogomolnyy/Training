package ua.training.textparser.controller;

import ua.training.textparser.model.entity.data.Resource;
import ua.training.textparser.model.entity.data.ResourceFactory;
import ua.training.textparser.model.entity.note.Document;
import ua.training.textparser.model.entity.note.Note;
import ua.training.textparser.model.entity.note.NoteType;
import ua.training.textparser.model.processor.DocumentProcessor;
import ua.training.textparser.view.ConsoleView;

import java.io.File;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * <p> The controller class.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 05.12.2016.
 */
public class Controller {

    /**
     * The Resource factory
     */
    private ResourceFactory factory;

    /**
     * The field contains resource file
     */
    private File file;

    /**
     * The view
     */
    private ConsoleView view;

    public Controller(ResourceFactory factory, File file, ConsoleView view) {
        this.factory = factory;
        this.file = file;
        this.view = view;
    }

    /**
     * Main executing method of controller
     */
    public void execute() {
        if (file.exists() && !file.isDirectory()) {
            Resource resource = factory.getFileResource(file);
            Document document = resource.getDocument();
            analyzeDocument(document);
        } else {
            view.printlnMessage(ConsoleView.DATA_LOADING_EXCEPTION);
        }
    }

    // This method looks for the repetition of words from first sentence
    // in whole document
    private void analyzeDocument(Document document) {
        Objects.requireNonNull(document);
        document.parse();
        view.printlnMessage(ConsoleView.INTRODUCTION);

        Note firstWord = document.getNoteTree().stream()
                .filter(x -> x.getType() == NoteType.SENTENCE)
                .findFirst().get();

        List<String> words = firstWord.getChildNotes()
                .stream()
                .filter(x -> x.getType() == NoteType.WORD)
                .map(Note::getContent)
                .collect(Collectors.toList());

        if (words.isEmpty()) {
            view.printlnMessage(ConsoleView.EMPTY_SENTENCE_EXCEPTION);
        } else {
            DocumentProcessor processor = new DocumentProcessor(document);
            List<String> unique = processor.selectUnrepeatedWords();
            view.printMessage(ConsoleView.WORDS_FOR_SEARCH);
            view.printCollection(words);
            view.printMessage(ConsoleView.SEARCH_STATISTICS);
            view.printCollection(unique);
        }
    }

}

