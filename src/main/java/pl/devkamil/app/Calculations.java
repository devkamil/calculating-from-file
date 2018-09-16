package pl.devkamil.app;

import org.apache.commons.lang3.EnumUtils;
import java.util.ArrayList;

public class Calculations {
    private static final String REGEX_SPLIT = "\\s+";

    public void calculationOfTheResult(ArrayList<String> listOfTheValues){
        String lastLine = listOfTheValues.get(listOfTheValues.size()-1);
        double result = getNumberFromLineWithApplyWord(lastLine);

        for (String currentLine: listOfTheValues) {
            String [] readLines = currentLine.split(REGEX_SPLIT);
            String currentMathOperation = readLines[0].trim().toUpperCase();
            Double currentNumber = Double.parseDouble(readLines[1]);
            result = mathematicalOperations(currentMathOperation, result, currentNumber);
        }
        System.out.println("The result is: " + result);
    }

    private double mathematicalOperations(String kindOfMathOperation, double currentValue, double newValueToMathOperation){
        double newValueOfResult = currentValue;
        if (EnumUtils.isValidEnum(TypeOfCalculation.class, kindOfMathOperation)) {
            TypeOfCalculation typeOfCalculation = TypeOfCalculation.valueOf(kindOfMathOperation);
            switch(typeOfCalculation){
                case APPLY:
                    newValueOfResult = currentValue;
                    break;
                case ADD:
                    newValueOfResult =  currentValue + newValueToMathOperation;
                    break;
                case MULTIPLY:
                    newValueOfResult = currentValue * newValueToMathOperation;
                    break;
                case DIVIDE:
                    newValueOfResult = currentValue / newValueToMathOperation;
                    break;
                case SUBTRACT:
                    newValueOfResult = currentValue - newValueToMathOperation;
                    break;
                default:
                    System.out.println("Undefined behavior for this operation");
                    newValueOfResult = currentValue;
            }
        } else{
            System.out.println("Undefined operation, please try again");
        }
        return newValueOfResult;
    }

    private double getNumberFromLineWithApplyWord(String inputString){
        String numberFromApplyLine = inputString.split(REGEX_SPLIT)[1];
        return Double.parseDouble(numberFromApplyLine);
    }
}

