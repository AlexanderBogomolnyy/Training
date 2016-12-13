package ua.training.textparser.model.entity.note;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

/**
 * <p> The class contains test cases for Document.class.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 10.12.2016.
 */
public class DocumentTest {

    private Document document;

    private String content = "Interchangeable objects with polymorphism.\n" +
            "When dealing with type hierarchies. Such code is unaffected by the addition of new types! " +
            "There's a problem, however, with attempting to treat derived-type objects as their generic base types.\n" +
            "\n" +
            "If you write a method in Java (as you will soon learn how to do):\n" +
            "void doStuff(Shape s) {\n" +
            "  s.erase();\n" +
            "  // ...\n" +
            "  s.draw();\n" +
            "}";

    private String oneParagraph = "! a. Interchangeable objects with polymorphism.\n" +
            "When dealing with type hierarchies. Such code is unaffected by the addition of new types! " +
            "There's a problem, however, with attempting to treat derived-type objects as their generic base types.";

    @Before
    public void setUp() throws Exception {
        document = new Document(content);
    }

    @Test
    public void testParseResource() throws Exception {
        document.parse();
        assertTrue(document.hasChildNotes());
        List<Note> tree = document.getNoteTree();
        assertNotNull(tree);
    }

    @Test
    public void testParseDocument() throws Exception {
        document.parse();
        List<Note> docNotes = document.getChildNotes();
        int counterParagraph = 0;
        int counterCode = 0;
        for (Note docNote : docNotes) {
            if (docNote.getType() == NoteType.PARAGRAPH)
                counterParagraph++;
            if (docNote.getType() == NoteType.CODE)
                counterCode++;
        }
        assertTrue(counterParagraph != 0);
        assertTrue(counterCode != 0);
    }

    @Test
    public void testParseParagraph() throws Exception {
        document.parse();
        List<Note> paragraphs = document.getChildNotes()
                .stream()
                .filter(x -> x.getType() == NoteType.PARAGRAPH)
                .collect(Collectors.toList());
        int counterSentence = 0;
        int counterSign = 0;
        for (Note paragraph : paragraphs) {
            if (paragraph.hasChildNotes()) {
                List<Note> parNotes = paragraph.getChildNotes();
                for (Note parNote : parNotes) {
                    if (parNote.getType() == NoteType.SENTENCE)
                        counterSentence++;
                    if (parNote.getType() == NoteType.SIGN)
                        counterSign++;
                }
                assertTrue(counterSentence != 0);
                assertTrue(counterSign != 0);
            }
        }
    }

    @Test
    public void testParseSentence() throws Exception {
        document.parse();
        List<Note> paragraphs = document.getChildNotes()
                .stream()
                .filter(x -> x.getType() == NoteType.PARAGRAPH)
                .collect(Collectors.toList());
        int counterWord = 0;
        int counterSign = 0;
        for (Note paragraph : paragraphs) {
            if (paragraph.hasChildNotes()) {
                List<Note> sentences = paragraph.getChildNotes()
                        .stream()
                        .filter(x -> x.getType() == NoteType.SENTENCE)
                        .collect(Collectors.toList());
                for (Note sentence : sentences) {
                    if (sentence.hasChildNotes()) {
                        List<Note> sentNotes = sentence.getChildNotes();
                        for (Note sentNote : sentNotes) {
                            if (sentNote.getType() == NoteType.WORD)
                                counterWord++;
                            if (sentNote.getType() == NoteType.SIGN)
                                counterSign++;
                        }
                        assertTrue(counterWord != 0);
                        assertTrue(counterSign != 0);
                    }
                }
            }
        }
    }

    @Test
    public void testParseWord() throws Exception {
        document.parse();
        List<Note> paragraphs = document.getChildNotes()
                .stream()
                .filter(x -> x.getType() == NoteType.PARAGRAPH)
                .collect(Collectors.toList());
        int counterSign = 0;
        for (Note paragraph : paragraphs) {
            if (paragraph.hasChildNotes()) {
                List<Note> sentences = paragraph.getChildNotes()
                        .stream()
                        .filter(x -> x.getType() == NoteType.SENTENCE)
                        .collect(Collectors.toList());
                for (Note sentence : sentences) {
                    if (sentence.hasChildNotes()) {
                        List<Note> words = sentence.getChildNotes()
                                .stream()
                                .filter(x -> x.getType() == NoteType.WORD)
                                .collect(Collectors.toList());
                        for (Note word : words) {
                            if (word.hasChildNotes()) {
                                List<Note> wordNotes = word.getChildNotes();
                                for (Note wordNote : wordNotes) {
                                    if (wordNote.getType() == NoteType.SIGN)
                                        counterSign++;
                                }
                                assertTrue(counterSign != 0);
                            }
                        }
                    }
                }
            }
        }
    }

