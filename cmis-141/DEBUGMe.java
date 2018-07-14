/*
* File: DeBUGMe.java
* Author: Joan Rush
* Date: June 28, 2018
* Purpose: This program demonstrates the ability to create functioning code.
*/

import java.awt.Color;
import javax.swing.text.html.StyleSheet;

public class DEBUGMe{
public static void main(String[] args){
// Display a Welcome note

String text = "red";
 StyleSheet s = new StyleSheet();
Color c = s.stringToColor(text);

System.out.println(c);
}
}
