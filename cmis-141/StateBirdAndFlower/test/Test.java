
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import statebirdandflower.ReadData;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rolandcarter
 */
public class Test {
    public static void main(String args[])throws FileNotFoundException, IOException{
        
        final String flowerFilePath =  "/Users/rolandcarter/github-repos/umuc/cmis-141/StateBirdAndFlower/src/data/state_flower.csv";
        
        BufferedReader br;
        br = new BufferedReader(new FileReader(flowerFilePath));
        String line =  null;
        HashMap<String,String> map;
        map = new HashMap<>();

        while((line=br.readLine())!=null){
            String str[] = line.split(",");
                map.put(str[0], str[1]);
            }
        
        System.out.println(map);
        
    }
}
