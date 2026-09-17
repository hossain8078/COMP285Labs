/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilities;

/**
 *
 * @author User
 */
public class OutOfBoundsException extends Exception {
    public OutOfBoundsException() {
        super("The position is outside the valid range.");
    }
    public OutOfBoundsException(
            String errorMessage) {super(errorMessage);
    }
}    
