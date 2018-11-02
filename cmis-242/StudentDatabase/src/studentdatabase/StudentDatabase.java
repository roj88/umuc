/*
 * filename: StudentDatabase.java
 * author: roland carter
 * date: 2018-10-14
 * purpose: cmis 242 project 4
*/

package studentdatabase;

// import libraries
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.HashMap;

// begin StudentDatabase class
public class StudentDatabase implements ActionListener {
    // define JFrame variables
    private final JFrame jFrame;
    private final JPanel panel;
    private final JTextField studentId;
    private final JTextField studentName;
    private final JTextField studentMajor;
    private final JComboBox actionSelection;
    private final JButton processRequest;
    private final JLabel id;
    private final JLabel name;
    private final JLabel major;
    private final JLabel selection;
    private final JLabel blank;
    
    // window size constants
    final int WINDOW_WIDTH = 300;
    final int WINDOW_HEIGHT = 200;
    
    //combo box strings
    final String [] COMBO_BOX_ARRAY= {"Insert", "Delete", "Find", "Update"};
    final String [] LETTER_GRADES= {"A", "B", "C", "D", "F"};
    final Integer [] CREDIT_HOURS= {1, 2, 3, 4};
    
    // hashmap to hold student database
    private static HashMap<String, Student> studentDatabaseMap = new HashMap<String, Student>();
    private Student student = new Student(null, null);
    
    // StudentDatabase constructor
    public StudentDatabase() {
        // initialize button instance
        processRequest = new JButton("Process Request");
        
        // define and initialize combo box instances
        actionSelection = new JComboBox(COMBO_BOX_ARRAY);
        
        // initialize text field instance 
        studentId = new JTextField(10);
        studentName = new JTextField(10);
        studentMajor = new JTextField(10);
        
        // initialize JLabel
        id = new JLabel("Student Id");
        name = new JLabel("Student Name");
        major = new JLabel("Major");
        selection = new JLabel("Choose Selection");
        blank = new JLabel("");
        
        // add button action for listener
        processRequest.addActionListener(this);
        
        // create panel for JFrame and add elements
        panel = new JPanel();
        panel.add(id);
        panel.add(studentId);
        panel.add(name);
        panel.add(studentName);
        panel.add(major);
        panel.add(studentMajor);
        panel.add(selection);
        panel.add(actionSelection);
        panel.add(processRequest);
        panel.add(blank);
        
        // set up JFrame
        jFrame = new JFrame();
        jFrame.add(panel);
        panel.setLayout(new GridLayout(5, 2));
        jFrame.setTitle("Project 4");
        jFrame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	jFrame.setVisible(true);
    }
    
    @Override
    // add functionality to listener for each entry in the combo box
    // also, making each actionSelected into a method for readability
    public void actionPerformed(ActionEvent e){
        
        if (actionSelection.getSelectedItem().equals("Insert")){
            insertSelected(studentId, studentName, studentMajor);
        }
        
        else if (actionSelection.getSelectedItem().equals("Delete")){
            deleteSelected(studentId, studentName, studentMajor);
        }
        
        else if (actionSelection.getSelectedItem().equals("Find")){
            findSelected(studentId, studentName, studentMajor);
        }
        
        else if (actionSelection.getSelectedItem().equals("Update")){
            updateSelected(studentId, studentName, studentMajor);
        }
    }
    
    // isBlank checks to see if a text field is blank or not
    public Boolean isBlank(JTextField field) {
        return field.getText().equals("");
    }
    
    // askForCreditsPane creates a question pane when someone wants to update
    // an entry. this method is created to make the code a bit cleaner
    public Integer askForCreditsPane (Integer[] credits){
        return (Integer) JOptionPane.showInputDialog(null, "Choose Credits", "Credit", 
                JOptionPane.QUESTION_MESSAGE, null, credits, credits[0]);
    }
    
    // askForGradePane creates a question pane when someone wants to update
    // an entry. this method is created to make the code a bit cleaner
    public String askForGradePane (String[] grade){
        return (String) JOptionPane.showInputDialog(null, "Choose Grade", "Grade", 
                JOptionPane.QUESTION_MESSAGE, null, grade, grade[0]);
    }
    
