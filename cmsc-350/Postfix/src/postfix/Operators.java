/*
 * filename: Operators.java
 * author: roland carter
 * date: 2018-11-17
 * purpuse: project 2 cmsc 350
*/

package postfix;

// import libraries
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Operators implements Node {

    // variables
    private String operator;
    private Node right;
    private Node left;
    
    // i is static in order to preserve the step as new instances are created
    private static int i;
    
    // constructor
    public Operators(String operator, Node right, Node left) {
        this.operator = operator;
        this.right = right;
        this.left = left;
    }
    
    // postWalk walks the tree in post order
    @Override
    public String postWalk() {
        String opEvalValue = operatorEvaluation(this.operator);
        String leftVal = left.postWalk();
        String rightVal = right.postWalk();

        // this is used to create Rx steps in dats.txt file
        String result = "R" + i++;

        // Creates string with a step in the expression then writes to file
        String step = opEvalValue + " " + result + " " + leftVal + " " + rightVal;
        try {
            WriteFile.writeToFile(step);
        } catch (IOException ex) {
            Logger.getLogger(Operators.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result;
    }
    
    // operatorEval converts operator strings into operator words
    private String operatorEvaluation(String operator) {
        String operatorText = null;

        switch (operator) {
            case "*":
                operatorText = "Mul";
                break;
            case "/":
                operatorText = "Div";
                break;
            case "+":
                operatorText = "Add";
                break;
            case "-":
                operatorText = "Sub";
                break;
        }

        return operatorText;
    }
    
    // inWalk creates an infix string
    public String inWalk() {
        return "(" + left.inWalk() + " " + operator + " " + right.inWalk() + ")";
    }
    
    // post is abstract helper
    public void post() {
        i = 0;
        postWalk();    // starts the walk
    }
}
