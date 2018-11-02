/*
 * filename: PellNumberGUI.java
 * author: roland carter
 * date: 2018-09-26
 * purpose: project 3. this class creates a gui for pell numbers
 */

package recursion;

// import libraries
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import java.io.BufferedWriter;


// begin PellNumberGUI class
public class PellNumberGUI implements ActionListener {
    
    // define JFrame variables
    private final JFrame jFrame;
    private final JPanel panel;
    private final JTextField userInputValue;
    private final JTextField resultsOutput;
    private final JTextField efficiencyOutput;
    private final JButton computationButton;
    private final JRadioButton iterativeRadioButton;
    private final JRadioButton recursiveRadioButton;
    private final JLabel computeButton;
    private final JLabel enterN;
    private final JLabel result;
    private final JLabel efficiency;
    
    // variables to hold output
    private int pellNumberResult;
    private int pellNumberefficiency;
    
    // window size constants
    final int WINDOW_WIDTH = 300;
    final int WINDOW_HEIGHT = 200;
        
    // file path
    final String FILE_PATH = "/Users/roland/repos/umuc/cmis-242/Recursion/src/recursion/data.csv";
    
    // method PellNumberGUI defines variables for the gui
    public PellNumberGUI() {
        // initialize button instances
        computationButton = new JButton("Compute");
        
        // initialize radio button instances
        iterativeRadioButton = new JRadioButton("Iterate");
        recursiveRadioButton = new JRadioButton("Recursive");
        iterativeRadioButton.setSelected(true); // make iterative button default
        
        // initialize text field instance 
        userInputValue = new JTextField(10);
        resultsOutput = new JTextField(10);
        resultsOutput.setEditable(false);
        efficiencyOutput = new JTextField(10);
        efficiencyOutput.setEditable(false);
        
        // initialize JLabel
        computeButton = new JLabel("");
        enterN = new JLabel("Enter n");
        result = new JLabel("Results");
        efficiency = new JLabel("Efficiency");
        
        // group radio buttons
        ButtonGroup group = new ButtonGroup();
        group.add(iterativeRadioButton);
        group.add(recursiveRadioButton);
        
        // add actions for listener
        computationButton.addActionListener(this);
        
        // create panel for JFrame and add elements
        panel = new JPanel();
        panel.add(iterativeRadioButton);
        panel.add(recursiveRadioButton);
        panel.add(enterN);
        panel.add(userInputValue);
        panel.add(computeButton);
        panel.add(computationButton);
        panel.add(result);
        panel.add(resultsOutput);
        panel.add(efficiency);
        panel.add(efficiencyOutput);
        
        // set up JFrame
        jFrame = new JFrame();
        jFrame.add(panel);
        panel.setLayout(new GridLayout(5, 2));
        jFrame.setTitle("Pell Numbers");
        jFrame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	jFrame.setVisible(true);
        
    }
    
    @Override
    // add functionality to pell number gui
    public void actionPerformed(ActionEvent e){
        
        // control structure to perform action based on clicked button
        if(iterativeRadioButton.isSelected()){
            // define input variables
            String valueInput;
            int valueInt;
            
            // try-catch block to raise exceptions
            try {

                // grab text from the text field
                valueInput = userInputValue.getText();
                
                // make text input double
                valueInt = Integer.parseInt(valueInput);

                // call Sequence class methods
                pellNumberResult = Sequence.computeIterative(valueInt);
                pellNumberefficiency = Sequence.getEfficiency();

                // set outputs
                resultsOutput.setText(Integer.toString(pellNumberResult));
                efficiencyOutput.setText(Integer.toString(pellNumberefficiency));

                // display output
                JOptionPane.showMessageDialog(null, "Press ok to close output box");
                
                /*
                ** write data to file
                */
                
                // delete file if it exists
                Files.deleteIfExists(Paths.get(FILE_PATH)); 
                
                // create new file from the file path
                File file = new File(FILE_PATH);
                
                // create new file write
                FileWriter fw = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fw);
                
                // iterate through each n-term
                // and write to file
                for(int i=0; i <= valueInt; i++){
                    // create data string
                    String data = i + "," + Sequence.computeIterative(i) + "," + Sequence.getEfficiency();
                    
                    // write data to csv and add new line
                    bw.write(data);
                    bw.newLine();
                }

                // close writer connection 
                bw.close(); 
                
                // output writer
                System.out.println("File written Successfully");
            }
            catch(NumberFormatException e0){
                JOptionPane.showMessageDialog(null, "Please enter a proper number format");
            } catch (IOException ex) {
                Logger.getLogger(PellNumberGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(recursiveRadioButton.isSelected()){
            // define input variables
            String valueInput;
            int valueInt;
            
            // try-catch block to raise  exceptions
            try {
            
                // grab text from the text field
                valueInput = userInputValue.getText();
                
                // make text input double
                valueInt = Integer.parseInt(valueInput);

                // call Sequence class methods
                pellNumberResult = Sequence.computeRecursive(valueInt);
                pellNumberefficiency = Sequence.getEfficiency();

                // set outputs
                resultsOutput.setText(Integer.toString(pellNumberResult));
                efficiencyOutput.setText(Integer.toString(pellNumberefficiency));

                // display output
                JOptionPane.showMessageDialog(null, "Press ok to close output box");

                 /*
                ** write data to file
                */
                
                // delete file if it exists
                Files.deleteIfExists(Paths.get(FILE_PATH)); 
                 
                // create new file from the file path
                File file = new File(FILE_PATH);
                
                // create new file write
                FileWriter fw = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fw);
                
                // iterate through each n-term
                // and write to file
                for(int i=0; i <= valueInt; i++){
                    // create data string
                    String data =  i + "," + Sequence.computeRecursive(i) + "," + Sequence.getEfficiency();
                    
                    // write data to csv and add new line
                    bw.write(data);
                    bw.newLine();
                }

                // close writer connection 
                bw.close(); 
                
                // output writer
                System.out.println("File written Successfully");
            }
            catch(NumberFormatException e0){
                JOptionPane.showMessageDialog(null, "Please enter a proper number format");
            } catch (IOException ex) {
                Logger.getLogger(PellNumberGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    // main method creates and runs an instance of the gui
    public static void main(String[] args) {
        new PellNumberGUI();
    } // end main method

} // end class PellNumberGUI
