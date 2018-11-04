/*
 * filename: InfixExpression.java
 * author: roland carter
 * date: 2018-11-01
 * purpose: cmsc 350 project 1
*/

package infixexpression;

// import libraries
import java.awt.*;
import java.awt.event.*;
import java.util.EmptyStackException;
import javax.swing.*;


// InfixExpression creates a GUI and uses InfixExpressionEval to
// calculate an infix expression
public class InfixExpression implements ActionListener {
    // define JFrame variables
    private final JFrame jFrame;
    private final JPanel panel;
    private final JTextField userInput;
    private final JTextField result;
    private final JButton evaluate;
    private final JLabel userInputLabel;
    private final JLabel resultLabel;
    private final JLabel blank;
    
    // window size constants
    final int WINDOW_WIDTH = 400;
    final int WINDOW_HEIGHT = 200;
    
    public InfixExpression() {
        // initialize button instance
        evaluate = new JButton("Evaluate");
        
        // initialize text field instance 
        userInput = new JTextField(10);
        result = new JTextField(10);
        
        // make results text box read-only
        result.setEditable(false);
        
        // initialize JLabel
        userInputLabel = new JLabel("Enter Infix Expression");
        resultLabel = new JLabel("Result");
        blank = new JLabel("");
        
        // add button action for listener
        evaluate.addActionListener(this);
        
        // create panel for JFrame and add elements
        panel = new JPanel();
        panel.add(userInputLabel);
        panel.add(userInput);
        panel.add(blank);
        panel.add(evaluate);
        panel.add(resultLabel);
        panel.add(result);
        
        // set up JFrame
        jFrame = new JFrame();
        jFrame.add(panel);
        panel.setLayout(new GridLayout(4, 2));
        jFrame.setTitle("Enter Infix Evaluator");
        jFrame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	jFrame.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        String valueInput;
        
        valueInput = userInput.getText();
        
        try {
            result.setText("" + InfixExpressionEval.infixEvaluation(valueInput));
        } 
        catch (CatchErrors e1) {
            JOptionPane.showMessageDialog(null, e1.getMessage());
        } 
        catch (DivideByZero e2) {
            JOptionPane.showMessageDialog(null, e2.getMessage());
        }
        catch (EmptyStackException e3) {
            JOptionPane.showMessageDialog(null, "Please enter a valid expression.");
        }
    }
    
    // begin main method
    public static void main(String[] args) {
        new InfixExpression();
    }
    
} // end InfixExpression class

// (2 + 3 * 5) -8/5*(5-2)