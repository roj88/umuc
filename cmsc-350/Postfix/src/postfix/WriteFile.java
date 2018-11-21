/*
 * filename: WriteFile.java
 * author: roland carter
 * date: 2018-11-17
 * purpuse: project 2 cmsc 350
*/

package postfix;

// import libraries
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

// begin WriteFile
public class WriteFile {
    // create final file variable
    private static final File FILE = new File("data.txt");
    
    // static method writeToFile takes a string and writes it to a file
    static void writeToFile(String evaluationStep) throws IOException {
        String file = null;
        
        // create new BufferedWriter object
        BufferedWriter bw = new BufferedWriter(new FileWriter(FILE,true));
        
        // write string to file then close file
        bw.write(evaluationStep);
        bw.newLine();
        bw.close();
    }

} // end WriteFile
