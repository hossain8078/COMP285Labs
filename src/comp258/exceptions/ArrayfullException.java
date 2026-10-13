/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comp258.exceptions;

/**
 *
 * @author User
 */
public class ArrayfullException extends Exception {
   public ArrayfullException(){
        super ("Array is at full Capacity.");
        
    }
    public ArrayfullException(String errorMessage){
        super (errorMessage);
    }
    
}
