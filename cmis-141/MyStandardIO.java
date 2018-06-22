/*
* filename: MyStandardIO.java
* author: roland carter
* date: 2018-06-21
* purpose: labe week 2 exercise
*/

// Import each required Java class
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MyStandardIO {
	
	public static void main(String[] args) throws IOException {

		int age;

		InputStreamReader isReader = new InputStreamReader(System.in);

		BufferedReader stdin = new BufferedReader(isReader);

		System.out.println("What is your age?");

		age = Integer.parseInt(stdin.readLine());

		
     	boolean canVote = false;
	     if (age >= 18 ) {
	           canVote = true;
	     }

		System.out.println("You can vote? " + canVote);



	}
}