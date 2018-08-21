

/*
 * filename: CrimeTest.java
 * author: roland carter
 * date: 2018-08-09
 * purpose: cmis 141 final project. this class calculates crime stats and returns
 *          information to a user
 */

// import libraries
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Scanner;

// being class CrimeTest
public class CrimeTest {
    
    // begin main method
    public static void main(String[] args) throws IOException{
        
        // define variables
        String filePath;
        boolean userInputNotQuit = true;
        String userSelection = null;
        
        // get file path from command line
        filePath = String.valueOf(args[0]);
        
        // use Scanner for user inputs
        Scanner sc = new Scanner(System.in);
            
            // create Crime object
            Crime cr = new Crime(userSelection, filePath);

            LinkedHashMap<Integer,Double> map = cr.setMap();
            
            // set map for crime object
            System.out.println(map);
            
            
        
    }   // end main method
} // end CrimeTestClass
