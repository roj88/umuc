/*
 * filename: Sequence.java
 * author: roland carter
 * date: 2018-09-26
 * purpose: cmis 242 project 3
 */

package recursion;

// begin Sequence class
public class Sequence {
    
    private static int efficiency;
    
    // computeRecursive static method takes an int n and returns the nth
    // Pell number recursively
    public static int computeRecursive(int n){
        // add to count of efficiency
        efficiency++;
        
        if(n <= 2){
            return n;
        }
        else{
            return 2*computeRecursive(n - 1) + computeRecursive(n-2);
        }
    }
    
    // computeIterative static method takes an int n and returns the nth
    // Pell number iteratively
    public static int computeIterative(int n){

        if(n <= 2) {
            // add to count of efficiency
            efficiency++;
            
            return n;
        }
        else {
            int a = 1;
            int b = 0;
            int c = 0;
            
            for(int i = 1; i <= n; i++) {
                // add to count of efficiency
                efficiency++;
                
                c = a + 2*b;
                a = b;
                b = c;
            }
            return c;
        }
    }

    // getEfficiency static method counts the efficiency of a recursive method
    public static int getEfficiency() {
        int temporaryVar = efficiency; // in order to reset instance variable efficiency
        efficiency = 0;
        return temporaryVar; 
    }
    
} // end Sequence class
