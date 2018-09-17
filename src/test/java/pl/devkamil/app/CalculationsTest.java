package pl.devkamil.app;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

public class CalculationsTest {

    private static Calculations calculations;
    private static ArrayList<String> correctList;
    private static ArrayList<String> emptyList;
    private static ArrayList<String> incorrectList;

    @BeforeClass
    public static void setUp(){
        calculations = new Calculations();
        correctList = new ArrayList<>();
        correctList.add("add 6");
        correctList.add("multiply 8");
        correctList.add("apply 10");
        emptyList = new ArrayList<>();
        incorrectList = new ArrayList<>();
        incorrectList.add("blabla 23");
        incorrectList.add("asdas");
    }


    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void shouldThrowExceptionIfListIsEmpty(){
        calculations.calculationOfTheResult(emptyList);
    }

    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void shouldThrowExceptionIfListDoesntContainApplyWord(){
        calculations.calculationOfTheResult(incorrectList);
    }
}
