/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication14;

/**
 *
 * @author rolandcarter
 */

    import java.text.DecimalFormat;

/**
 * File: Student.java
 * Author: William Crutchfield
 * Date: March 3, 2017
 * Description: Handles the Student Records, and calculates GPA
 */
public class Student {

    // Variables
    private String name;
    private String major;
    private double credits;
    private double qualityPoints;
    private int gradePoints;
    private double gpa =  4.0;
    private static DecimalFormat df = new DecimalFormat("#0.00");

    /**
     * Constructs the Database.Student Object held in the Database, initializes credits and qualityPoints to the value of 0
     * @param name Holds the value of the Student's name
     * @param major Holds the value of the Student's major
     */
    Student(String name, String major) {
        this.name = name;
        this.major = major;
        credits = 0;
        qualityPoints = 0;
    }

    /**
     * Calculates the GPA for the Database.Student
     * @param grade Holds a letter value that is then converted to int gradePoints based on letter value
     * @param creditHours Holds an int value for number of credits for current course
     */
    void courseCompleted(String grade, int creditHours) {
        // Calculates points based on grade
        switch (grade) {
            case "A":
                gradePoints = 4;
                break;
            case "B":
                gradePoints = 3;
                break;
            case "C":
                gradePoints = 2;
                break;
            case "D":
                gradePoints = 1;
                break;
            case "F":
                gradePoints = 0;
                break;
        }
        // Calculate gradePoints total
        gradePoints = gradePoints*creditHours;

        // Calculate qualityPoints and Credits
        qualityPoints += gradePoints;
        credits += creditHours;

        // Calculate GPA
        gpa = qualityPoints/credits;
    }

    /**
     * toString Method for Student
     * @return String with the Student's Name, Major, and GPA
     */
    public String toString() {
        return "\nName: \t" + name + "\nMajor: \t" + major + "\nGPA: \t" + df.format(gpa);
    }
}
}
