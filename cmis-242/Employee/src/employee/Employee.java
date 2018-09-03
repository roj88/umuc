/*
 * filename: Employee.java
 * author: roland carter
 * date: 2018-09-02
 * purpose: cmis 242 project 1
 */

package employee;

// begin super class Emplyee
class Employee {

    // declare variables
    private String fullName;
    private int monthlySalary;
    
    // Employee constructor
    public Employee (String fullName, int monthlySalary){
        this.fullName = fullName;
        this.monthlySalary = monthlySalary;
}
    // setter methods
    public void setFullName(String fullName){
        this.fullName = fullName;
    }
    
    public void setMonthlySalary(int monthlySalary){
        this.monthlySalary = monthlySalary;
    }
    
    // getter methods
    public String getFullName(){
        return fullName;
    }
    
    public int getMonthlySalary(){
        return monthlySalary;
    }
    
    // annualSalary method returns the 12 month salary for an employee
    // can be overriden by subclasses Salesman and Executive
    public int getAnnualSalary(){
        return monthlySalary * 12;
    }
    
    // toString method returns class information in a string
    // can be overriden by subclasses Salesman and Executive
    @Override
    public String toString(){
        return String.format("fullName: %s\nmonthlySalary: %s",
                getFullName(),
                getMonthlySalary());
    }
} //end Employee class