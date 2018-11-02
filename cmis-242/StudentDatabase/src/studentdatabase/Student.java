/*
 * filename: Student.java
 * author: roland carter
 * date: 2018-10-14
 * purpose: cmis 242 project 4
*/

package studentdatabase;

// being Student class
public class Student {
    private String studentName;
    private String studentMajor;
    private double gradePoints;
    private double qualityPoints;
    private double totalCreditHours;
    private double gpa;
    
    
    // Student constructor
    Student (String studentName, String studentMajor) {
        this.studentName = studentName;
        this.studentMajor = studentMajor;
        this.totalCreditHours = 0;
        this.qualityPoints = 0;
        this.gpa = 4.0; // 4.0 is default gpa
    }
    
    // courseCompleted takes a letter grade string and the credit hours for a class
    // as an int and adds the grade points and credit hours to the instance variables
    public void courseCompleted(String grade, int creditHours){
        // grades into numerical values
        switch (grade) {
            case "A":
                qualityPoints = 4;
                break;
            case "B":
                qualityPoints = 3;
                break;
            case "C":
                qualityPoints = 2;
                break;
            case "D":
                qualityPoints = 1;
                break;
            case "F":
                qualityPoints = 0;
                break;
        }
        
        // calculate gpa
        this.gradePoints += (creditHours * qualityPoints);
	this.totalCreditHours += creditHours;
        this.gpa = (double)Math.round((this.gradePoints / this.totalCreditHours) * 100d) / 100d;

    }

    // get methods for studentName, studentMajor and gpa
    public String getName() {
        return this.studentName;
    }
    
    public String getMajor() {
        return this.studentMajor;
    }
    
    public double getGpa() {
        return this.gpa;
    }
    
    // toString returns the name, major, and gpa as strings
    @Override
    public String toString(){
        return String.format("Name: %s, Major: %s, GPA: %s", getName(), getMajor(), getGpa());
    }
  
} // end Student class
