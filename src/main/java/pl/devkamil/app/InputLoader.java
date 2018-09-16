package pl.devkamil.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class InputLoader {
    private final static String APPLY = TypeOfCalculation.APPLY.name();

    public ArrayList<String> readFile(String pathToFile){
        ArrayList<String> listWithValuesFromFile = new ArrayList<>();
        String line;
        boolean isFindWordApply = false;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(pathToFile))){
            while ( ((line = bufferedReader.readLine()) != null) && !isFindWordApply) {
                listWithValuesFromFile.add(line);
                if (line.toUpperCase().contains(APPLY)){
                    isFindWordApply = true;
                }
            }
        }catch (IOException ex){
            ex.printStackTrace();
        }
        return listWithValuesFromFile;
    }
}
