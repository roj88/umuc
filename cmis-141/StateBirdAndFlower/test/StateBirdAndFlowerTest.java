/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rolandcarter
 */

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import statebirdandflower.StateBirdAndFlower;
import statebirdandflower.ReadData;
        
        
public class StateBirdAndFlowerTest {
    public static void main(String args[]) throws IOException{
        
        final String flowerFilePath =  "/Users/rolandcarter/github-repos/umuc/cmis-141/StateBirdAndFlower/src/data/state_flower.csv";
        ReadData rd = new ReadData(flowerFilePath);
        try {
            System.out.println(rd.csvIntoHash());
        } catch (IOException ex) {
            Logger.getLogger(StateBirdAndFlowerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        StateBirdAndFlower sbaf = new StateBirdAndFlower("Maryland");
        
        System.out.println(sbaf.findItemInMap(rd.csvIntoHash()));
        
        
    }
}
