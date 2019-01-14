/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication18;

import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *
 * @author rolandcarter
 */
public class JavaApplication18 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String userInput = "3 4 3 -+";
        StringTokenizer userInputTokenized = new StringTokenizer(userInput, "()*/+- ", true);
        
        while(userInputTokenized.hasMoreTokens()){
            // grab next token
            String token = userInputTokenized.nextToken();
            
            if(!token.equals(" ")){
                System.out.println(token);
            }
        }
    }
    
}
