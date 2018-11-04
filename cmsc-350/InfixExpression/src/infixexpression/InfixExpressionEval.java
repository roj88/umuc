/*
 * filename: InfixExpressionEval.java
 * author: roland carter
 * date: 2018-11-01
 * purpose: cmsc 350 project 1
*/

package infixexpression;

// import libraries
import java.util.Stack;
import java.util.StringTokenizer;


// InfixExpressionEval evaluations infix expressions
public class InfixExpressionEval {
    
    // static stack variables
    private static Stack<String> operandStack;
    private static Stack<String> operatorStack;

    
    public static String infixEvaluation (String userInput) throws CatchErrors, DivideByZero {
        // remove whitespace from string
        userInput = userInput.replaceAll("\\s","");

        // throws error there is no input
        if(userInput.equals("")) {
            throw new CatchErrors("Please enter infix expression.");
        }
        
        // throws error if there is no operand
        if(!userInput.matches(".*\\d+.*")) {
            throw new CatchErrors("Please enter an expression with an operand.");
        }
        
        // declare operand and operator stacks
        Stack<String> operandStack = new Stack<String>();
        Stack<String> operatorStack = new Stack<String>();
        
        // take string an tokenize it into an array
        StringTokenizer userInputTokenized = new StringTokenizer(userInput, "()*/+-", true);
        
        // evaluate while statement until no more tokens are left
        while(userInputTokenized.hasMoreTokens()){
            
            // grab next token
            String token = userInputTokenized.nextToken();
            
            // throws error if illegal characters are in user input
            if(!token.matches("[0-9]+") &&
                    !token.equals("(") &&
                    !token.equals(")") &&
                    !isOperator(token)) {
                throw new CatchErrors("Input contains illegal character.");
            }
            
            // if token is an operand add it to operandStack
            if(token.matches("[0-9]+")) {
                operandStack.push(token);
            }
            
            // if token is a left parenthesis  add it to operatorStack
            else if(token.equals("(")) {
                operatorStack.push(token);
            }
            
            // if token is a right parenthesis  add it to operatorStack
            else if(token.equals(")")) {
                while(!operatorStack.peek().equals("(")) {
                    operandStack.push(stringToOperator(operatorStack.pop(), operandStack.pop(), operandStack.pop()));
                }
                
                operatorStack.pop();
            }
            
            // add operators operator stack
            else if(isOperator(token)){
                while(!operatorStack.empty() &&
                        operatorPrecedence(operatorStack.peek()) >= operatorPrecedence(token) &&
                        operandStack.size() > 1){
                    operandStack.push(stringToOperator(operatorStack.pop(), operandStack.pop(), operandStack.pop()));
                }
                // push operator to stack
                operatorStack.push(token);
            }
        }
        
        
        // while the operator stack is non empty, calculate operands
        while(!operatorStack.empty() && operandStack.size() > 1){
                    operandStack.push(stringToOperator(operatorStack.pop(), operandStack.pop(), operandStack.pop()));
        }
        
        
        // return the top of the stack which is the final calulation
        return operandStack.peek();
    }

    
    // stringToOperator converts string operators and opperands to calculations
    private static String stringToOperator(String operator, String operand2, String operand1) throws DivideByZero {
        int result = 0;
        int op2 = Integer.parseInt(operand2);
        int op1 = Integer.parseInt(operand1);
        
        switch (operator) {
            case "*":
                result = op1 * op2;
                break;
            case "/":
                if(op2 == 0) {
                throw new DivideByZero("Divide by zero error.");
                }
                result = op1 / op2;
                break;
            case "+":
                result = op1 + op2;
                break;
            case "-":
                result = op1 - op2;
                break;
            default:
                break;
        }
        
        return Integer.toString(result);
    }

    
    // operatorPrecedence converts operators to precedents
    private static int operatorPrecedence (String operator){
        int result = 0;
        
        if(operator.equals("+") || operator.equals("-")){
            result = 1;
        }
        else if(operator.equals("*") || operator.equals("/")){
            result = 2;
        }
        
        return result;
    }

    
    // isOperator checks if a value is an operator and returns a bool    
    private static boolean isOperator(String value) {
        return value.equals("+") || value.equals("-")|| value.equals("*") || value.equals("/");
    }

}
