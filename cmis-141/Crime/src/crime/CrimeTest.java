

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
        
        // print out header information for user
        System.out.println("********** Welcome to the US Crime Statistical Application **************************\n");
        
        // do while loop to answer a user's input
        do{
            // print out prompt for user
            System.out.println("Enter the number of the question you want answered. Enter ‘Q’ to quit the program :\n\n");
            System.out.println("1. What were the percentages in population growth for each consecutive year from 1994 – 2013?");
            System.out.println("2. What year was the Murder rate the highest?");
            System.out.println("3. What year was the Murder rate the lowest?");
            System.out.println("4. What year was the Robbery rate the highest?");
            System.out.println("5. What year was the Robbery rate the lowest?");
            System.out.println("Q. Quit the program\n");
            System.out.print("Enter your selection: ");
            
            // set state variable to user input
            userSelection = sc.nextLine();
            
            // create Crime object
            Crime cr = new Crime(userSelection, filePath);
            
            // set map for crime object
            cr.setMap();
            
            // returns output depending on user input
            if(null != userSelection)switch (userSelection) {
                case "1":
                    System.out.println("Population growth since 1994 is as follows\n");
                    cr.printPopulstionGrowth(); // print population growth
                    break;
                case "2":
                    System.out.println(String.format("The Murder rate was highest in %s\n",cr.getMaxRate()));
                    break;
                case "3":
                    System.out.println(String.format("The Murder rate was lowest in %s\n",cr.getMinRate()));
                    break;
                case "4":
                    System.out.println(String.format("The Robbery rate was highest in %s\n",cr.getMaxRate()));
                    break;
                case "5":
                    System.out.println(String.format("The Robbery rate was lowest in %s\n",cr.getMinRate()));
                    break;
                default:
                    break;
            }
            
        } while(!"Q".equals(userSelection)); // break when userSelection == Q
        
        // thank user for using product
        System.out.println("Thank you for trying the US Crimes Statistics Program.");
        
    }   // end main method
} // end CrimeTestClass
