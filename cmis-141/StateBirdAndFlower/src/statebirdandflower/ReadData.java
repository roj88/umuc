package statebirdandflower;

/**
 * filename: ReadData.java
 * author: roland carter
 * date: 2018-08-03
 * purpose: cmis 141 hw 4. this class reads a two-column csv and makes it into
 *          a two-string hashmap
 */

// import required packages
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

// begin ReadData class
public class ReadData {
    
    // set variable(s) name (s)
    private String filePath;
    
    // constructor
    public ReadData(String filePath){
        this.filePath = filePath;
    }

    // csvIntoHash takes a .csv filename input and turns the csv into a hashmap 
    public HashMap<String,String> csvIntoHash () throws FileNotFoundException, IOException{
        
        // define the file reader based on the file name
        BufferedReader br = new BufferedReader(new FileReader(this.filePath));
        String line =  null;
        HashMap<String,String> map;
        map = new HashMap<>();

        // while creates an array from each line and splits it on the ","
        while((line=br.readLine())!=null){
            String str[] = line.split(",");
                map.put(str[0], str[1]);
            }
        return map; // return a <String,String> hashmap
    } // end csvIntoHash

} // end class ReadData
