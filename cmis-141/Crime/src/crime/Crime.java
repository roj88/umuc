/*
 * filename: Crime.java
 * author: roland carter
 * date: 2018-08-09
 * purpose: cmis 141 final project. this class calculates crime stats
 */


// import libraries
import java.io.IOException;
import java.util.*;

// begin Crime class
public class Crime {
    
    // defin variables
    private String userInput;
    private String filePath;
    private LinkedHashMap<Integer,Double> map;
    
    // constructor
    public Crime(String userInput, String filePath){
        this.userInput = userInput;
        this.filePath = filePath;
    }
    
    // default constructor
    public Crime(){
        this.userInput = null;
        this.filePath = null;
    }
    
    // setter methods
    public void setUserInput(){
        this.userInput = userInput;
    }
    
    public void setFilePath(){
        this.filePath = filePath;
    }

    // getter methods
    public String getUserInput(){
        return userInput;
    }
    
    public String getFilePath(){
        return filePath;
    }
    
    // getUSCrimeData gets the data from a csv file and saves it into a HashMap
    public LinkedHashMap<Integer,Double> getUSCrimeData() throws IOException{
        
        // define variables
        int columntoParse;
        
        // depending on the user select, this will determine the column to parse
        if("1".equals(this.userInput)){
            columntoParse = 1;
            }   else switch (this.userInput) {
                case "2":
                    columntoParse = 5; // murder rate
                    break;
                case "3":
                    columntoParse = 5; // murder rate
                    break;
                case "4":
                    columntoParse = 9; // robbery rate
                    break;
                case "5":
                    columntoParse = 9; // robbery rate
                    break;
                default:
                    columntoParse = 1;
                    break;
            }
        
        // create data object
        ReadUSCrimeData rd = new ReadUSCrimeData(filePath, columntoParse);
        
        // return hashmap
        return rd.csvIntoHash();
    }
    
    // variable map to getUSCrimeData()
    public void setMap() throws IOException{
        this.map = getUSCrimeData();
    }
    
    // getMaxRate gets the minimum rate for a crime
    public int getMaxRate(){
        this.map = map; // user map defined in object
        
        Double maxValueInMap=(Collections.max(map.values()));  // get max value in the Hashmap
        for (Map.Entry<Integer, Double> entry : map.entrySet()) {  // iterate through hashmap
            if (entry.getValue()==maxValueInMap) {
                return entry.getKey();      // return max value
            }
        }
        return 0;
    }
    
    // getMinRate gets the minimum rate for a crime
    public int getMinRate(){
        this.map = map; // user map defined in object
        
        Double minValueInMap=(Collections.min(map.values()));  // get min value in the Hashmap
        for (Map.Entry<Integer, Double> entry : map.entrySet()) {  // iterate through hashmap
            if (Objects.equals(entry.getValue(), minValueInMap)) {
                return entry.getKey();     // return min value
            }
        }
        return 0;
    }
    
    // getPopulationGrowth returns an array of population growth
    public ArrayList<Double> getPopulationGrowthArrayList(){
        this.map = map; // user map defined in object
        
        // create array from hashmap values
        Double[] hashToArray = map.values().toArray(new Double[0]);
        
        ArrayList<Double> saveRates = new ArrayList<>(); // define arraylist to save growth values
        
        // iterate through growth values and save to array list
        for(int i = 1; i < hashToArray.length; i++){
            Double difference = (hashToArray[i] - hashToArray[i-1]) / hashToArray[i-1];         
                saveRates.add(difference);
        }
        
        return saveRates; // return array of growth values
    }
    
    public void printPopulstionGrowth(){
        // set array list from getPopulationGrowthArrayList()
        ArrayList<Double> growthRates = getPopulationGrowthArrayList();
        final int YEAR = 1994; // set constant
        
        // iterate through each growth rate and print it with the year
        for(int i = 0; i < growthRates.size(); i++){
            Double growthRatesAsPercent = growthRates.get(i)*100;
            
            
            System.out.println(String.format("%s-%s     %s%%",
                    YEAR + i,
                    YEAR + i + 1,
                    (double)Math.round(growthRatesAsPercent * 10000d) / 10000d));
        }
    }
}
