/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw1;

/**
 *
 * @author rolandcarter
 */

// import libraries
import java.util.*;

// begin class SortedPriorityQueue 
// which uses <T> generic class type
public class SortedPriorityQueue<T> {

    // create ArrayList
   private ArrayList<T> Sort;
   
   // default constructor 
   public SortedPriorityQueue() {
       Sort = new ArrayList<>();
   }
   
   // isEmpty checks if array is empty
   public boolean isEmpty() {
       return Sort.isEmpty();
   }
   
   // add to sorted array
   public void add(T length) {
       Sort.add(length);
   }
   
   // grab the first high value
   public T highestsort() {
       T implement = Sort.get(0);
       
       for(int i = 1; i < Sort.size(); i++){
           Comparable<T> queueLength = (Comparable<T>)
                   Sort.get(i);
           
           // get the queue length
           if(queueLength.compareTo(implement) < 0)
               implement = (T) queueLength;
       }
       
       return implement;
   }
    

    // method remove() removes objects from T
   public T remove() {
       // get first index of queue
       T implement = Sort.get(0);

       //declare the priority queue value initially
       int implementPQ = 0;
       
       // iterate through the queue
       for(int i = 1; i < Sort.size(); i++) {
           Comparable<T> queueLength = (Comparable<T>)
                Sort.get(i);

           // compare elemtnts
           if(queueLength.compareTo(implement) < 0) {
               implement = (T) queueLength;

               implementPQ = i;
           }
       }

       // sort the implement pq
       Sort.remove(implementPQ);

       return implement;
   }

   // begin main method
   public static void main(String array[]) {

       // call SortedPriorityQueue w/ int
       SortedPriorityQueue<Integer> q = new SortedPriorityQueue<Integer>();

       // add elelments to queue
       q.add(2);
       q.add(13);
       q.add(19);
       q.add(23);
       q.add(31);

       // display output
       System.out.println("value: " + q.highestsort());
       System.out.println("Removing: ");
       System.out.println(q.remove());
       System.out.println( q.remove());
       System.out.println(q.remove());
       System.out.println("highest sort: " + q.highestsort());

   } // end main
} // end SortedPriorityQueue