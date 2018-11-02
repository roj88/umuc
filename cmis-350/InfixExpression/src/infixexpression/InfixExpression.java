/*
 * filename: InfixExpression.java
 * author: roland carter
 * date: 2018-11-01
 * purpose: cmis 350 project 1
*/

package infixexpression;

// import libraries
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

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
        
        JOptionPane.showMessageDialog(null, "Your answer is " + valueInput + ".");
        
    }
    
    public static void main(String[] args) {
        new InfixExpression();
    }
    
}
