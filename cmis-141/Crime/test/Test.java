
import crime.ReadUSCrimeData;
import java.awt.RenderingHints.Key;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import static jdk.nashorn.internal.objects.NativeArray.map;

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
    public static void main(String[] args) throws IOException{
        
        int columntoParse;
        String crimeDataType = null;
        
        if(null==crimeDataType){
            columntoParse = 1;
        }   else switch (crimeDataType) {
            case "robbery":
                columntoParse = 9;
                break;
            case "murder":
                columntoParse = 5;
                break;
            default:
                columntoParse = 1;
                break;
        }
        
        ReadUSCrimeData rd = new ReadUSCrimeData("/Users/rolandcarter/github-repos/umuc/cmis-141/Crime/test/crime.csv", columntoParse);
        
        System.out.println(rd.csvIntoHash());
        
        LinkedHashMap<Integer, Double> map = rd.csvIntoHash();
        
        Double[] hashToArray = map.values().toArray(new Double[0]);
        
        // System.out.println(Arrays.toString(hashToArray));
        for(int i = 1; i < hashToArray.length; i++){
            Double difference = (hashToArray[i] - hashToArray[i-1]) / hashToArray[i-1];
            System.out.println(difference);
            
        }

    }
}
