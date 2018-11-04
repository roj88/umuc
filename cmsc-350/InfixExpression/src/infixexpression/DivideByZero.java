/*
 * filename: DivideByZero.java
 * author: roland carter
 * date: 2018-11-01
 * purpose: cmsc 350 project 1
*/

package infixexpression;


// DivideByZero extends the Exception class in order to throw exceptions
public class DivideByZero extends Exception {
    DivideByZero (String message) {
        super(message);
    }
}