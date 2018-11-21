/*
 * filename: Operands.java
 * author: roland carter
 * date: 2018-11-17
 * purpuse: project 2 cmsc 250
*/

package postfix;


public class Operands implements Node {
    
    private final String value;
    
    // constructor
    Operands(String value) {
        this.value = value;
    }
    
    // inWalk walks an infix expression 
    public String inWalk() {
        return String.valueOf(value);
    }
    
    // postWalk walks a postfix expression 
    public String postWalk() {
        return String.valueOf(value);
    }
    
    // abtract methiod
    public void post() {
        
    }
    
}