    @Test
    public void testParseSingleParagraph() throws Exception {
        document = new Document(oneParagraph);
        document.parse();
        assertTrue(document.hasChildNotes());
        List<Note> paragraphs = document.getChildNotes();
        assertEquals(1, paragraphs.size());
        Note paragraph = paragraphs.get(0);
        assertTrue(paragraph.hasChildNotes());
        List<Note> sentences = paragraph.getChildNotes()
                .stream()
                .filter(x -> x.getType() == NoteType.SENTENCE)
                .collect(Collectors.toList());
        List<Note> paragraphSplitters = paragraph.getChildNotes()
                .stream()
                .filter(x -> x.getType() == NoteType.SIGN)
                .collect(Collectors.toList());
        assertEquals(6, sentences.size());
        assertEquals(0, paragraphSplitters.size());
    }

    @Test
    public void testParseEmptySentence() throws Exception {
        document = new Document(oneParagraph);
        document.parse();
        List<Note> paragraphs = document.getChildNotes();
        Note paragraph = paragraphs.get(0);
        List<Note> sentences = paragraph.getChildNotes()
                .stream()
                .filter(x -> x.getType() == NoteType.SENTENCE)
                .collect(Collectors.toList());
        Note firstSentence = sentences.get(0);
        assertTrue(firstSentence.hasChildNotes());
        long counter = firstSentence.getChildNotes()
                .stream()
                .filter(x -> x.getType() == NoteType.WORD)
                .count();
        assertEquals(0, counter);
        counter = firstSentence.getChildNotes()
                .stream()
                .filter(x -> x.getType() == NoteType.SIGN)
                .count();
        assertEquals(2, counter);
        assertEquals("!", firstSentence.getChildNotes().get(0).getContent());
        assertEquals(" ", firstSentence.getChildNotes().get(1).getContent());
    }

    @Test
    public void testParseOneWordSentence() throws Exception {
        document = new Document(oneParagraph);
        document.parse();
        List<Note> paragraphs = document.getChildNotes();
        Note paragraph = paragraphs.get(0);
        List<Note> sentences = paragraph.getChildNotes()
                .stream()
                .filter(x -> x.getType() == NoteType.SENTENCE)
                .collect(Collectors.toList());
        Note secondSentence = sentences.get(1);
        assertTrue(secondSentence.hasChildNotes());
        List<Note> words = secondSentence.getChildNotes()
                .stream()
                .filter(x -> x.getType() == NoteType.WORD)
                .collect(Collectors.toList());
        assertEquals(1, words.size());
        List<Note> signs = secondSentence.getChildNotes()
                .stream()
                .filter(x -> x.getType() == NoteType.SIGN)
                .collect(Collectors.toList());
        assertEquals(2, signs.size());
        assertEquals("a", words.get(0).getContent());
        assertEquals(".", signs.get(0).getContent());
        assertEquals(" ", signs.get(1).getContent());
    }

    @Test
    public void testParseOneSignWord() throws Exception {
        document = new Document(oneParagraph);
        document.parse();
        List<Note> paragraphs = document.getChildNotes();
        Note paragraph = paragraphs.get(0);
        List<Note> sentences = paragraph.getChildNotes()
                .stream()
                .filter(x -> x.getType() == NoteType.SENTENCE)
                .collect(Collectors.toList());
        Note secondSentence = sentences.get(1);
        List<Note> words = secondSentence.getChildNotes()
                .stream()
                .filter(x -> x.getType() == NoteType.WORD)
                .collect(Collectors.toList());
        Note word = words.get(0);
        assertTrue(word.hasChildNotes());
        List<Note> signs = word.getChildNotes();
        int counter = 0;
        for(Note sign: signs) {
            assertTrue(sign.getType() == NoteType.SIGN);
            counter++;
        }
        assertEquals(1, counter);
        assertEquals("a", signs.get(0).getContent());
    }

    @Test
    public void testParseMultipleCall() throws Exception {
        document.parse();
        List<Note> firstCall = document.getNoteTree();
        document.parse();
        List<Note> secondCall = document.getNoteTree();
        document.parse();
        List<Note> thirdCall = document.getNoteTree();
        checkSame(firstCall, secondCall);
        checkSame(secondCall, thirdCall);
        checkSame(thirdCall, firstCall);
    }

    private void checkSame(List<Note> first, List<Note> second) {
        assertEquals(first.size(), second.size());
        for (int i = 0; i < first.size(); i++) {
            assertTrue(first.get(i).equals(second.get(i)));
        }
    }

    @Test
    public void testEmptyDocumentHasNotes() throws Exception {
        document = new Document("");
        document.parse();
        assertFalse(document.hasChildNotes());
    }

    @Test (expected = NoSuchElementException.class)
    public void testEmptyDocumentChildrenException() throws Exception {
        document = new Document("");
        document.parse();
        document.getChildNotes();
    }

    @Test
    public void testEmptyDocumentTreeException() throws Exception {
        document = new Document("");
        document.parse();
        List<Note> tree = document.getNoteTree();
        assertEquals(1, tree.size());
        assertTrue(tree.get(0).getType() == NoteType.DOCUMENT);
    }

    @Test
    public void testGetContent() throws Exception {
        assertEquals("", document.getContent());
        document.parse();
        assertEquals(content, document.getContent());
        document = new Document(oneParagraph);
        document.parse();
        assertEquals(oneParagraph, document.getContent());
        document = new Document("");
        document.parse();
        assertEquals("", document.getContent());
    }

}