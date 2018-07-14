/*
* file name: Guitar.java
* author: roland carter
* date: 2018-07-13
* purpose: cmis 141 homework assignment # 2 creating classes and methods
*/

// import required class(es)
import java.awt.Color;
import javax.swing.text.html.StyleSheet;


// create class Guitar
public class Guitar {

	// declare private variables
	private int numStrings;
	private double guitarLength;
	private String guitarManufacturer;
	private Color guitarColor;
	private String guitarColorString;


	// constructor
	public Guitar (int pNumStrings,
					double pGuitarLength, 
					String pGuitarManufacturer, 
					String pGuitarColor){
			numStrings = pNumStrings;
			guitarLength = pGuitarLength;
			guitarManufacturer = pGuitarManufacturer;
			guitarColorString = pGuitarColor;

			// convert string to color
			StyleSheet s = new StyleSheet();
			Color c = s.stringToColor(pGuitarColor.toLowerCase());
			guitarColor = c;

	}

	// Default constructor with defaul values
	public Guitar(){
		numStrings = 6;
		guitarLength = 28.2;
		guitarManufacturer = "Gibson";
		guitarColor = Color.red;
	}


	/*
	* this set of methods set the values for each variable
	*/

	public void setNumStrings(int pNumStrings){
		numStrings = pNumStrings;
	}

	public void setGuitarLength(int pGuitarLength){
		guitarLength = pGuitarLength;
	}

	public void setGuitarManufacturer(String pGuitarManufacturer){
		guitarManufacturer = pGuitarManufacturer;
	}

	public void setGuitarColor(Color pGuitarColor){
		guitarColor = pGuitarColor;
	}


	/*
	* this set of "getter" methods return variable values 
	*/

	public int getNumStrings(){
		return numStrings;
	}

	public double getGuitarLength(){
		return guitarLength;
	}

	public String getGuitarManufacturer(){
		return guitarManufacturer;
	}

	public Color getGuitarColor(){
		return guitarColor;
	}

	public String getGuitarColorString(){ //create human readable string of color
		return guitarColorString;
	}
	

	// this method returns a random string of notes and note values
	public String playGuitar(){
		 String notes = "[A(0.25), G(2), E(0.5), C(1), C(2), D(0.25), E(2), C(2), B(0.25), C(4), C(1), G(0.25),A(1), C(2), D(1),C(4)]";
		return notes;
	}

	// this method returns the variable inputs as a string
	public String toString(){

		String str = "(numStrings="+ getNumStrings() +
					",\nLength="+ getGuitarLength() +
					",\nmanufacturer="+ getGuitarManufacturer() +
					",\ncolor="+ getGuitarColorString() + ")";
		return str;
	}

} // end of class