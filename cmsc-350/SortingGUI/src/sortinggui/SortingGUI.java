/*
 * filename: SortingGUI.java
 * author: roland carter
 * date: 2018-11-30
 * purpose: SortingGUI class creates a gui to sort numeric inputs
*/

package sortinggui;

// import libraries
import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;


// begin SortingGUI class
public class SortingGUI implements ActionListener {
    // declare JFrame variables
    private JFrame jFrame;
    private JPanel panel;
    private JTextField originalList;
    private JTextField sortedList;
    private JButton performSort;
    private JRadioButton ascendingButton;
    private JRadioButton descendingButton;
    private JRadioButton integerButton;
    private JRadioButton fractionButton;
    private JLabel originalListLabel;
    private JLabel sortedListLabel;
    private JLabel blank;
    private JLabel sortOrderLabel;
    private JLabel numericTypeLabel;
    private ButtonGroup sortOrder;
    private ButtonGroup numericType;
    
    // window final variables
    private final int WINDOW_WIDTH = 400;
    private final int WINDOW_HEIGHT = 250;
    
    
    // jFrame constructor
    SortingGUI() {
        // initialize button instance
        performSort = new JButton("Perform Sort");
        
        // initialize text field instance 
        originalList = new JTextField(20);
        sortedList = new JTextField(20);
        
        // make results text box read-only
        sortedList.setEditable(false);
        
        // initialize JLabel
        originalListLabel = new JLabel("Original List:");
        sortedListLabel = new JLabel("Sorted List:");
        blank = new JLabel("");
        sortOrderLabel = new JLabel("Sort Order:");
        numericTypeLabel = new JLabel("Numertic Type:");
        
        // create radio buttons
        ascendingButton = new JRadioButton("Ascending", true);
        descendingButton = new JRadioButton("Descending");
        integerButton = new JRadioButton("Integer", true);
        fractionButton = new JRadioButton("Fraction");
        
        // add buttons to groups
        sortOrder = new ButtonGroup();
        numericType  = new ButtonGroup();
        sortOrder.add(ascendingButton);
        sortOrder.add(descendingButton);
        numericType.add(integerButton);
        numericType.add(fractionButton);
        
        // add button action for listener
        performSort.addActionListener(this);
        
        
        // create panel for JFrame and add elements
        panel = new JPanel();
        panel.add(originalListLabel);
        panel.add(originalList);
        panel.add(sortedListLabel);
        panel.add(sortedList);
        panel.add(blank);
        panel.add(performSort);
        panel.add(sortOrderLabel);
        panel.add(numericTypeLabel);
        panel.add(ascendingButton);
        panel.add(integerButton);
        panel.add(descendingButton);
        panel.add(fractionButton);
        
        // set defaults
        ascendingButton.setSelected(true);
        integerButton.setSelected(true);
        
        // set up JFrame
        jFrame = new JFrame();
        jFrame.add(panel);
        panel.setLayout(new GridLayout(6, 2));
        jFrame.setTitle("Binary Search Tree Sort");
        jFrame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	jFrame.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        // get text input
        String valueInput = originalList.getText();
        
        // string to place results in
        String result = null;
        
        
        try{
            // check if null
            if (valueInput == null) {
                throw new NullPointerException();
            }
            
            // split input into String array
            String[] inputTokens = valueInput.split(" ");
            
            // integers
            if(integerButton.isSelected()) {
                // create BinarySearchTree instance
                BinarySearchTree<Integer> bst = new BinarySearchTree<>();
                
                // insert each value
                for (String inputToken : inputTokens) {
                    bst.insert(Integer.parseInt(inputToken));
                }
                
                // use order methods to get results
                if(ascendingButton.isSelected()){
                    result = bst.getAscendingOrder();
                }
                else if(descendingButton.isSelected()){
                    result = bst.getDescendingOrder();
                }
            }
            
            // fractions
            else if(fractionButton.isSelected()){
                // create BinarySearchTree instance of type Fractions
                 BinarySearchTree<Fraction> bst = new BinarySearchTree<>();
                 
                // iterate through each fraction and insert it into bst
                for (String inputToken : inputTokens) {
                    Fraction fraction = new Fraction(inputToken);
                    bst.insert(fraction);
                }
                
                // use order methods to get results
                if(ascendingButton.isSelected()){
                    result = bst.getAscendingOrder();
                }
                else if(descendingButton.isSelected()){
                    result = bst.getDescendingOrder();
                }
            }
            // set sortedList to the results
            sortedList.setText(result);
        }
        catch (NullPointerException e1) {
            JOptionPane.showMessageDialog(null, "Please enter a list of numbers or fractions.");
        }
        catch (CatchErrors e2) {
            JOptionPane.showMessageDialog(null, e2.getMessage());
        } 
        catch (ParseException e3) {
            Logger.getLogger(SortingGUI.class.getName()).log(Level.SEVERE, null, e3);
        } 
        catch (NumberFormatException e4) {
            JOptionPane.showMessageDialog(null, "Please enter a list of numbers or fractions.");
        }
        
    }
    
    // main method
    public static void main(String[] args) {
        new SortingGUI();
    }
    
} // end SortingGUI class
// 1 2 3 54 6 23 75 32 2 3 1 4
// 4 8 2 1 23 16 8 16 3 14 2 10 24
// 1/2 3/54 6/23 75/32 2/3 1/4 1/4
// 1/2 3/4 3/2 5/8 4/9 7/16 5/32 1/8
// empty
// 1 2 3 54 6 23 75 32 2 3 1 4 e illegal character
// 1/2 3/54 6/23 75/32 illegal 2/3 1/4 1/4 illegal character
// 1/2 3/54/3 6/23 75/32/4 2/3 1/4 1/4 illformed fraction

