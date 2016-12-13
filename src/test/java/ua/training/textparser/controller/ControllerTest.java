package ua.training.textparser.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import ua.training.textparser.model.entity.data.Resource;
import ua.training.textparser.model.entity.data.ResourceFactory;
import ua.training.textparser.model.entity.note.Document;
import ua.training.textparser.view.ConsoleView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 * <p> The class contains test cases for Controller.class.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 10.12.2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class ControllerTest {

    private Controller controller;

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

    private List<String> wordSequenceFirstSentence = new ArrayList<String>(){{
        add("Interchangeable");
        add("objects");
        add("with");
        add("polymorphism");
    }};

    private List<String> uniqueWords = new ArrayList<String>(){{
        add("Interchangeable");
        add("polymorphism");
    }};

    @Mock
    File file;

    @Mock
    private Resource resource;

    @Mock
    private ResourceFactory factory;

    @Mock
    private ConsoleView view;

    private InOrder inOrder;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        inOrder = inOrder(view);
        controller = new Controller(factory, file, view);
        when(factory.getFileResource(file)).thenReturn(resource);
        when(file.exists()).thenReturn(true);
        when(file.isDirectory()).thenReturn(false);
    }

    @Test
    public void testExecute() throws Exception {
        when(resource.getDocument()).thenReturn(new Document(content));
        controller.execute();
        inOrder.verify(view).printlnMessage(ConsoleView.INTRODUCTION);
        inOrder.verify(view).printMessage(ConsoleView.WORDS_FOR_SEARCH);
        inOrder.verify(view).printCollection(wordSequenceFirstSentence);
        inOrder.verify(view).printMessage(ConsoleView.SEARCH_STATISTICS);
        inOrder.verify(view).printCollection(uniqueWords);
    }

    @Test
    public void testExecuteEmptyFirst() throws Exception {
        when(resource.getDocument()).thenReturn(new Document(emptyFirst));
        controller.execute();
        inOrder.verify(view).printlnMessage(ConsoleView.INTRODUCTION);
        inOrder.verify(view).printlnMessage(ConsoleView.EMPTY_SENTENCE_EXCEPTION);
    }
}