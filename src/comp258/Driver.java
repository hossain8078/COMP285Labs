/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comp258;
import comp258.framework.ConsoleProgram;
import comp258.programs.LabLauncher;

/**
 *
 * @author User
 */
public class Driver {

    /**
     * Starts the lab launcher.
     * @param args command-line arguments; not used in this application
     */
    public static void main(String[] args) {

        // Demonstrates polymorphism: the parent-class reference
        // holds a LabLauncher child-class object.
        ConsoleProgram app = new LabLauncher();

        // Starts the framework lifecycle:
        // startProgram(), menu loop, and endProgram().
        app.run();
    }
}