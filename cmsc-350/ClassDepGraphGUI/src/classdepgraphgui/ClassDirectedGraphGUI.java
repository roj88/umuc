/*
 * filename: ClassDirectedGraphGUI.java
 * author: roland carter
 * date: 2018-12-15
 * purpose: ClassDirectedGraphGUI builds a GUI in order to use the 
 *          DirectedGraph class 
*/

package classdepgraphgui;


// import libraries
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;


// begin ClassDirectedGraphGUI class
public class ClassDirectedGraphGUI implements ActionListener {
    // declare JFrame variables
    private JFrame jFrame;
    private JPanel panel;
    private JPanel panelMain;
    private JPanel panelTextArea;
    private JTextField inputFile;
    private JTextField inputClass;
    private JButton buildDirectedGraphButton;
    private JButton topologicalOrderButton;
    private JLabel inputFileLabel;
    private JLabel inputClassLabel;
    private JTextArea output;
    
    // window final variables
    private final int WINDOW_WIDTH = 500;
    private final int WINDOW_HEIGHT = 250;

    // define variables
    private String file;
    private String className;
    private DirectedGraph<String> directedGraph;
    
    // jFrame constructor
    ClassDirectedGraphGUI() {
        // initialize button instances
        buildDirectedGraphButton = new JButton("Build Directed Graph");
        topologicalOrderButton = new JButton("Topological Order");
        
        // initialize text field instances 
        inputFile = new JTextField(20);
        inputClass = new JTextField(20);
        
        // initialize label instances
        inputFileLabel = new JLabel("Input file name:");
        inputClassLabel = new JLabel("Class to recompile:");
        
        // Initialize text area and add scroll
        output = new JTextArea(500, 10);
        JScrollPane scrollPane = new JScrollPane(output); 
        output.setEditable(false);
        
        // add actions for listener
        buildDirectedGraphButton.addActionListener(this);
        topologicalOrderButton.addActionListener(this);
        
        
        // create panel for JFrame and add elements
        panel = new JPanel();
        panel.add(inputFileLabel);
        panel.add(inputFile);
        panel.add(buildDirectedGraphButton);
        panel.add(inputClassLabel);
        panel.add(inputClass);
        panel.add(topologicalOrderButton);
        
        panelTextArea = new JPanel();
        panelTextArea.add(output);
        
        panelMain = new JPanel();
        panelMain.setLayout(new GridLayout(2, 2));
        
        // set up JFrame
        jFrame = new JFrame();
        panelMain.add(panel);
        panelMain.add(panelTextArea);
        jFrame.add(panelMain);
        panel.setLayout(new GridLayout(2, 3));
        panelTextArea.setLayout(new GridLayout(1, 1));
        jFrame.setTitle("Class Dependency Graph");
        jFrame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	jFrame.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        // if Build Directed Graph button is click
        if("Build Directed Graph".equals(e.getActionCommand())){ 
            
            // create new DirectedGraph instance
            directedGraph = new DirectedGraph<>();
            file = inputFile.getText();

            try {
                // make sure fileName isn't empty
                if(file.isEmpty()){
                    throw new NullPointerException();
                }

                // build dependency graph from a file
                directedGraph.createDirectedGraphFromFile(
                        directedGraph.fileIntoTokens(file)
                );

                // show dialogue message when graph built
                JOptionPane.showMessageDialog(null, "Graph built successfully!");
            }
            catch (FileNotFoundException e1){
                JOptionPane.showMessageDialog(null,
                        String.format("File %s does not exist", file)
                );
            }
            catch (IOException e2){
                JOptionPane.showMessageDialog(null, e2.getMessage());
            }
            catch (NullPointerException e3){
                JOptionPane.showMessageDialog(null, "Enter an input.");
            }
        }
        
        // if Topological Order button is clicked
        if("Topological Order".equals(e.getActionCommand())){ 
            // get class name from input text
            className = inputClass.getText();

            try {
                // get Topological order and set it to the output
                output.setText(directedGraph.getTopologicalOrder(className));
            }
            catch (CatchErrors e4){
                JOptionPane.showMessageDialog(null, e4.getMessage());
            }
            catch (NullPointerException e5){
                JOptionPane.showMessageDialog(null, "Enter an input.");
            }
        }
    }
    
    // main method
    public static void main(String[] args) {
        new ClassDirectedGraphGUI();
    }
} // end ClassDirectedGraphGUI