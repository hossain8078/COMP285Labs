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
        program.run();
    }

}
