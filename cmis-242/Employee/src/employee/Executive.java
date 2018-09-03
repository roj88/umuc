/*
 * filename: Exectutive.java
 * author: roland carter
 * date: 2018-09-02
 * purpose: cmis 242 project 1
 */

package employee;

// begin Executive class which is a subclass of Employee
public class Executive extends Employee{

    // declare variables
    private int stockPrice;
    
    // constructor
    public Executive(String fullName, int monthlySalary, int stockPrice) {
        super(fullName, monthlySalary);
        this.stockPrice = stockPrice;
    }
    
    // setter method
    public void setStockPrice(int stockPrice){
        this.stockPrice = stockPrice;
    }
    
    // getter method
    public double getStockPrice(){
        return this.stockPrice;
    }
    
    // calculate the annual bonus for executives
    public int annualBonus(){
    if(this.stockPrice > 50){
        return 30000;
    }
    else {
        return 0;
        }
    }
    
    // annualSalary returns the total annual salary for an executive
    // note that this method can override the annualSalary method in the superclass
    // Employee
    @Override
    public int getAnnualSalary(){
        return 12*super.getMonthlySalary() + annualBonus();
    }
    
    // toString method returns class information in a string
    // note that this method can override the toString method in the superclass
    // Employee
    @Override
    public String toString(){
        return String.format("fullName: %s\nmonthlySalary: %s, annualSales: %s",
                getFullName(),
                getMonthlySalary(),
                getStockPrice());
    }
}