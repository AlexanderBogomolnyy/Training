package ua.training.textparser.model.entity.data;

import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

/**
 * <p> The class contains test cases for ResourceFactory.class.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 10.12.2016.
 */
public class ResourceFactoryTest {

    private ResourceFactory factory;

    @Before
    public void setUp() {
        factory = ResourceFactory.getInstance();
    }

    @Test
    public void testGetInstance() throws Exception {
        ResourceFactory factory1 = ResourceFactory.getInstance();
        assertTrue(factory == factory1);
    }

    @Test
    public void testGetFileResource() throws Exception {
        Resource resource = factory.getFileResource(new File("path://"));
        assertTrue(resource instanceof FileResource);
    }

    @Test (expected = UnsupportedOperationException.class)
    public void testGetDataBaseResource() throws Exception {
        factory.getDataBaseResource();
    }
}