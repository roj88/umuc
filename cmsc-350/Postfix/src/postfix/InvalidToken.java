/*
 * filename: InvalidToken.java
 * author: roland carter
 * date: 2018-11-17
 * purpuse: project 2 cmsc 250
*/

package postfix;

// InvalidToken extends the Exception class in order to throw exceptions
public class InvalidToken extends Exception{
    InvalidToken (String message) {
        super(message);
    }
}
