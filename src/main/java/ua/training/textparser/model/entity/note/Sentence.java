package ua.training.textparser.model.entity.note;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

/**
 * <p> The Note class contains text sentence.
 * This class extends AbstractNote class.
 * This class holds inside the list of sentence notes.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 06.12.2016.
 */
public class Sentence extends AbstractNote{

    Sentence(String content) {
        super(content);
    }

    /**
     * This method sets current note type, and types of supported children
     */
    @Override
    protected void initTypes() {
        type = NoteType.SENTENCE;
        supportedNotes.add(NoteType.WORD);
        supportedNotes.add(NoteType.SIGN);
    }

    /**
     * This method builds tree of child notes.
     *
     * @param input input String content
     * @return - list of notes
     */
    @Override
    protected List<Note> parseContent(String input) {
        List<Note> result = new ArrayList<>();
        Matcher matchSentence = RegEx.SENTENCE_PATTERN.matcher(input);
        String[] sentences = RegEx.SENTENCE_PATTERN.split(input);
        for (String sentence : sentences) {
            Matcher matcher = RegEx.WORD_PATTERN.matcher(sentence);
            int start = 0;
            while (matcher.find()) {
                int end = matcher.end();
                String word = sentence.substring(start, matcher.start());
                if (!word.isEmpty()) {
                    result.add(factory.getNote(word, NoteType.WORD));
                }
                start = end;
                addSeparator(sentence, result, matcher);
            }
            if (matchSentence.find()) {
                addSeparator(input, result, matchSentence);
            }
        }
        if(sentences.length == 0 && !input.isEmpty())
            addSigns(input, result);
        return result;
    }

}
