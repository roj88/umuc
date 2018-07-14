/*
* file name: TestGuitar.java
* author: roland carter
* date: 2018-07-13
* purpose: cmis 141 homework assignment # 2 test for 
*          creating classes and methods
*/

// import required class(es)
import java.awt.Color;

// begin TestGuitar class
public class TestGuitar{
	public static void main(String[] args){

		// three Guitar class test cases
		Guitar g1 = new Guitar(7, 29.0, "Yamaha", "Blue");
		Guitar g2 = new Guitar(7, 31.2, "Gibson", "Red");
		Guitar g3 = new Guitar(6, 27.5, "Fender", "Black");


		// print out three test cases
		System.out.println("** Output **");
		System.out.println("toString():\n" + g1.toString());
		System.out.println("getNumStrings(): " + g1.getNumStrings());
		System.out.println("getGuitarLength():" + g1.getGuitarLength());
		System.out.println("getGuitarManufacturer(): " + g1.getGuitarManufacturer());
		System.out.println("getGuitarColorString():" + g1.getGuitarColorString());
		System.out.println("playGuitar():" + g1.playGuitar());

		System.out.println("\n\n");

		System.out.println("** Output **");
		System.out.println("toString():\n" + g2.toString());
		System.out.println("getNumStrings(): " + g2.getNumStrings());
		System.out.println("getGuitarLength():" + g2.getGuitarLength());
		System.out.println("getGuitarManufacturer(): " + g2.getGuitarManufacturer());
		System.out.println("getGuitarColorString():" + g2.getGuitarColorString());
		System.out.println("playGuitar():" + g2.playGuitar());

		System.out.println("\n\n");

		System.out.println("** Output **");
		System.out.println("toString():\n" + g3.toString());
		System.out.println("getNumStrings(): " + g3.getNumStrings());
		System.out.println("getGuitarLength():" + g3.getGuitarLength());
		System.out.println("getGuitarManufacturer(): " + g3.getGuitarManufacturer());
		System.out.println("getGuitarColorString():" + g3.getGuitarColorString());
		System.out.println("playGuitar():" + g3.playGuitar());

	} // end main method
} // end TestGuitar class