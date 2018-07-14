/*
* filename: FizzBuzz.java
* author: roland carter
* date: 2018-07-04
* purpose: print numbers from 1 to 100. print fizz when divisible by 3,
*          buzz when divisible by 5, and fizzbuzz when divisible by 3 and 5.
*/
public class FizzBuzz {
public static void main(String[] args){

	for(int i = 1; i <= 100; i++){ // initialize a loop from 1 to 100
		if(i % 3 == 0 && i % 5 == 0){
			System.out.println("FizzBuzz");
			}
			else if(i % 3 == 0){
				System.out.println("Fizz");
			}
			else if(i % 5 == 0){
				System.out.println("Buzz");
			}
			else {
				System.out.println(i);
			}
		}
	}

}

