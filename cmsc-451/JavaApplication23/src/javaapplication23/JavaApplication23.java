/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication23;

/**
 *
 * @author rolandcarter
 */
public class JavaApplication23 {

    public static int constantFunction(int x, int y) {
        if (y == 5) 
            return y; 
        y = y + 1;
            return constantFunction(x, y);
    }
    
    public static void main(String[] args) {
        System.out.println(constantFunction(-1, 4));
    }
    
}
