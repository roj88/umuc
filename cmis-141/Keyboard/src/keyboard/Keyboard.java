package keyboard;

/**
 * filename: Keyboard.java
 * author: roland carter
 * date: 2018-07-28
 * purpose: cmis 141 discussion week 6
 */


// import packages
import java.awt.Color;
import javax.swing.text.html.StyleSheet;


public class Keyboard {
    private final int LOW = 1;
    private final int HIGH = 2;
    
    private int volume;
    private boolean isOn;
    private boolean notesPlaying;
    
public Keyboard (int volume, boolean isOn, boolean notesPlaying){
    this.volume = volume;
    this.isOn = isOn;
    this.notesPlaying = notesPlaying;
}

public Keyboard(){
    this.volume = LOW;
    this.isOn = false;
    this.notesPlaying = false;
}

// setter methods
public void setVolume(int volume){
    this.volume = volume;
}

public void setIsOn(boolean isOn){
    this.isOn = isOn;
}

public void setNotesPlaying(boolean notesPlaying){
    this.notesPlaying = notesPlaying;
}

// getter methods
public int getVolume(){
    return volume;
}

public boolean getIsOn(){
    return isOn;
}

public boolean getNotesPlaying(){
    return notesPlaying;
}


// turn volume up
public void changeVolume(String desiredVolume){
    if("LOW".equals(desiredVolume)){
        this.volume = LOW;
    }
    else{
        this.volume = HIGH;
    }
}

// turn the keyboard off and on
public void powerState(String desiredPowerState){
    if("off".equals(desiredPowerState)){
        this.isOn = false;
    }
    else if("on".equals(desiredPowerState)){
        this.isOn = true;
    }
}

    @Override
public String toString(){
    return String.format("Volume: %s\nKeyboard On: %s\nAre Notes Playing: %s\n",
            getVolume(),
            getIsOn(),
            getNotesPlaying()
    );
}
    
}
