/*
 * filename: CatchErrors.java
 * author: roland carter
 * date: 2018-11-01
 * purpose: cmsc 350 project 1
*/

package infixexpression;

// CatchErrors extends the Exception class in order to throw exceptions
public class CatchErrors extends Exception {
    CatchErrors (String message) {
        super(message);
    }
}
