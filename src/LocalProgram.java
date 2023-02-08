public class LocalProgram{
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.setResultCacheCapacity(10);
        double[] input = new double[]{1, 2, 3, 4, 5};
        calculator.storeResult(2);
        calculator.storeResult(3);
        calculator.storeResult(4);
        calculator.storeResult(5);
        calculator.storeResult(6);

        System.out.println(calculator.cycleToPreviousResult());
        System.out.println(calculator.cycleToPreviousResult());
        System.out.println(calculator.cycleToPreviousResult());
        System.out.println(calculator.cycleToPreviousResult());
        System.out.println(calculator.cycleToPreviousResult());
        System.out.println(calculator.cycleToNextResult());
        System.out.println(calculator.cycleToNextResult());
        System.out.println(calculator.getLastResult());
        System.out.println(calculator.cycleToNextResult());
        System.out.println(calculator.cycleToNextResult());
        System.out.println(calculator.cycleToNextResult());
    }
}