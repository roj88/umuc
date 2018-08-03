/*
* file name: ArgsParser.java
* author: roland carter
* date: 2018-07-29
* purpose: week 7 discussion. this program takes two command line arguments
*          and returns an array based on the parameters
*/

// import packages
import java.util.Arrays;


// begin ArgsParser class
public class ArgsParser {

	// begin main method
	public static void main(String[] args) throws Exception{

		// create variables
		int numRandomNumbers;
		int numBetweenZeroAndY;
		int[] arrayOfNumbers;

		// try and catch in case the inputs are not ints
		/*if(args.length > 0){
			try{
				numRandomNumbers = Integer.parseInt(args[0]);
				numBetweenZeroAndY = Integer.parseInt(args[1]);
			} catch(NumberFormatException e){
				System.err.println("Arguments must be an integer");
				System.exit(1);
			}
		}*/

		// set the variables equal to the args parsed
		numRandomNumbers = Integer.parseInt(args[0]);
		numBetweenZeroAndY = Integer.parseInt(args[1]);

		// set the size of the array to be args[1]
		arrayOfNumbers = new int[numRandomNumbers];

		// create array of random ints
		for(int i = 0; i < arrayOfNumbers.length; i++){
			arrayOfNumbers[i] = (int)(Math.random()*numBetweenZeroAndY + 1);
		}

		// print array
		System.out.println("Numbers generated are\n" + Arrays.toString(arrayOfNumbers));

	}
}