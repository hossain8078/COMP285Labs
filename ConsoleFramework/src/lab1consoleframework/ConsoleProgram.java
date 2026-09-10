/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab1consoleframework;
import java.util.Scanner;

/**
 * @author User
 */
public abstract class ConsoleProgram {
    protected Scanner input = new Scanner(System.in);
    protected static final int QUIT_OPTION = 0;

    /**
     * Controls the complete lifecycle of every console application that uses
     * this framework. this method is final because subclasses must not rewrite
     * the framework's run() method. Subclasses customize the program by
     * implementing the abstract methods and overriding hooks instead.
     */
    public final void run() {
        startProgram();
        int choice;
        do {
            choice = showMenu();
            // Do not execute an application action when Quit is selected.
            if (choice != QUIT_OPTION) {
                executeAction(choice);
            }
        } while (choice != QUIT_OPTION);
        endProgram();
    }
    
    /**
     * Displays the subclass's application-specific menu and obtains a choice.
     * every concrete subclass must implement this abstract framework method.
     * @return the menu choice entered by the user
     */
    public abstract int showMenu();

    public abstract void executeAction(int choice);

    //Hook called once before the menu loop begins.
    public void startProgram() {
        System.out.println("Program starting...");
    }

    //Hook called once after the user selects Quit.
    public void endProgram() {
        System.out.println("Program ended.");
    }

    //Hook that provides access to the framework's quit option.
    public int getQuitOption() {
        return QUIT_OPTION;
    }

    /**
     * Reads a whole number from the console. The method continues prompting
     * until the user enters a valid integer.
     * @param prompt message displayed before reading input
     * @return the valid integer entered by the user
     */
    protected int readInt(String prompt) {
        System.out.print(prompt);
        while (!input.hasNextInt()) {
            System.out.println("Please enter a whole number.");
            input.nextLine();
            System.out.print(prompt);
        }
        int value = input.nextInt();
        input.nextLine();
        return value;
    }

    /**
     * Reads a decimal number from the console. The method continues prompting
     * until the user enters a valid number.
     *
     * @param prompt message displayed before reading input
     * @return the valid double entered by the user
     */
    protected double readDouble(String prompt) {
        System.out.print(prompt);

        while (!input.hasNextDouble()) {
            System.out.println("Please enter a number.");
            input.nextLine();
            System.out.print(prompt);
        }
        double value = input.nextDouble();
        input.nextLine();
        return value;
    }

    /**
     * Reads a line of text from the console.
     *
     * @param prompt message displayed before reading input
     * @return the String entered by the user
     */
    protected String readString(String prompt) {
        System.out.print(prompt);
        return input.nextLine();
    }
}
