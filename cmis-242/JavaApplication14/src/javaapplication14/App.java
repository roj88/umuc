/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication14;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.HashMap;

/**
 * File: App.java
 * Author: William Crutchfield
 * Date: March 3, 2017
 * Description: This program will Add, Delete, Update, and Find Student Records in a Database.
 */
public class App extends JFrame {

    // Variables
    private String id;
    private String name;
    private String major;
    private String selection;

    /**
     * Constructs GUI for the program and handles ActionListeners
     */
    private App() {
        // Set Title
        super("Project 4");

        // Create Main Panel
        JPanel main = new JPanel();

        // Set Layout for Main Panel
        main.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        // Create Labels
        JLabel idLabel = new JLabel("Id:");
        JLabel nameLabel = new JLabel("Name:");
        JLabel majorLabel = new JLabel("Major:");
        JLabel selectLabel = new JLabel("Choose Selection:");

        // Create Text Fields
        JTextField idTxt = new JTextField(null);
        JTextField nameTxt = new JTextField(null);
        JTextField majorTxt = new JTextField(null);

        // Create Button
        JButton processBtn = new JButton("Process Request");

        // Create ComboBoxes
        String[] selectStr = { "Insert", "Delete", "Find", "Update" };
        JComboBox<String> selectCombo = new JComboBox<>(selectStr);
        String[] gradeStr = { "A", "B", "C", "D", "F" };
        String[] creditStr = { "3", "6" };

        // Create HashMap
        HashMap<String, Student> studentDb = new HashMap<>();

        // Add Components
        c.fill = GridBagConstraints.HORIZONTAL;

        // Add idLabel
        c.insets = new Insets(0,0,5,5);
        c.gridx = 0;
        c.gridy = 0;
        main.add(idLabel, c);

        // Add idTxt
        c.insets = new Insets(0,5,5,0);
        c.gridx = 1;
        c.gridy = 0;
        main.add(idTxt, c);

        // Add nameLabel
        c.insets = new Insets(5,0,5,5);
        c.gridx = 0;
        c.gridy = 1;
        main.add(nameLabel, c);

        // Add nameTxt
        c.insets = new Insets(5,5,5,0);
        c.gridx = 1;
        c.gridy = 1;
        main.add(nameTxt, c);

        // Add majorLabel
        c.insets = new Insets(5,0,5,5);
        c.gridx = 0;
        c.gridy = 2;
        main.add(majorLabel, c);

        // Add majorTxt
        c.insets = new Insets(5,5,5,0);
        c.gridx = 1;
        c.gridy = 2;
        main.add(majorTxt, c);

        // Add selectLabel
        c.insets = new Insets(5,0,5,5);
        c.gridx = 0;
        c.gridy = 3;
        main.add(selectLabel, c);

        // Add selectCombo
        c.insets = new Insets(5,5,5,0);
        c.gridx = 1;
        c.gridy = 3;
        main.add(selectCombo, c);

        // Add processBtn
        c.insets = new Insets(5,0,0,5);
        c.gridx = 0;
        c.gridy = 4;
        main.add(processBtn, c);

        // Add Main Panel
        add(main);

        //Process Button Event Handlers
        processBtn.addActionListener((ActionEvent e) -> {
            // Assigns JTextFields to variables
            id = idTxt.getText();
            name = nameTxt.getText();
            major = majorTxt.getText();
            selection = selectCombo.getSelectedItem().toString();

            try {
                // Throws NullPointerException if any JTextField is Empty
                if (id.isEmpty()) {
                    throw new NullPointerException();
                } else {
                    // ComboBox Selection Switch (Determines action performed on studentDb)
                    switch (selection) {

                        // Insert Function
                        case "Insert":
                            // Shows error if key exists
                            if (studentDb.containsKey(id)) {
                                JOptionPane.showMessageDialog(null, "ID already exists in database","Error",JOptionPane.ERROR_MESSAGE);
                            } else {
                                // Adds to studentDb, Shows Message
                                studentDb.put(id, new Student(name, major));
                                JOptionPane.showMessageDialog(null, "Student added to Database","Success",JOptionPane.INFORMATION_MESSAGE);
                            }
                            break;

                        // Delete Function
                        case "Delete":
                            // Shows error if key does not exist
                            if (!studentDb.containsKey(id)) {
                                JOptionPane.showMessageDialog(null, "ID does not exist in database","Error",JOptionPane.ERROR_MESSAGE);
                            } else {
                                // Deletes from studentDb, Shows Message
                                studentDb.remove(id);
                                JOptionPane.showMessageDialog(null, "Student removed from Database","Success",JOptionPane.INFORMATION_MESSAGE);
                            }
                            break;

                        // Find Function
                        case "Find":
                            if (!studentDb.containsKey(id)) {
                                JOptionPane.showMessageDialog(null, "ID does not exist in database","Error",JOptionPane.ERROR_MESSAGE);
                            } else {
                                studentDb.get(id);
                                String toString = studentDb.get(id).toString();
                                JOptionPane.showMessageDialog(null, "Student found in Database\n" + toString, "Success",JOptionPane.INFORMATION_MESSAGE);
                            }
                            break;

                        // Update Function
                        case "Update":
                            if (studentDb.containsKey(id)) {
                                String grade = (String)JOptionPane.showInputDialog(null, "Choose grade:","",JOptionPane.QUESTION_MESSAGE,null,gradeStr,gradeStr[0]);
                                if (grade != null) {
                                    String creditHours = (String)JOptionPane.showInputDialog(null, "Choose credits:","",JOptionPane.QUESTION_MESSAGE,null,creditStr,creditStr[0]);
                                    if (creditHours != null) {
                                        studentDb.get(id).courseCompleted(grade,Integer.parseInt(creditHours));
                                        JOptionPane.showMessageDialog(null, "Student record was updated", "Success",JOptionPane.INFORMATION_MESSAGE);
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Credits were not entered","Error",JOptionPane.ERROR_MESSAGE);
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "Grade was not entered","Error",JOptionPane.ERROR_MESSAGE);
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "ID does not exists in database","Error",JOptionPane.ERROR_MESSAGE);
                            }
                            break;
                    }
                }
            } catch (NullPointerException e1) {
                JOptionPane.showMessageDialog(null, "The ID text field is required","Error",JOptionPane.ERROR_MESSAGE);
            }
        });


        // JFrame Settings
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(350, 200);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    /**
     * Creates the Database.App
     * @param args no effect
     */
    public static void main(String[] args) {
        new App();
    }
}