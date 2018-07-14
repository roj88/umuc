/*
Dope addition. I've done something like this in Python before.

One tweak can actually make it a bit more efficient.

Using the Sieve of Eratosthenes, you can find all of the possible prime factors for numbers 100 (or whatever maxRange) or less. You can place these in an array first so that you only need to iterate through those numbers, rather than enumerating through j++.
*/

import java.util.Scanner;

public class FindingPrimes{

	public static List<Integer> getPrimeFactors(int maxNum) {
	    
		List<Integer> arr = new ArrayList<Integer>();

	    int maxDiv = Math.floor(Math.sqrt(maxNum));

	    for (int i = 2; i <= maxDiv; i++){
	    	isPrime = true;
	    	for (int j = 2; j <= Math.sqrt(i) && isPrime == true; j++){
	    		while(i % j != 0 ){
	    			isPrime = false;
	    		}
	    	}

	    	if(isPrime){
	    		arr.add(i);
	    	}
	    }
	    return arr;
	}


			

	public static void main (String[] args){

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the max integer for primes: ");
		int maxNumber = sc.nextInt();
		System.out.println(getPrimeFactors(maxNumber));

		/*
		double maxDivisor = Math.sqrt(maxNumber);

		Boolean isNotPrime;

		for (int i = 1; i <= maxDivisor; i++){


			while(j < Math.sqrt(i) && j <= (int)Math.floor(maxDivisor)){
					j = (int) Math.floor(Math.sqrt(i));
					isNotPrime = i % j == 0;
					System.out.println("sub loop: " + i + " " + j + " "+ isNotPrime);
					j++;

				}
			if(isNotPrime){
				System.out.println(i);
				}
			else {
				System.out.println(i + "womp");
			}
		}*/
	}
}

