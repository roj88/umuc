/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rolandcarter
 */
import keyboard.Keyboard;

public class KeyboardTest {
    public static void main(String args[]){
        Keyboard k = new Keyboard();
        
        // get current Keyboard state
        System.out.println("Keyboard State\n" + k.toString());
        
        // change keyboard volume and get state again
        k.powerState("on");
        k.changeVolume("HIGH");
        System.out.println("New Keyboard State\n" + k.toString());
        
    }
}
