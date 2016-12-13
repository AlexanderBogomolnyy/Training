package ua.training.textparser.model.entity.note;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * <p> The class contains test cases for NoteFactory.class.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 10.12.2016.
 */
public class NoteFactoryTest {

    private NoteFactory factory;
    private String content;
    private char sign;

    @Before
    public void setUp() {
        factory = NoteFactory.getInstance();
        content = "abc";
        sign = 'a';
    }

    @Test
    public void testGetInstance() throws Exception {
        NoteFactory factory1 = NoteFactory.getInstance();
        assertTrue(factory == factory1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetNoteIllegalArgument() throws Exception {
        factory.getNote("", NoteType.DOCUMENT);
    }

    @Test(expected = NullPointerException.class)
    public void testGetNoteNullPointer() throws Exception {
        factory.getNote(null, NoteType.DOCUMENT);
    }

    @Test
    public void testGetNoteDocument() {
        Document document = (Document) factory.getNote(content, NoteType.DOCUMENT);
        assertTrue(document != null);
        assertTrue(document.getType() == NoteType.DOCUMENT);
        document.parse();
        assertTrue(document.getContent().equals(content));
    }

    @Test
    public void testGetNoteParagraph() {
        Paragraph paragraph = (Paragraph) factory.getNote(content, NoteType.PARAGRAPH);
        assertTrue(paragraph != null);
        assertTrue(paragraph.getType() == NoteType.PARAGRAPH);
        assertTrue(paragraph.getContent().equals(content));
    }

    @Test
    public void testGetNoteSentence() {
        Sentence sentence = (Sentence) factory.getNote(content, NoteType.SENTENCE);
        assertTrue(sentence != null);
        assertTrue(sentence.getType() == NoteType.SENTENCE);
        assertTrue(sentence.getContent().equals(content));
    }

    @Test
    public void testGetNoteWord() {
        Word word = (Word) factory.getNote(content, NoteType.WORD);
        assertTrue(word != null);
        assertTrue(word.getType() == NoteType.WORD);
        assertTrue(word.getContent().equals(content));
        Word word1 = (Word) factory.getNote(content, NoteType.WORD);
        assertTrue(word == word1);
    }

    @Test
    public void testGetSign() throws Exception {
        Sign ch = (Sign) factory.getSign(sign);
        assertTrue(ch != null);
        assertTrue(ch.getType() == NoteType.SIGN);
        assertTrue(ch.getContent().equals(Character.toString(sign)));
    }

}