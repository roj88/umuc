/*
 * filename: CatchErrors.java
 * author: roland carter
 * date: 2018-12-15
 * purpose: CatchErrors class throws exceptions
*/

package classdepgraphgui;

// CatchErrors extends the Exception class in order to throw exceptions
public class CatchErrors extends Exception {
    CatchErrors (String message) {
        super(message);
    }
}
