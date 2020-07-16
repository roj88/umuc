/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication24;

/**
 *
 * @author rolandcarter
 */
public class JavaApplication24 {
    static int count = 0;
    // iterativeSort runs a bubble sort using an iterative method
    static void iterativeSort (int[] list) {
        
        // get list length
        int n = list.length;
        
        // iteratre through the list
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (list[j] > list[j+1]) { 
                    // swap list[j+1] and list[i] 
                    int temp = list[j]; 
                    list[j] = list[j+1]; 
                    list[j+1] = temp;
                    
                    // // count number of operations
                    count++;
                } 
            }
        }
    }
    
    static void recursiveSort (int[] list, int n) {
        // set count and time to 0
        count = 0;
        
        // run recursive function
        list = recursiveHelper(list, list.length);
    }
    
    // recursive is a helper function that runs a bubble sort recursively
    static private int[] recursiveHelper(int[] list, int n){
        // base case 
        if (n == 1) 
            return list; 
       
        // recursive case
        for (int i=0; i<n-1; i++) {
            if (list[i] > list[i+1]) { 
                // perform swaps
                int temp = list[i]; 
                list[i] = list[i+1]; 
                list[i+1] = temp; 
                // count number of operations
                count++;
            }
        }
       
        if (n > 1) {
            recursiveHelper(list, n - 1);
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {2, 6, 3, 1};
        
        recursiveSort(arr, arr.length);
        //iterativeSort(arr);
        
        System.out.println(count);
    }
    
    
}
