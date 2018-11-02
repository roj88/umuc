/*
 * filename: Account.java
 * author: roland carter
 * date: 2018-09-16
 * purpose: project two. this class performs operations on a "bank account"
 */

package atmmachinegui;

// import libraries
import java.util.HashMap;
import java.util.Map;

// begin Account class
public class Account {
    // variables
    private final double SERVICE_CHARGE = 1.50;
    private double accountBalance;
    int withdrawalCounter;
    
    // constructor
    public Account(double accountBalance){
        this.accountBalance = accountBalance;
    }
    
    // deposit method deposits money in account
    public void deposit(double depositAmount){
        this.accountBalance = this.accountBalance + depositAmount;
    }
    
    // getBalance method returns an account balance
    public double getBalance(){
        return this.accountBalance;
    }
    
    // withdrawal method withdrawals money from account
    // the variable transfer determines if the withdrawal is for a transfer and
    // this doesn't need to use multiples of 20
    public void withdrawal(double withdrawalAmount, int  withdrawalCounter, int transfer) throws InsufficientFunds {
        // if not a multiple of 20
        if(withdrawalAmount % 20 != 0 && transfer == 0){ 
            throw new InsufficientFunds("Withdrawal must be in multiples of $20.");
        }
        // if withdrawal amount is greater than account balance
        else if(withdrawalAmount > this.accountBalance){ 
            throw new InsufficientFunds("Insufficient funds.");
        }
        // nsf with service charge
        else if(withdrawalCounter > 4 && SERVICE_CHARGE + withdrawalAmount > this.accountBalance){
            throw new InsufficientFunds("Insufficient funds.");
        }
        // withdrawal without service fee
        else if(withdrawalCounter <= 4 && withdrawalAmount <= this.accountBalance){
            this.accountBalance = this.accountBalance - withdrawalAmount;
        }
        // withdrawal with service fee
        else if(withdrawalCounter > 4 && SERVICE_CHARGE + withdrawalAmount <= this.accountBalance){
            this.accountBalance = this.accountBalance - (SERVICE_CHARGE + withdrawalAmount);
        }
        else{
            throw new InsufficientFunds("Unknown error.");
        }
    }
} // end class Account
