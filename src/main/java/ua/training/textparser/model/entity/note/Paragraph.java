package ua.training.textparser.model.entity.note;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

/**
 * <p> The Note class contains text paragraphs.
 * This class extends AbstractNote class.
 * This class holds inside the list of paragraph notes.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 06.12.2016.
 */
public class Paragraph extends AbstractNote {

    Paragraph(String content) {
        super(content);
    }

    /**
     * This method sets current note type, and types of supported children
     */
    @Override
    protected void initTypes() {
        type = NoteType.PARAGRAPH;
        supportedNotes.add(NoteType.SENTENCE);
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
        input = input.replaceAll("[ ]+", " "); //removing whitespace duplications
        Matcher matchParagraph = RegEx.PARAGRAPH_PATTERN.matcher(input);
        String[] paragraphs = RegEx.PARAGRAPH_PATTERN.split(input);
        for(String paragraph: paragraphs) {
            Matcher matcher = RegEx.SENTENCE_PATTERN.matcher(paragraph);
            int start = 0;
            while (matcher.find()) {
                int end = matcher.end();
                String sentence = paragraph.substring(start, end);
                if (!sentence.isEmpty()) {
                    result.add(factory.getNote(sentence, NoteType.SENTENCE));
                }
                start = end;
            }
            if (matchParagraph.find()) {
                addSeparator(input, result, matchParagraph);
            }
        }
        return result;
        }

}
