/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilities;

/**
 * @author User
 */
public class NoItemsException extends Exception {
    public NoItemsException() {
        super("There are no items to remove.");
    }
    public NoItemsException(String errorMessage) {
        super(errorMessage);
    }
}    
