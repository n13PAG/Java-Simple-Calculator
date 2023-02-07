import java.util.ArrayList;

public class UnaryCalculator extends Calculator{
    
    // Returns the value (type double) of the first operand inputted squared
    public double square(ArrayList<Double> operands){
        double operand = operands.get(0);
        return operand * operand;
    }

    //Returns the square root (type double) value of the first operand
    public double squareRoot(ArrayList<Double> operands){
        double operand = operands.get(0);

        return Math.sqrt(operand);
    }

    //Returns the Factorial (type double) value of the first operand
    public double factorial(ArrayList<Double> operands){
        double operand = operands.get(0);
        double result = 1;
        for(int i= 2; i<=operand;i++){
            result *=i;
        }
        return result;
    }
}
