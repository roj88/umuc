/*
* file name: RandomWalk.java
* author: roland carter
* date: 2018-07-14
* purpose: week 4 discussion. this program does a random walk
*          it calculates the number of units a "walker" is from
*          the starting point and calculates the probability that
*          a walker is farther than a certain threshold distance
*/

import java.util.Random;

public class RandomWalk{

	// declare variables
	private int blocksWalked;
	private int numWalks;
	private int walkThreshold;
	private int x;
	private int y;

	// initiate Random class
	Random random = new Random();

	// constructor
	public RandomWalk(int pBlocksWalked, int pNumWalks, int pWalkThreshold){
		blocksWalked = pBlocksWalked;
		numWalks = pNumWalks;
		walkThreshold = pWalkThreshold;
	}

	// default value constructor
	public RandomWalk(){
		blocksWalked = 100;
		numWalks = 100;
		walkThreshold = 10;
	}

	// set the values for variables
	public void setBlocksWalked(int pBlocksWalked){
		blocksWalked = pBlocksWalked;
	}

	public void setNumWalks(int pNumWalks){
		blocksWalked = pNumWalks;
	}

	// create get methods to return variables
	public int getBlocksWalked(){
		return blocksWalked;
	}

	public int getNumWalks(){
		return numWalks;
	}

	// DistanceFromStartingPoint method calculates the distance a random
	// walker is from their starting point
	public double DistanceFromStartingPoint(){
		int x = 0;
		int y = 0;
		int randomInt;
		double distance;

		// get a random int for each unit walked and change x, y values based on
		// random value
		for(int i = 0; i <= blocksWalked; i++){
			randomInt = random.nextInt(4 - 1 + 1) + 1;

			if(randomInt == 1){
				y++;
			}
			else if(randomInt == 2){
				x++;
			}
			else if(randomInt == 3){
				y--;
			}
			else{
				x--;
			}
		}

		// get the "manhattan" distance
		distance = Math.abs(x) + Math.abs(y);

		// return the distance
		return distance;
	}

	// PercentChance get the probability that a "walk" ends within a certain
	// threshold distance. this is monte carlo piece of this class
	public double PercentChance(){
		double reachedThreshold = 0;

		for(int i = 1; i <= numWalks; i++){
			if(DistanceFromStartingPoint() > walkThreshold){
				reachedThreshold++;
			}
		}

		double probability = reachedThreshold / numWalks;

		return probability;
	}


	// create method to allow human readable output
	public String toString(){
        return String.format("blocksWalked: %s; numWalks: %s; walkThreshold: %s; PercentChance(): %s;", blocksWalked, numWalks, walkThreshold, PercentChance());
	}

}