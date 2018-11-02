/*
 * filename: InsufficientFunds.java
 * author: roland carter
 * date: 2018-09-16
 * purpose: project two. this class throws an nsf exception in program
 */

package atmmachinegui;

// begin InsufficientFunds class
public class InsufficientFunds extends Exception {
    
    // this method uses the Exception class in order to throw
    // exceptions within the Account class
    public InsufficientFunds(String exceptionReason){
        super(exceptionReason);
    }
    
} // end InsufficientFunds class
