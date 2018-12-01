/*
 * filename: Fraction.java
 * author: roland carter
 * date: 2018-11-30
 * purpose: Fraction class converts fraction strings into Doubles
*/

package sortinggui;

// import libraries
import java.text.ParseException;
import java.util.*;

// begin class Fraction
public class Fraction implements Comparable<Fraction> {
    private Double value;
    private int numerator;
    private int denominator;
    
    
    // constructor fractionToDouble parses fraction String
    public Fraction(String value) throws ParseException, CatchErrors {
        Double d = null;
        
        if (value != null) {
            // error if not a fraction
            if(!value.contains("/")) {
                throw new CatchErrors("Enter a fraction value.");
            }
            
            if(value.contains("/")) {
                String [] numbers = value.split("/");
                for (String number : numbers) {
                    // error if contains non-integer
                    if (!number.matches("[0-9]+")) {
                        throw new CatchErrors("Illegal character present.");
                    }
                }
                
                // error is divide by zero
                if(numbers[1].equals("0")) {
                    throw new CatchErrors("Divide by zero error.");
                }
                
                // error if more than 2 integers
                if(numbers.length > 2) {
                    throw new CatchErrors("Please enter a fraction with two integers.");
                }
                
                // error is only one integer
                if(numbers.length == 1) {
                    throw new CatchErrors("Please enter a fraction with two integers.");
                }
                
                if(numbers.length == 2) {
                    this.numerator = Integer.valueOf(numbers[0]);
                    this.denominator = Integer.valueOf(numbers[1]);
                    this.value = (double)numerator/(double)denominator;
                }
            }
        }
    }
    
    public Double getValue() {
        return this.value;
    }
    

    @Override
    // toString method
    public String toString(){
        return String.format("%s/%s", numerator, denominator);
    }
    
    // compareTo method uses the Comparator class to
    // compare generic items of type T
    @Override
    public int compareTo(Fraction fraction) {
        if(this.value == fraction.getValue()) {
            return 0;
        }
        else if(this.value > fraction.value) {
            return 1;
        }
        else{
            return -1;
        }
   }
} // end class Fraction
