/*
 * filename: StateBirdAndFlowerTest.java
 * author: roland carter
 * date: 2018-08-03
 * purpose: cmis 141 hw 4. this class uses the statebirdandflower package in order
 *          to return state flowers and birds
 */

// import required packages
import java.io.IOException;
import java.util.*;
import statebirdandflower.StateBirdAndFlower;
        
// begin StateBirdAndFlowerTest class 
public class StateBirdAndFlowerTest {
        
        // define state birds and flowers .csv files
        public static final String BIRD_DIR = "/Users/rolandcarter/github-repos/umuc/cmis-141/StateBirdAndFlower/src/data/state_bird.csv";
        public static final String FLOWER_DIR = "/Users/rolandcarter/github-repos/umuc/cmis-141/StateBirdAndFlower/src/data/state_flower.csv";
    
    // begin main method
    public static void main(String args[]) throws IOException {

        // define variables
        boolean userInputNotNone = true;
        String state = null;
        
        // define lists to hold user inputs.
        ArrayList<String> saveStates = new ArrayList<>();
        ArrayList<String> saveBirds = new ArrayList<>();
        ArrayList<String> saveFlowers = new ArrayList<>();
        
        // use Scanner for user inputers
        Scanner sc = new Scanner(System.in);
        
        // do-while list for each loop of user inputs
        do{
            // get user to input state
            System.out.println("Enter a State or None to exit:");
            
            // set state variable to user input
            state = sc.nextLine();
            state = state.trim();
            
            // create StateBirdAndFlower class
            StateBirdAndFlower sbaf = new StateBirdAndFlower(state, BIRD_DIR, FLOWER_DIR);
            
            // make sure to only output data where state!=none
            if(!"none".equals(state.toLowerCase())){
                
                // save state inputs to list
                saveStates.add(state);
                saveBirds.add(sbaf.getBird());
                saveFlowers.add(sbaf.getFlower());
                
                // output birds and flowers
                System.out.println("Bird: " + sbaf.getBird() + "\n" +  "Flower: " + sbaf.getFlower());
            }
            
        } while(!"none".equals(state.toLowerCase())); // break when state == none
        
        // return report summary string for each input
        System.out.println("\n\n" + "**** Thank you *****\n" +"A summary report for each State, Bird, and Flower is:");
        for(int i = 0; i < saveStates.size(); i++){
            if(!"none".equals(saveStates.get(i).toLowerCase()))
                System.out.println(saveStates.get(i) + ", " + saveBirds.get(i) + ", " + saveFlowers.get(i) + ", ");
        }
    } // end main method
} // end StateBirdAndFlowerTest class
