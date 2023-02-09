import java.util.ArrayList;

public class BasicCalculator extends Calculator{
    public Double add(ArrayList<Double> operands) {
        double operand1 = operands.get(0);
        double operand2 = operands.get(1);
        return operand1 + operand2;
    }
    public double subtract(ArrayList<Double> operands) {
        double operand1 = operands.get(0);
        double operand2 = operands.get(1);
        return operand1 - operand2;
    }
    public double multiply(ArrayList<Double> operands) {
        double operand1 = operands.get(0);
        double operand2 = operands.get(1);
        return operand1 * operand2;
    }
    public double divide(ArrayList<Double> operands) {
        double operand1 = operands.get(0);
        double operand2 = operands.get(1);
        if (operand2 == 0) {
            System.out.println("undefined");
            return 0;
        } else {
            return operand1 / operand2;
        }
    }
}
