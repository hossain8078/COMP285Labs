/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comp258.programs;

import comp258.framework.ConsoleProgram;

/**
 *
 * @author User
 */
public class LabLauncher extends ConsoleProgram {
    // Parent-class reference holds the selected child application.
    private ConsoleProgram currentProgram;
    //Runs once when the launcher starts.
    @Override
    public void startProgram() {
        System.out.println("Welcome to the lab launcher.");
    }
    /**
     * Displays the main menu required for Lab 5.
     * @return the selected option, or QUIT_OPTION when exiting
     */
    @Override
    public int showMenu() {
        System.out.println("\n=============================");
        System.out.println("COMP 258 Labs");
        System.out.println("1. Manage data with ArrayManager");
        System.out.println("2. Manage data with LinkedList");
        System.out.println("3. Manage data with GenericLinkedList");
        System.out.println("4. Showcase Recursive Functions");
        System.out.println("5. Exit");

        int choice = readInt("Choose a program: ");
        // Keep prompting until a displayed option is selected.
        while (choice < 1 || choice > 5) {
            System.out.println("Invalid option. Choose 1 to 5.");
            choice = readInt("Choose a program: ");
        }

        // The framework requires 0 to end its menu loop.
        if (choice == 5) {
            return QUIT_OPTION;
        }
        return choice;
    }

    /**
     * Creates and runs the selected application.
     * @param choice the application selected by the user
     */
    @Override
    public void executeAction(int choice) {
        // Plain switch selects the appropriate child class.
        switch (choice) {

            case 1: currentProgram = new ArrayManagerProgram();
                break;
            case 2: currentProgram = new LinkedListProgram();
                break;
            case 3: currentProgram = new GenericListProgram();
                break;
            case 4:currentProgram = new RecursiveFunctionsApp();
                break;
            default:System.out.println("Invalid program selection.");
                return;
        }
        // Runs the selected application's framework lifecycle.
        // Its exit option returns control to this launcher.
        currentProgram.run();
    }
    // Runs once when the launcher closes.
    @Override
    public void endProgram() {
        System.out.println("Lab launcher closed.");
    }
}