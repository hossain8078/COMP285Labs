/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab1consoleframework;

/**
 *
 * @author User
 */
public class ArrayfullException extends Exception {
    ArrayfullException(){
        super ("Array is at full Capacity.");
        
    }
    ArrayfullException(String errorMessage){
        super (errorMessage);
    }
    
}
