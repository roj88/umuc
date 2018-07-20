/*
* file name: LinearSearch.java
* author: roland carter
* date: 2018-07-18
* purpose: discussion for week5. this program implements a 
*          linear search algorithm of a rand int on an array of random integers
*/

// import required libraries
import java.util.Random;
import java.util.Arrays;

// begin class
public class LinearSearch{

	// this method implements a linear search on an array.
	// it returns the index of the search criteria, of if it's not there,
	// a -9
	public static int LinearSearch (int[] arrayToSearch, int searchCriteria){

		// implement the linear search
		for(int i = 0; i < arrayToSearch.length; i++){
			if(arrayToSearch[i] == searchCriteria){
				return i; // set the returned index at the index of the criteria if present
			}
		}
		return -9;
	}

	// main method
	public static void main(String[] args){

		// initialize the Random and Arrays classes
		Random rand = new Random();

		// create an array of random integers
		int[] sampleArray = new int[10];

		// create array of random integers
		for(int i = 0; i < sampleArray.length; i++){
			sampleArray[i] = rand.nextInt(10 - 1 + 1) + 1;
		}

		// get a random int to use as search criteria
		int intToFind = rand.nextInt(10 - 1 + 1) + 1;

		// create output string to be printed with the search criteria, a human-readable array, and the search index
		String outputString = String.format("The int to find: %s.The array is: %s. The int is in index: %s",
			intToFind,
			Arrays.toString(sampleArray),
			LinearSearch(sampleArray, intToFind));

		System.out.println(outputString);

	}
}