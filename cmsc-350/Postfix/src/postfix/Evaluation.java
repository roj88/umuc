/*
 * filename: Evaluation.java
 * author: roland carter
 * date: 2018-11-17
 * purpuse: project 2 cmsc 250
*/

package postfix;

// import libraries
import java.util.Stack;
import java.util.StringTokenizer;

// begin class Evaluation
public class Evaluation {
    // variables
    private static Stack<Node> expressionStack = new Stack<>();
    private static Node operator;  
    
    // static method evaluate takes an expression and creates a data.txt output
    // and infix expression from a postfix expression
    public static String evaluate(String expression) throws InvalidToken, CatchErrors {
        // take string an tokenize it into an array
        StringTokenizer expressionTokenized = new StringTokenizer(expression, "()*/+- ", true);
            
        // throws error if there is no input
        if(expression.equals("")) {
            throw new CatchErrors("Please enter postfix expression.");
        }
        
        // throws error if there is no operand
        if(!expression.matches(".*\\d+.*")) {
            throw new CatchErrors("Please enter an expression with an operand.");
        }
        
        // evaluate while statement until no more tokens are left
        while(expressionTokenized.hasMoreTokens()){
            // grab next token
            String token = expressionTokenized.nextToken();

            // throws error if an invalid token is present
            if (!isOperand(token) && !isOperator(token) && !token.equals(" ")) {
                throw new InvalidToken("Illegal character present.");
            }
            
            // push operand expressions to a stack and removes " "
            if(isOperand(token)) {
                if(!token.equals(" ")){
                    expressionStack.push(new Operands(token));
                }
            }
            // push operator expressions to stack and removes " "
            else if(isOperator(token)) {
                if(!token.equals(" ")){
                    operator = new Operators(token, expressionStack.pop(), expressionStack.pop());
                    expressionStack.push(operator);
                }
            }
        }
        operator.post();
        
        // return 
        return expressionStack.pop().inWalk();
    
    }
    
    // isOperator checks if a value is an operator and returns a bool    
    private static boolean isOperator(String value) {
        return value.equals("+") || value.equals("-")|| value.equals("*") || value.equals("/");
    }
    
    // isOperand checks if a value is an operand and returns a bool    
    private static boolean isOperand(String value) {
        return value.matches("[0-9]+");
    }
}
