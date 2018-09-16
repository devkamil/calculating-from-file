package pl.devkamil.app;

import java.util.ArrayList;

public class Application {

    public static void main (String[] args){

       Calculations calculations = new Calculations();
       InputLoader inputLoader = new InputLoader();

       ArrayList<String> listOfValuesFromFile = inputLoader.readFile("file.txt");
       calculations.calculationOfTheResult(listOfValuesFromFile);
    }
}
