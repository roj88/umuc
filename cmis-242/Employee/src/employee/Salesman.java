/*
 * filename: Salesman.java
 * author: roland carter
 * date: 2018-09-02
 * purpose: cmis 242 project 1
 */

package employee;

// begin Salesman class which is a subclass of Employee
public class Salesman extends Employee{
    
    // declare variables
    private final double COMISSION_PCT = 0.02;
    private int annualSales;
    
    // Salesman constructor
    public Salesman(String fullName, int monthlySalary, int annualSales) {
        super(fullName, monthlySalary);
        this.annualSales = annualSales;
    }
    
    // setter method
    public void setAnnualSales(int annualSales){
        this.annualSales = annualSales;
    }
    
    // getter method
    public double getAnnualSales(){
        return this.annualSales;
    }
    
    // annualComission calculates the annual comission for sales people
    // and returns the total annual comission as a double
    public int annualComission(){
        if(annualSales * COMISSION_PCT > 20000){
            return 20000;
        }
        else {
            return (int) (annualSales * COMISSION_PCT);
        }
    }
    
    // annualSalary returns the total annual salary for a sales person
    // note that this method can override the annualSalary method in the superclass
    // Employee
    @Override
    public int getAnnualSalary(){
        return 12*super.getMonthlySalary() + annualComission();
    }
    
    // toString method returns class information in a string
    // note that this method can override the toString method in the superclass
    // Employee
    @Override
    public String toString(){
        return String.format("fullName: %s\nmonthlySalary: %s, annualSales: %s",
                getFullName(),
                getMonthlySalary(),
                getAnnualSales());
    }
} // end Salesman class