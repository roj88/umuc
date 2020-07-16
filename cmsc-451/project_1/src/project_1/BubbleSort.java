/*
 * filename: BubbleSort.java
 * author: roland carter
 * date: 2019-07-07
 * purpose: perform bubble sort on an array
*/

package project_1;


// begin class BubbleSort
public class BubbleSort implements SortInterface {
    
    // create variables to count operations and runtime
    private int count;
    private long time;
    
    @Override
    // recursiveSort runs a recursive sort using the recursive method
    public void recursiveSort (int[] list, int n) throws UnsortedException{
        // set count and time to 0
        count = 0;
        time = 0;
        
        // get start time
        long startTime = System.nanoTime();
        
        // run recursive function
        list = recursiveHelper(list, list.length);
        
        // get end time and calculate run time
        long endTime = System.nanoTime();
        time = (endTime - startTime);

        // throw exception if list is not sorted
        if(!isSorted(list)) {
            throw new UnsortedException("Array is not sorted.");
        }
        
    }
    
    // recursive is a helper function that runs a bubble sort recursively
    private int[] recursiveHelper(int[] list, int n){
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
            
                // count number of swaps
                count++;
            }
        }
       
        if (n > 1) {
            recursiveHelper(list, n - 1);
        }
        return list;
    }
    
    @Override
    // iterativeSort runs a bubble sort using an iterative method
    public void iterativeSort (int[] list) throws UnsortedException {
        count = 0;
        time = 0;
        
        // get start time
        long startTime = System.nanoTime();
        
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
                    
                    // count number of swaps
                    count++;
                } 
            }
        }

        // get end time and calculate total runtime
        long endTime = System.nanoTime();
        time = (endTime - startTime);

        // throw exception if list is not sorted
        if(!isSorted(list)) {
            throw new UnsortedException("Array is not sorted.");
        }
    }
    
    // isSorted checks if an array is listed
    private static boolean isSorted(int[] data){
        // iterate through each index in the list
        for(int i = 1; i < data.length; i++){
            if(data[i-1] > data[i]){
                return false;
            }
        }
        return true;
    }
    
    @Override
    // getCount returns then number of executions run from an algorithm
    public int getCount(){
        return count;
    }
    
    @Override
    // getTime returns the runtime of an algorithm
    public long getTime(){
        return time;
    }

} // end class BubbleSort
