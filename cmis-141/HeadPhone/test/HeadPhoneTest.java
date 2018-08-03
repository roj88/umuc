/**
 * filename: HeadPhoneTest.java
 * author: roland carter
 * date: 2018-07-28
 * purpose: cmis 141 hw3 test HeadPhone class
 */

// import headphone library
import headphone.HeadPhone;
import java.util.Scanner;

// HeadPhoneTest class
public class HeadPhoneTest {
    
    // start main method
    public static void main(String args[]){
        
        // user Scanner method to get user inputs
        Scanner s = new Scanner(System.in);
        
        // define variables for user imput
        int volume;
        boolean pluggedIn;
        String manufacturer;
        String colorAsString;
        String model;
        String volumeChangeLevel;
        
        
        // ask user for user inputs
        System.out.println("***Input***");
        System.out.print("Please enter a volume level (1, 2, or 3): ");
        volume = s.nextInt();
        
        System.out.print("Are the headphones plugged in? (true or false): ");
        pluggedIn = s.nextBoolean();
        
        // this line consumes the \n character from the enter key
        s.nextLine(); 
        
        System.out.print("Please enter your headphone manafacturer: ");
        manufacturer = s.nextLine();
        
        System.out.print("Please enter your headphone color: ");
        colorAsString = s.nextLine();
        
        System.out.print("Please enter your headphone model: ");
        model = s.nextLine();
        
        
        System.out.println("Please enter a volume level to change to (LOW, MEDIUM, HIGH):");
        volumeChangeLevel = s.nextLine();
        
        
        HeadPhone hp = new HeadPhone();
        HeadPhone hp1 = new HeadPhone(volume, pluggedIn, manufacturer, colorAsString, model);
        
        // print output
        System.out.println("***Output***");
        
        // print  default method
        System.out.println("Default Method\n" + hp + "\n");
        
        // print constructor
        System.out.println("Constructor\n" + hp1 + "\n");
        
        // print each get method
        System.out.println("Getter Methods\n" +
            "getVolume():" + hp1.getVolume() + "\n" +
                "getPluggedIn():" + hp1.getPluggedIn() + "\n" +
                                "getHeadPhoneColorString(): " + hp1.getHeadPhoneColorString() + "\n" +
                                        "getHeadPhoneModel(): " + hp1.getHeadPhoneModel() + "\n"
        );
        
        // change volume and reprint constructor
        hp1.changeVolume(volumeChangeLevel);
        System.out.println("Constructor after hp1.changeVolume(<variable>) \n" + hp1.toString() + "\n");
    } // end main method
    
} // end HeadPhone class
