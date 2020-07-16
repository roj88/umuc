/*
 * filename: UnsortedException.java
 * author: roland carter
 * date: 2019-07-07
 * purpose: throws exception if array is not sorted
*/


package project_1;

public class UnsortedException extends Exception{
    UnsortedException (String message) {
        super(message);
    }
}
