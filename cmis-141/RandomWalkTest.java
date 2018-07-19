/*
* file name: RandomWalkTest.java
* author: roland carter
* date: 2018-07-14
* purpose: week 4 discussion. this program tests the 
*.         RandomWalk.java class
*/

public class RandomWalkTest{
	public static void main(String [] args){

	// create a loop to loop through the probabilities 
	for(int i = 1; i <= 50; i++){
		// set the class
		RandomWalk rw = new RandomWalk(i, 1000, 10);

		// print out the probability
		System.out.println(rw.PercentChance());
		}
	}
}