public class LocalProgram{
    public static void main(String[] args) {
        System.out.println("Hello");
        Calculator calculator = new Calculator();
        String input = "2*3+12/4";
        System.out.println(input);
        calculator.parseInput(input);
    }
}