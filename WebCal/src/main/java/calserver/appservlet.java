package calserver;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class appservlet
 */
@WebServlet("/appservlet")
public class appservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /*
     * Default constructor. 
     */
    public appservlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Calculator cal = new Calculator();
		cal.setResultCacheCapacity(10);
//		PrintWriter pw = response.getWriter();
		String s = request.getParameter("answer");
		s = s.replace("sqrt", "?");
		if (checkInput(s)) {
				double result = evaluate(parseInput(s));
				cal.storeResult(result);
				request.setAttribute("result",cal.getLastResult());
				
			}
			getServletContext().getRequestDispatcher("/index.jsp").forward(request,response);
//			pw.println(s);
			
		}
		//string output from the front page(ex:"7+5"). parse and do your operations
		
	
		
		
       
//        System.out.println("Result: " + result);
//        request.setAttribute("result",result);
//        getServletContext().getRequestDispatcher("/index.jsp").forward(request,response);
        
//		pw.println("<h1>"+result);
//		pw.close();
		
		
		
	



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public ArrayList<String> parseInput(String userInput){
        char[] operatorPrecedence = new char[]{'+', '-', '*', '/', 'p', 'q', '!'};
        String precedenceString = new String(operatorPrecedence);
        Stack<Character> operatorStack = new Stack<>();
        Queue<String> outputQueue = new LinkedList<>();

        char[] inputChars = userInput.toCharArray();

        StringBuilder operand = new StringBuilder();
        boolean stringStarted = false;
        boolean powerSpecial = false;
        boolean factorialSpecial = false;
        for (char c : inputChars) {
            if (Character.isDigit(c)) {
                if (powerSpecial && c == '2'){
                    powerSpecial = false;
                    stringStarted = false;
                    outputQueue.add(operand.toString());
                    operand.delete(0, operand.length());
                }
                else if (factorialSpecial && c == '!'){
                    factorialSpecial = false;
                    stringStarted = false;
                    outputQueue.add(operand.toString());
                    operand.delete(0, operand.length());
                }
                else {
                    operand.append(c);
                    stringStarted = true;
                }
            } else {
                // If Char is decimal add to operand string
                if (c == '.' && stringStarted) {
                    operand.append(c);
                    continue;
                }

                // If char is '?' add to operand string
                // Represents square root
                if (c == '?' && !stringStarted){
                    stringStarted = true;
                    c = 'q';
                    operand.append(c);
                    continue;
                }

                // If char is '^' add to operand string
                // Represents square
                if (c == '^' && stringStarted){
                    powerSpecial = true;
                    c = 'p';
                    operand.append(c);
                    continue;
                }

                // If char is '!' add to operand string
                if (c == '!' && stringStarted){
                    factorialSpecial = true;
                    operand.append(c);
                    continue;
                }

                // If operand string has been started and the
                // char is an operator complete string and add
                // to the output queue
                if (stringStarted) {
                    stringStarted = false;
                    outputQueue.add(operand.toString());
                    operand.delete(0, operand.length());
                }

                if (!operatorStack.isEmpty())
                    System.out.println(precedenceString.indexOf(c) <= precedenceString.indexOf(operatorStack.peek()));
                while (!operatorStack.isEmpty() &&
                        precedenceString.indexOf(c) <= precedenceString.indexOf(operatorStack.peek())) {
                    outputQueue.add(String.valueOf(operatorStack.pop()));
                }

                operatorStack.push(c);
            }
        }
        outputQueue.add(operand.toString());
        while (!operatorStack.isEmpty()){
            outputQueue.add(String.valueOf(operatorStack.pop()));
        }

        return new ArrayList<>(outputQueue);
    }
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

    public double evaluate(ArrayList<String> rpnInput){
//      { '+', '-', '*', '/', 'q', 's'};
      Stack<Double> output = new Stack<>();
      BasicCalculator basicCalculator = new BasicCalculator();
      UnaryCalculator unaryCalculator = new UnaryCalculator();
      for (String s : rpnInput){
          if (s.length() == 1){
              char operator = s.toCharArray()[0];
              if (!Character.isDigit(operator)){

                  ArrayList<Double> outputArr = new ArrayList<>();
                  double operand1;
                  double operand2;
                  switch (operator){
                      case '+':

                          outputArr.add(output.pop());
                          outputArr.add(output.pop());
                          output.push(basicCalculator.add(outputArr));

                          break;
                      case '-':

                          operand2 = output.pop();
                          operand1 = output.pop();
                          outputArr.add(operand1);
                          outputArr.add(operand2);
                          output.push(basicCalculator.subtract(outputArr));

                          break;
                      case '*':

                          outputArr.add(output.pop());
                          outputArr.add(output.pop());
                          output.push(basicCalculator.multiply(outputArr));

                          break;
                      case '/':

                          operand2 = output.pop();
                          operand1 = output.pop();
                          outputArr.add(operand1);
                          outputArr.add(operand2);
                          output.push(basicCalculator.divide(outputArr));

                          break;
                  }
                  outputArr.clear();
              }
              else{
                  output.push(Double.valueOf(s));
              }
          }
          else if (s.length() > 1) {
              if (s.toCharArray()[0] == 'q'){
                  char[] squareRootString = s.toCharArray();
                  StringBuilder builder = new StringBuilder();
                  for (int i = 1; i < squareRootString.length; i++){
                      builder.append(squareRootString[i]);
                  }
                  ArrayList<Double> sqDub = new ArrayList<>();
                  sqDub.add(Double.valueOf(builder.toString()));
                  output.push(unaryCalculator.squareRoot(sqDub));
              }
              else if (s.toCharArray()[s.toCharArray().length - 1] == 'p'){
                  char[] powerArr = s.toCharArray();
                  StringBuilder builder = new StringBuilder();
                  for (int i = 0; i < powerArr.length - 1; i++){
                      builder.append(powerArr[i]);
                  }
                  ArrayList<Double> pDub = new ArrayList<>();
                  pDub.add(Double.valueOf(builder.toString()));
                  output.push(unaryCalculator.square(pDub));
              }
              else if (s.toCharArray()[s.toCharArray().length - 1] == '!'){
                  char[] factArr = s.toCharArray();
                  StringBuilder builder = new StringBuilder();
                  for (int i = 0; i < factArr.length - 1; i++){
                      builder.append(factArr[i]);
                  }
                  ArrayList<Double> fDub = new ArrayList<>();
                  fDub.add(Double.valueOf(builder.toString()));
                  output.push(unaryCalculator.factorial(fDub));
              }
              else {
                  output.push(Double.valueOf(s));
              }
          }

      }
      return output.get(0);
  }

}
