package ua.training.textparser.model.processor;

import ua.training.textparser.model.entity.note.Document;
import ua.training.textparser.model.entity.note.Note;
import ua.training.textparser.model.entity.note.NoteType;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <p> The Document processing class.
 * This class provides method for searching in document
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 05.12.2016.
 */
public class DocumentProcessor {

    /**
     * This field contains document for search
     */
    private Document document;

    public DocumentProcessor(Document document) {
        this.document = document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    /**
     * This method is looking for repetition of words from fist sentence
     * through whole document text
     *
     * @return list of words
     */
    public List<String> selectUnrepeatedWords() {
        document.parse();
        List<Note> documentTree = document.getNoteTree();

        Note firstSentence = documentTree.stream()
                .filter(x -> x.getType() == NoteType.SENTENCE)
                .findFirst().get();

        if (!firstSentence.hasChildNotes()) {
            return new ArrayList<>();
        }

        List<String> selectedWords = firstSentence.getChildNotes()
                .stream()
                .filter(x -> x.getType() == NoteType.WORD)
                .map(Note::getContent)
                .collect(Collectors.toList());

        Map<String, Long> statistic = documentTree.stream()
                .filter(x -> selectedWords.stream()
                        .filter(s -> s.equalsIgnoreCase(x.getContent()))
                        .findFirst().isPresent())
                .collect(Collectors.groupingBy(note -> note.getContent().toLowerCase(), Collectors.counting()));

        List<String> single = selectedWords.stream()
                .filter(x -> statistic.entrySet().stream()
                        .filter(s -> s.getKey().equalsIgnoreCase(x) && s.getValue() == 1)
                        .findFirst().isPresent())
                .collect(Collectors.toList());

        return single;
    }

}

