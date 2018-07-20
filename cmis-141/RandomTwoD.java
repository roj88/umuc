/*
* File: DeBUGMe.java
* Author: Joan Rush
* Date: June 28, 2018
* Purpose: This program demonstrates the ability to create functioning code.
*/

import java.util.Random;
import java.util.Arrays;

public class RandomTwoD{

public static int[][] randomTwoD(){
	Random rand = new Random();

	int[][] random2DArray = new int[5][10];

	for(int i = 0; i < 5; i++){
		for(int j = 0; j < 10; j++){
			random2DArray[i][j] = (int)rand.nextInt(10);
		}
	}

	return random2DArray;

}
  

  public static void main(String args[]){            

  	int[][] arrayToPrint = randomTwoD();

  	for(int i = 0; i < 5; i++){
  		for(int j = 0; j < 10; j++){
  			System.out.print(arrayToPrint[i][j] + "\t");
  	}
  	System.out.println(""); 
}
}
}