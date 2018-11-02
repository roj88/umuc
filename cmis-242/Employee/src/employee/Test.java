/*
 * filename: ProjectOneDemo.java
 * author: roland carter
 * date: 2018-09-02
 * purpose: cmis 242 project 1
 */

package employee;

// import libraries
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// begining of ProjectOneDemo class
public class Test {
    
    // txtIntoList is a static method that reads in a .txt field and returns
    // a List<String[]> with the String[] array being the strings on each line
    // and the index of the List being each line
    public static List<String[]> txtIntoList (String filePath) throws FileNotFoundException, IOException{

    // create new BufferedReader object
    BufferedReader br = new BufferedReader(new FileReader(filePath));

    // declare variables
    String line =  null;
    List<String[]> content = new ArrayList<>();

    // while loop creates an array from each line and splits it on the " "
    while((line=br.readLine())!=null){
        content.add(line.split(" "));
        }
    
    return content; // return final List<String[]>
    } // end txtIntoList
    
    // begin main method
    public static void main(String args[]) throws IOException{
        
        // declare file path constant 
        final String FILE_PATH = "/Users/rolandcarter/github-repos/umuc/cmis-242/Employee/src/employee_data_2_1.txt";
        
        // create list from txtIntoList() static method
        List<String[]> readInData = txtIntoList(FILE_PATH);

        for(int i = 0; i < readInData.size(); i++){
            String[] dataArray = readInData.get(i);
            
            
        
            System.out.println(dataArray.length);
        }
        
    }
}