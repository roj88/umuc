/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication15;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author rolandcarter
 */
public class JavaApplication15 {

    public static Integer[] f (int n) {
        int sum = 0;
        int numTimes = 0;
        for (int i = n; i > 0; i = i * 2){
            numTimes += 1;
            sum += i;
        }
        Integer[] arr = {sum, numTimes};
        return arr;
    } // end f
    public static void main(String[] args) {
        HashMap<Integer, String> myHashMap = new HashMap<>();
        for(int i = 0; i < 100000; i++){
            myHashMap.put(i, Arrays.toString(f(i)));
        }
        
        System.out.println(myHashMap);
        

    }
    
}
