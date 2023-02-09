import java.util.ArrayList;

public class Calculator {
    private int cacheCapacity;
    private ArrayList<Double> cachedResults;
    private int currentResultIndex;

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

//    public double makeTheOperationWithOldResult(double result){
//        // ?
//    }

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


//    public double[] parseInput_2_Operands(String input){
//        char[] operators = new char[] { '+', '-', '*', '/'};
//        char[] inputCharArray = input.toCharArray();
//
//        String firstOperand = "";
//        String secondOperand = "";
//        boolean firstOperandComplete = false;
//        for (int i = 0; i < inputCharArray.length; i++){
//            char c = inputCharArray[i];
//            if (!firstOperandComplete){
//                if (Character.isDigit(c)){
//                    firstOperand += c;
//                }
//                else if (!Character.isLetter(c) && !Character.isWhitespace(c)) {
//                    operator = c;
//                    firstOperandComplete = true;
//                }
//            }
//            else {
//                if (Character.isDigit(c)){
//                    secondOperand += c;
//                }
//            }
//        }
//
//        return new double[] {Integer.parseInt(firstOperand), Integer.parseInt(secondOperand)};
//    }

    /* Verifies whether the userInput is valid or not */
    public boolean checkInput(String userInput){

        if (userInput == null){
            // User has not input anything
            return false;
        }

        char[] operators = new char[] { '+', '-', '*', '/', 'q', 's'};

        // Cache string input to char array
        char[] inputChars = userInput.toCharArray();

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

}