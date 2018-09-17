package pl.devkamil.app;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class InputLoaderTest {
    private static InputLoader inputLoader;

    @BeforeClass
    public static void setUp(){
        inputLoader = new InputLoader();
    }


    @Test
    public void shouldPassIfPathToFileIsCorrectAndContentOfFileIsCorrect(){
        assertNotNull(inputLoader.readFile("testfile.txt"));
    }

    @Test
    public void arrayListShouldHaveSize2IfFileHave2Lines(){
        assertEquals(2, inputLoader.readFile("testfile.txt").size());
    }
}
