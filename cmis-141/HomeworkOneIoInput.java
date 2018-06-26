/*
* filename: HomeworkOneIOInput.java
* author: roland carter
* date: 2018-06-26
* purpose: this program is homework #1 in the cmis 141 course. it takes
*		   a series of inputs from a user, and returns an output.
*/

// import required java classes
import java.io.IOException;
import java.util.Scanner;

public class HomeworkOneIoInput {

	// celsiusToFahrenheit method takes a Celsius input and converts it to Fahrenheit
	public static double celsiusToFahrenheit(double celsius) {
		return Math.round(celsius*(1.8) + 32);
	} // end method


	// monthsToYears method takes an input of months and converts it to years
	public static int monthsToYears(int months) {
		return months / 12; // integar division
	} // end method


	// start of main method
	public static void main (String[] args) throws IOException {

		// create scanner method sc
		Scanner sc = new Scanner(System.in);

		// prompt user to input their student id and store the user input
		System.out.print("Enter your Student EMPLID (0 - 999999) and press enter: ");
		int studentId = sc.nextInt();

		// prompt user to input their first quiz and store the user input
		System.out.print("Enter your quiz1 percentage score (0.0 – 100.0) and press enter: ");
		double quizOne = sc.nextDouble();

		// prompt user to input their second quiz and store the user input
		System.out.print("Enter your quiz2 percentage score (0.0 – 100.0) and press enter: ");
		double quizTwo = sc.nextDouble();

		// prompt user to input their third quiz and store the user input
		System.out.print("Enter your quiz3 percentage score (0.0 – 100.0) and press enter: ");
		double quizThree = sc.nextDouble();

		// prompt user to input their age in months as an int and store the user input
		System.out.print("Enter your age in months (0-1440) and press enter: ");
		int ageInMonths = sc.nextInt();

		// prompt user to input the temperature in Celsius as a double and store the user input
		System.out.print("Enter the current Temperature in degrees Celsius and press enter: ");
		double currentTempCelsius = sc.nextDouble();

		// calculate the average of the three quizes
		final int NUMBER_OF_QUIZES = 3;
		double quizAverage = Math.round((quizOne + quizTwo + quizThree) / NUMBER_OF_QUIZES);

		// set degree symbol in unicode as a constant 
		final String DEGREE  = "\u00b0";


		// print out desired assignment output
		System.out.println("*** Thank you ***");
		System.out.println("Student EMPLID: " + studentId);
		System.out.println("Quiz 1 Score: " + quizOne);
		System.out.println("Quiz 2 Score: " + quizTwo);
		System.out.println("Quiz 3 Score: " + quizThree);
		System.out.println("Average quiz score: " + quizAverage);
		System.out.println("Age in months: " + ageInMonths);
		System.out.println("Age in years: " + monthsToYears(ageInMonths));
		System.out.println("Temperature in Celsius: " + currentTempCelsius + DEGREE);
		System.out.println("Temperature in Fahrenheit: " + celsiusToFahrenheit(currentTempCelsius) + DEGREE);

	} // end main
} // end of class