    // insertSelected performs an insertion into the student database
    // when "Insert" is selected in the combo box
    public void insertSelected(JTextField studentId, JTextField studentName, JTextField studentMajor){
        // if id already exists in the hashmap return an
        // error message 
        if(studentDatabaseMap.containsKey(studentId.getText())) {
            JOptionPane.showMessageDialog(null, "Error: This ID already exists. Please enter an ID that is not already in the database");
        }
        // blank fields error
        else if(isBlank(studentId) || isBlank(studentName) || isBlank(studentMajor)){
            JOptionPane.showMessageDialog(null, "Error: Fields cannot be blank.");
        }
        else {
            // create new student instance and place into hashmap
            Student student = new Student(studentName.getText(), studentMajor.getText());
            studentDatabaseMap.put(studentId.getText(), student);
            
            // show message for success
            JOptionPane.showMessageDialog(null, "Student successfully added.");
        }
    }
    
    // deleteSelected performs a deletion from the student database
    // when "Delete" is selected in the combo box
    public void deleteSelected(JTextField studentId, JTextField studentName, JTextField studentMajor){
        // if id already exists in the hashmap return an
        // error message 
        if(!studentDatabaseMap.containsKey(studentId.getText())) {
            JOptionPane.showMessageDialog(null, "Error: This ID is not present in the database.");
        }
        // blank fields error
        else if(isBlank(studentId) || isBlank(studentName) || isBlank(studentMajor)){
            JOptionPane.showMessageDialog(null, "Error: Fields cannot be blank.");
        }
        else{
            // remove entry from database
            studentDatabaseMap.remove(studentId.getText());
            
            // show message for success
            JOptionPane.showMessageDialog(null, "Student successfully removed.");
        }
        
    }

    // findSelected finds an id in the student database
    // when "Find" is selected in the combo box
    public void findSelected(JTextField studentId, JTextField studentName, JTextField studentMajor){
        // if id already exists in the hashmap return an
        // error message 
        if(!studentDatabaseMap.containsKey(studentId.getText())) {
            JOptionPane.showMessageDialog(null, "Error: This ID is not present in the database.");
        }
        // blank fields error
        else if(isBlank(studentId) || isBlank(studentName) || isBlank(studentMajor)){
            JOptionPane.showMessageDialog(null, "Error: Fields cannot be blank.");
        }
        else {
            
            // retrieve Student instance and return toString() method
            JOptionPane.showMessageDialog(null, 
                    String.format("The information for this student is the following:\n%s",
                            studentDatabaseMap.get(studentId.getText()).toString()));
        }
    }

    // updateSelected updates an entry in the student database
    // when "Update" is selected in the combo box
    public void updateSelected(JTextField studentId, JTextField studentName, JTextField studentMajor){
        // if id already exists in the hashmap return an
        // error message 
        if(!studentDatabaseMap.containsKey(studentId.getText())) {
            JOptionPane.showMessageDialog(null, "Error: This ID is not present in the database.");
        }
        // blank fields error
        else if(isBlank(studentId) || isBlank(studentName) || isBlank(studentMajor)){
            JOptionPane.showMessageDialog(null, "Error: Fields cannot be blank.");
        }
        else {
                // create new student instance and place into hashmap
                student = studentDatabaseMap.get(studentId.getText());

                // get grades and credits from user input panes
                String getGrades = askForGradePane(LETTER_GRADES);
                Integer getCredits = askForCreditsPane(CREDIT_HOURS);

                // if input is null (and thus cancelled), show dialogue
                if(getGrades == null || getCredits == null){
                    JOptionPane.showMessageDialog(null, "No entry. Update cancelled.");
                }
                else {
                    // update input in database
                    student.courseCompleted(getGrades, getCredits);

                    JOptionPane.showMessageDialog(null, "Database update successfully completed.");
                }
            } 
    }
    
    public static void main(String[] args) {
        new StudentDatabase();
    }
    
} // end StudentDatabase class
