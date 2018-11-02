/*
 * file name: ExampleGUI.java
 * author: roland carter
 * date: 2018-09-10
 * purpose: calculate factorials unsing a gui
 */
package examplegui;

import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author rolandcarter
 */
public class ExampleGUI extends JFrame{
    
    private JPanel panel;
    private JLabel messageLabel;
    private JTextField value;
    private JButton calcButton;
    final int WINDOW_WIDTH = 350;
    final int WINDOW_HEIGHT = 250;

    public ExampleGUI() {
        setTitle("Calculate a factorial!");
        
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        createPanel();
        
        add(panel);
        
        setVisible(true);
        
    }
    
    public void createPanel(){
    
        messageLabel = new JLabel("Enter a value");
        
        value = new JTextField(10);
        
        
        calcButton = new JButton("Calculate");
        
        calcButton.addActionListener(new CalcButtonListener());
        
        panel = new JPanel();
        
        panel.add(messageLabel);
        panel.add(value);
        panel.add(calcButton);
        
        
    }

    
    private class CalcButtonListener implements ActionListener
    {
        public long factorial(int n) {
            if (n == 0) {
              return 1;
            }

            return n*factorial(n-1);
        }
        
        public void actionPerformed(ActionEvent e) {
        String valueInput;
        int valueInt;
        
        
        valueInput = value.getText();
        
        valueInt = Integer.parseInt(valueInput);
        
        JOptionPane.showMessageDialog(null, "Your answer is " + factorial(valueInt) + ".");
        
    }
    }
        
        
    public static void main(String[] args){
        new ExampleGUI();
}
    
  
}
