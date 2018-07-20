/*
* File: DeBUGMe.java
* Author: Joan Rush
* Date: June 28, 2018
* Purpose: This program demonstrates the ability to create functioning code.
*/

import java.util.Random;
import java.util.Arrays;

public class ExamScores{
  

  public static void main(String args[]){
  		Random rand = new Random();      

  	int[] arrayScores = new int[1000];

  	for(int i = 0; i < arrayScores.length; i++){
  		arrayScores[i] = rand.nextInt(100 - 1 + 1) + 1;
  	}
  	System.out.println(Arrays.toString(arrayScores));

  	System.out.println(Arrays.toString(Arrays.sort(arrayScores)));
}
}
