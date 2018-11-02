/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package errorexceptions;

/**
 *
 * @author rolandcarter
 */
public class ErrorExceptions{
    void a(){
        int integerA = "string value"; 
    }
    
    void b(){
        int integerB = a();
    }
    
    public static void main(String[] args) {
        try{
            System.out.println(b());
        } 
        catch (Exception e) { 
            System.out.println("...handled..."); 
        }
        finally{
            System.out.println("System will now exit");
            System.exit(0);
        }
    }
    
}
