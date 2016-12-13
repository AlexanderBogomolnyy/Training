package ua.training.textparser.model.processor;

import org.junit.Before;
import org.junit.Test;
import ua.training.textparser.model.entity.note.Document;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * <p> The class contains test cases for DocumentProcessor.class.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 10.12.2016.
 */
public class DocumentProcessorTest {

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

    private String emptyFirst = ".\n" +
            "When dealing with type hierarchies. Such code is unaffected by the addition of new types! " +
            "There's a problem, however, with attempting to treat derived-type objects as their generic base types.\n" +
            "\n" +
            "If you write a method in Java (as you will soon learn how to do):";

    private String allRepeated = "Objects with Java code.\n" +
            "When dealing with type hierarchies. Such code is unaffected by the addition of new types! " +
            "There's a problem, however, with attempting to treat derived-type objects as their generic base types.\n" +
            "\n" +
            "If you write a method in Java (as you will soon learn how to do):";

    private DocumentProcessor processor;
    private List<String> expected = new ArrayList<>();


    @Before
    public void setUp(){
        document = new Document(content);
        processor = new DocumentProcessor(document);
        expected.add("Interchangeable");
        expected.add("polymorphism");
    }

    @Test
    public void testSelectUnrepeatedWords() throws Exception {
        List<String> search = processor.selectUnrepeatedWords();
        for (String string: search) {
            assertTrue(expected.contains(string));
        }
    }

    @Test
    public void testSelectUnrepeatedWordsNothing() throws Exception {
        for(String remove: expected) {
            content = content.replace(remove, "");
        }
        document = new Document(content);
        processor = new DocumentProcessor(document);
        List<String> search = processor.selectUnrepeatedWords();
        assertTrue(search.isEmpty());
    }

    @Test
    public void testSelectUnrepeatedWordsEmptyFirst() throws Exception {
        document = new Document(emptyFirst);
        processor = new DocumentProcessor(document);
        List<String> search = processor.selectUnrepeatedWords();
        assertTrue(search.isEmpty());
    }

    @Test
    public void testSelectUnrepeatedWordsAllRepeated() throws Exception {
        document = new Document(allRepeated);
        processor = new DocumentProcessor(document);
        List<String> search = processor.selectUnrepeatedWords();
        assertTrue(search.isEmpty());
    }
}