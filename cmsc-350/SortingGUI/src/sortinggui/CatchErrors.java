/*
 * filename: CatchErrors.java
 * author: roland carter
 * date: 2018-11-30
 * purpose: CatchErrors class throws exceptions
*/

package sortinggui;

// CatchErrors extends the Exception class in order to throw exceptions
public class CatchErrors extends Exception {
    CatchErrors (String message) {
        super(message);
    }
}
