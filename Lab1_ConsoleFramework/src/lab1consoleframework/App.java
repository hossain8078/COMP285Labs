/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab1consoleframework;

/**
 * @author User
 */
public class App {

    /**
     * Starts the RandomNumberProgram application. The application creates the
     * concrete subclass and then uses the framework's inherited run() method to control the program flow.
     * @param args command-line arguments are not used
     */
    public static void main(String[] args) {
        RandomNumberProgram program = new RandomNumberProgram();
        ArrayManager arrayManager= new ArrayManager(1);
        
        try{
            arrayManager.add(6);
            
        } catch (ArrayfullException e){
            System.out.println("Array is full:");
        }
        arrayManager.print();
        
         try{
            arrayManager.add(7);
            
        } catch (ArrayfullException e){
            System.out.println("Array is full:");
        }
        arrayManager.print();
//        
//        arrayManager.print();
//        arrayManager.add(6);
//        arrayManager.print();
//        arrayManager.add(7);
//        arrayManager.print();
//        
//        arrayManager.add(10);
        //program.run();
    }

}
