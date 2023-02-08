import java.util.*;

public class Calculator {
    private ArrayList<Double> operands;
    private char operator;
    private int cacheCapacity;
    private ArrayList<Double> cachedResults;
    private int currentResultIndex;

    public boolean checkInput(String userInput){
        if (userInput == null){
            return false;
        }

        boolean validInput = false;
        char[] inputChars = userInput.toCharArray();
        char[] operators = new char[] { '+', '-', '*', '/', 'q', 's'};
        boolean hasNoOperators = true;
        boolean hasNoNumbers = true;
        boolean lastInputCharWasOperator = false;

        for (int i = 0; i < inputChars.length; i++){
            if (Character.isDigit(inputChars[i])){
                hasNoNumbers = false;
                lastInputCharWasOperator = false;
                continue;
            }
            for (char c : operators){
                if (i == 0){
                    if (inputChars[i] == c){
                        // First input char was an operator
                        return false;
                    }
                }

                if (i == inputChars.length - 1){
                    if (inputChars[i] == c){
                        // Last input char was an operator
                        return false;
                    }
                }

                if (inputChars[i] == c){
                    if (!lastInputCharWasOperator){
                        lastInputCharWasOperator = true;
                        hasNoOperators = false;
                    }
                    else {
                        // Operators were input consecutively
                        return false;
                    }
                }
            }
        }

        if (hasNoNumbers){
            return false;
        }

        if (hasNoOperators){
            return false;
        }

        return true;
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
//    public boolean checkInput(String s){
//        if (s==null){
//            return false;
//        }
//        try{
//            double value = Double.parseDouble(s);
//        }catch (NumberFormatException nfe){
//            return false;
//        }
//        return true;
//    }

    @Override
    public String toString() {
        return "Calculator2{" +
                "operands=" + operands +
                ", operator=" + operator +
                ", cacheCapacity=" + cacheCapacity +
                ", cachedResults=" + cachedResults +
                ", currentResultsIndex=" + currentResultIndex +
                '}';
    }



    /* Returns previous calculated result or return 0 if there are
     no cached results */
    public double getLastResult(){
        if (cachedResults.size() == 0){
            return 0;
        }
        currentResultIndex = cachedResults.size() - 1;
        return cachedResults.get(cachedResults.size() - 1);
    }

    /* Cycles back by one index through the results cache and returns the
    * value found */
    public double cycleToPreviousResult(){
        currentResultIndex -= 1;
        if (currentResultIndex < 0){
            currentResultIndex = 0;
        }
        return cachedResults.get(currentResultIndex);
    }

    /* Cycles forward by one index through the results cache and returns
    * the value found */
    public double cycleToNextResult(){
        currentResultIndex += 1;
        if (currentResultIndex >= cachedResults.size()){
            return getLastResult();
        }
        return cachedResults.get(currentResultIndex);
    }

    public void clearCache(){
        cachedResults.clear();
    }

    // Should be overridden in inheriting classes
//    public abstract double makeTheOperationWithOldResult(double result);

    /* Adds result of calculation to the results cache. It removes the
    * first value in the cache before add the new result if the cache is full */
    public void storeResult(double result){
        if (cachedResults.size() == cacheCapacity){
            cachedResults.remove(0);
        }
        cachedResults.add(result);
        currentResultIndex = cachedResults.size() - 1;
    }

    /* Initializes the results cache and sets its capacity. Active index of
    * result cache is set */
    public void setResultCacheCapacity(int cacheCapacity){
        this.cacheCapacity = cacheCapacity;
        cachedResults = new ArrayList<>(cacheCapacity);
        currentResultIndex = 0;
    }

    public double[] parseInput_2_Operands(String input){
        char[] operators = new char[] { '+', '-', '*', '/'};
        char[] inputCharArray = input.toCharArray();

//        for (char c : inputCharArray){
//            for (char op : operators){
//                if (c == op){
//                    operator = op;
//                }
//            }
//        }


        String firstOperand = "";
        String secondOperand = "";
        boolean firstOperandComplete = false;
        for (int i = 0; i < inputCharArray.length; i++){
            char c = inputCharArray[i];
            if (!firstOperandComplete){
                if (Character.isDigit(c)){
                    firstOperand += c;
                }
                else if (!Character.isLetter(c) && !Character.isWhitespace(c)) {
                    operator = c;
                    firstOperandComplete = true;
                }
            }
            else {
                if (Character.isDigit(c)){
                    secondOperand += c;
                }
            }
        }

        return new double[] {Integer.parseInt(firstOperand), Integer.parseInt(secondOperand)};
    }

//    public double[] parseInput_Multiple_Operands(String input){
//
//        Stack<Character> operators = new Stack<>();
//        Queue<String> operandsQueue = new LinkedList<>();
//
//    }

}