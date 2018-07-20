/*
* File: DeBUGMe.java
* Author: Joan Rush
* Date: June 28, 2018
* Purpose: This program demonstrates the ability to create functioning code.
*/

import java.util.Random;
import java.util.Arrays;
public class Test1{

public static double average(double[] x){
	double sumOfArray = 0;

	for (int i = 0; i < x.length; i++){
		sumOfArray += x[i];
	}

	return sumOfArray / x.length;

}
  

  public static void main(String args[]){            
      
      double[] randomArray = new double[3];
      Random rand = new Random();



		// create array of random integers
		for(int i = 0; i < randomArray.length - 1; i++){
			randomArray[i] = rand.nextInt(100 - 1 + 1) + 1 / 13;
		}



		System.out.println(Arrays.toString(randomArray));
		System.out.println(average(randomArray));
}
}
