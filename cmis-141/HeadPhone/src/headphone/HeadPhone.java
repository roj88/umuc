package headphone;

/**
 * filename: HeadPhone.java
 * author: roland carter
 * date: 2018-07-28
 * purpose: cmis 141 hw3 object oriented coding
 */


// import packages
import java.awt.Color;
import javax.swing.text.html.StyleSheet;

// begine HeadPhone class
public class HeadPhone {
    // set constants for headphone volume
    private final int LOW = 1;
    private final int MEDIUM = 2;
    private final int HIGH = 3;
    
    // declare private variables
    private int volume;
    private boolean pluggedIn;
    private String manufacturer;
    private Color headPhoneColor;
    private String headPhoneColorString;
    private String headPhoneModel;
    
    // default constructors
    public HeadPhone(){
        this.volume = MEDIUM;
        this.pluggedIn = false;
        this.manufacturer = "Beats";
        this.headPhoneModel = "v1.0";
        this.headPhoneColor = Color.red;
        this.headPhoneColorString = "red";
    }

    // constructor
    public HeadPhone(int volume, boolean pluggedIn, String manufacturer,
            String headPhoneColorString, String headPhoneModel){
        this.volume = volume;
        this.pluggedIn = pluggedIn;
        this.manufacturer = manufacturer;
        this.headPhoneModel = headPhoneModel;
        this.headPhoneColorString = headPhoneColorString;
        // convert string to color
        StyleSheet s = new StyleSheet();
        Color c;
        c = s.stringToColor(headPhoneColorString.toLowerCase());
        this.headPhoneColor = c;
    }
    
    
    
    /*
    * setter methods
    */

    public void setVolume(int volume){
            this.volume = volume;
    }

    public void setPluggedIn(boolean pluggedIn){
            this.pluggedIn = pluggedIn;
    }

    public void setManufacturer(String manufacturer){
            this.manufacturer = manufacturer;
    }

    public void setHeadPhoneColor(Color headPhoneColor){
            this.headPhoneColor = headPhoneColor;
    }

    public void setHeadPhoneModel(String headPhoneModel){
            this.headPhoneModel = headPhoneModel;
    }

    /*
    * getter methods
    */
    public int getVolume(){
            return volume;
    }

    public boolean getPluggedIn(){
            return pluggedIn;
    }

    public String getManufacturer(){
            return manufacturer;
    }

    public Color getHeadPhoneColor(){
             return headPhoneColor;
    }

    public String getHeadPhoneColorString(){
             return headPhoneColorString;
    }

    public String getHeadPhoneModel(){
            return headPhoneModel;
    }
    
    // this method changes the volume of the headphones
    public void changeVolume(String volumeRequested){
        if("LOW".equals(volumeRequested)){
        this.volume = LOW;
    }
        if("MEDIUM".equals(volumeRequested)){
        this.volume = MEDIUM;
    }
        if("HIGH".equals(volumeRequested)){
        this.volume = HIGH;
    }
    }
    
    // this method returns a string describing the current field values of
    // HeadPhones
    @Override
    public String toString(){
        return String.format("Volume: %s; PluggedIn: %s; Manufacturer: %s; HeadPhoneColor: %s; HeadPhoneModel: %s",
                getVolume(),
                getPluggedIn(),
                getManufacturer(),
                getHeadPhoneColorString(),
                getHeadPhoneModel());
    }
    
}
