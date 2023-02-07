import java.util.ArrayList;
import java.util.Scanner;

public class Calculator2 {
    ArrayList<Double> operands;
    char operator;
    int cacheCapacity;
    ArrayList<Double> cachedResults;
    int currentResultsIndex;

    public Calculator2() {
    }

    /*  Selects number input from buttons.The value is inputted as type string, checked if numeric.
        When a non-numeric input is received the value is parsed to type double and returned*/
    public double selectNumber() {
        Scanner input = new Scanner(System.in);
        boolean inputOn = true;
        String inputString = "";
        while (inputOn) {
            String buttonInput = input.next();
            if (checkInput(buttonInput)) {
                inputString += buttonInput;
            }
            else{
                inputOn = false;
            }
        }
        double operand = Double.parseDouble(inputString);
        return operand;
    }

/* selects operator. ***Scanner Needs to be replaced by button input */

    public char selectOperator(){
        Scanner input = new Scanner(System.in);
        char selectedOperator = input.next().charAt(0);
        return selectedOperator;
    }

    //Groups user input into a stored ArrayList?
    public ArrayList<Double> parceUserInput(){
        ArrayList<Double> inputArray= new ArrayList<Double>(2);
        for(double inputValue: inputArray){
            inputArray.add(selectNumber());
        }

        return inputArray;
    }

    /*Checks if input string value is numeric and returns true if can be parsed as double and false if nfe */
    public boolean checkInput(String s){
        if (s==null){
            return false;
        }
        try{
            double value = Double.parseDouble(s);
        }catch (NumberFormatException nfe){
            return false;
        }
        return true;
    }





    @Override
    public String toString() {
        return "Calculator2{" +
                "operands=" + operands +
                ", operator=" + operator +
                ", cacheCapacity=" + cacheCapacity +
                ", cachedResults=" + cachedResults +
                ", currentResultsIndex=" + currentResultsIndex +
                '}';
    }
}
