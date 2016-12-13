package ua.training.textparser.model.entity.note;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;

/**
 * <p> The document note class.
 * This class extends AbstractNote class and overrides context parsing method.
 * This class provides method for parsing context and building full note tree.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 05.12.2016.
 */
public class Document extends AbstractNote {

    /**
     * A constant holding the message about unsupported content value
     */
    private static final String NO_CONTENT_EXCEPTION = "Document does not contain any content.";

    /**
     * Document content
     */
    private String content;

    public Document(String content) {
        super();
        this.content = content;
    }

    @Override
    protected void initTypes() {
        type = NoteType.DOCUMENT;
        supportedNotes.add(NoteType.PARAGRAPH);
        supportedNotes.add(NoteType.CODE);
    }

    /**
     * This method builds tree of child notes for current document content.
     */
    public void parse() {
        if (content == null)
            throw new IllegalStateException(NO_CONTENT_EXCEPTION);
        initContainer();
        addNotes(parseContent(content));
    }

    /**
     * This method builds tree of child notes. It extracts Java code blocks
     * and text paragraphs to Document list of notes.
     *
     * @param input input String content
     * @return - list of notes
     */
    @Override
    protected List<Note> parseContent(String input) {
        List<Note> result = new ArrayList<>();
        if(input.isEmpty())
            return result;
        Matcher code = RegEx.CODE_PATTERN.matcher(input);
        int current = 0;
        while (code.find(current)) {
            int codeStart = code.start();
            String substring = input.substring(current, codeStart);
            if (!substring.isEmpty()) {
                extractToParagraph(substring, result);
            }
            current = extractCode(input, codeStart, result);
        }
        if (current == 0)
            extractToParagraph(input, result);
        else if (current < input.length()) {
            extractToParagraph(input.substring(current), result);
        }
        return result;
    }

    //this method extracts paragraph to single note
    private void extractToParagraph(String input, List<Note> result) {
        Matcher matcher = RegEx.PARAGRAPH_PATTERN.matcher(input);
        int start = 0;
        while (matcher.find()) {
            int end = matcher.end();
            result.add(factory.getNote(input.substring(start, end), NoteType.PARAGRAPH));
            start = end;
        }
    }

    //this method extracts java code to single Note
    private int extractCode(String input, int start, List<Note> result) {
        String substring = input.substring(start);
        char[] search = substring.toCharArray();
        Stack<Character> stack = new Stack<>();
        boolean containBrackets = false;
        for (int i = 0; i < search.length; i++) {
            if (search[i] == '{') {
                stack.push('{');
                containBrackets = true;
            }
            if (search[i] == '}') {
                stack.pop();
            }
            if (containBrackets && stack.isEmpty()) {
                if((i + 1 < search.length && search[i+1] == '\n')) {
                    String code = input.substring(start, start + i + 2);
                    result.add(factory.getNote(code, NoteType.CODE));
                    return start + i + 2;
                } else {
                    if ((i + 1 >= search.length)) {
                        String code = input.substring(start, start + i + 1);
                        result.add(factory.getNote(code, NoteType.CODE));
                        return start + i + 1;
                    }
                }
            }
        }
        return start + substring.length();
    }

}
