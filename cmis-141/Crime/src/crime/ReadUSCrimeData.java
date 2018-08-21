/*
 * filename: ReadUSCrimeData.java
 * author: roland carter
 * date: 2018-08-09
 * purpose: cmis 141 final project. this class reads data from a csv and saves it
 *          as a hashmap
 */



import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;


public class ReadUSCrimeData {
    
    // set variable(s) name (s)
    private String filePath;
    private int columnToImport;
    
    // constructor
    public ReadUSCrimeData(String filePath, int columnToImport){
        this.filePath = filePath;
        this.columnToImport = columnToImport;
    }
    
        // csvIntoHash takes a .csv filename input and turns the csv into a hashmap 
    public LinkedHashMap<Integer, Double> csvIntoHash () throws FileNotFoundException, IOException{
        
        // define the file reader based on the file name
        BufferedReader br = new BufferedReader(new FileReader(this.filePath));
        String line =  " ";
        LinkedHashMap<Integer, Double> map;
        map = new LinkedHashMap<>();
        
        // throw away column header line
        String headerLine = br.readLine();
        
        // while creates an array from each line and splits it on the ","
        while((line=br.readLine())!=null){
            String str[] = line.split(",");
                map.put(Integer.parseInt(str[0]), Double.parseDouble(str[columnToImport]));
            }
        return map; // return a <String,String> hashmap
    } // end csvIntoHash
}
