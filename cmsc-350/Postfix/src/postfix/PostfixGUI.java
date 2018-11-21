/*
 * filename: PostfixGUI.java
 * author: roland carter
 * date: 2018-11-17
 * purpuse: project 2 cmsc 250
*/
package postfix;

// import libraries
import java.awt.*;
import java.awt.event.*;
import java.util.EmptyStackException;
import javax.swing.*;

// begin PostfixGUI
public class PostfixGUI implements ActionListener {
    // declare JFrame variables
    private JFrame jFrame;
    private JPanel panel;
    private JTextField postfix;
    private JTextField infix;
    private JButton evaluate;
    private JLabel infixLabel;
    private JLabel postfixLabel;
    private JLabel blank;
    
    // window final variables
    private final int WINDOW_WIDTH = 400;
    private final int WINDOW_HEIGHT = 250;
    
    // jFrame constructor
    public PostfixGUI (){
        // initialize button instance
        evaluate = new JButton("Construct Tree");
        
        // initialize text field instance 
        postfix = new JTextField(10);
        infix = new JTextField(10);
        
        // make results text box read-only
        infix.setEditable(false);
        
        // initialize JLabel
        infixLabel = new JLabel("Infix Expression");
        postfixLabel = new JLabel("Enter Postfix Expression");
        blank = new JLabel("");
        
        // add button action for listener
        evaluate.addActionListener(this);
        
        // create panel for JFrame and add elements
        panel = new JPanel();
        panel.add(postfixLabel);
        panel.add(postfix);
        panel.add(blank);
        panel.add(evaluate);
        panel.add(infixLabel);
        panel.add(infix);
        
        // set up JFrame
        jFrame = new JFrame();
        jFrame.add(panel);
        panel.setLayout(new GridLayout(4, 2));
        jFrame.setTitle("Three Address Generator");
        jFrame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	jFrame.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        // get text input
        String valueInput = postfix.getText();
        
        try {
            // use evaluate() method to return infix text and write
            // evaluation steps to file
            infix.setText(Evaluation.evaluate(valueInput));
        } 
        catch (InvalidToken e1) {
            JOptionPane.showMessageDialog(null, e1.getMessage());
        }
        catch (CatchErrors e2) {
            JOptionPane.showMessageDialog(null, e2.getMessage());
        }
        catch (EmptyStackException e3) {
            JOptionPane.showMessageDialog(null, "Please enter a valid expression.");
        }
    }

    // begin main method
    public static void main(String[] args) {
        new PostfixGUI ();
    }
    
} // end PostfixGUI
