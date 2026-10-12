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

    // Holds the application selected by the user.
    // A ConsoleProgram reference can hold any of its child-class objects.
    private ConsoleProgram currentProgram;

    /**
     * Hook called once when the launcher starts.
     */
    @Override
    public void startProgram() {
        System.out.println("Welcome to the lab launcher.");
    }

    /**
     * Displays the available applications and reads the user's selection.
     *
     * @return the menu option entered by the user
     */
    @Override
    public int showMenu() {
        System.out.println("\n=============================");
        System.out.println("COMP 258 Labs");
        System.out.println("1. Random Number Program");
        System.out.println("2. Array Manager Program");
        System.out.println("3. Linked List Program");
        System.out.println(QUIT_OPTION + ". Quit");

        // Uses the framework method to read a valid integer.
        return readInt("Choose a program: ");
    }

    /**
     * Creates and runs the selected application.
     * The framework handles QUIT_OPTION before calling this method.
     *
     * @param choice the application selected by the user
     */
    @Override
    public void executeAction(int choice) {

        // Uses a plain switch to select the application.
        switch (choice) {
            case 1:
                currentProgram = new RandomNumberProgram();
                break;

            case 2:
                currentProgram = new ArrayManagerProgram();
                break;

            case 3:
                currentProgram = new LinkedListProgram();
                break;

            default:
                System.out.println("Invalid option. Choose 0 to 3.");

                // Stops this action without running an application.
                return;
        }

        // Runs the selected child class through the shared framework.
        // When that application exits, the launcher menu appears again.
        currentProgram.run();
    }

    /**
     * Hook called once when the user exits the launcher.
     */
    @Override
    public void endProgram() {
        System.out.println("Lab launcher closed.");
    }
}
