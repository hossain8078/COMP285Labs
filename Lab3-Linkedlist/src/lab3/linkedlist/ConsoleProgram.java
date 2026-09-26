<<<<<<< Updated upstream
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3.linkedlist;

import java.util.Scanner;

/**
 *
 * @author User
 */
public abstract class ConsoleProgram {

/** Reusable console framework: subclasses supply the menu and its actions. */
    protected static final int QUIT_OPTION = 0;
    private final Scanner input = new Scanner(System.in);

    public final void run() {
        startProgram();
        int choice;
        do {
            choice = showMenu();
            if (choice != QUIT_OPTION) {
                try { executeAction(choice); }
                catch (IllegalStateException | IndexOutOfBoundsException ex) {
                    System.out.println("Operation failed: " + ex.getMessage());
                }
            }
        } while (choice != QUIT_OPTION);
        endProgram();
    }

    protected int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = input.nextLine();
            try { return Integer.parseInt(line.trim()); }
            catch (NumberFormatException ex) { System.out.println("Please enter a whole number."); }
        }
    }

    protected void startProgram() { System.out.println("Linked List Lab"); }
    protected void endProgram() { System.out.println("Goodbye."); }
    public abstract int showMenu();
    public abstract void executeAction(int choice);
}

=======
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3.linkedlist;

import java.util.Scanner;

/**
 *
 * @author User
 */
public abstract class ConsoleProgram {

/** Reusable console framework: subclasses supply the menu and its actions. */
    protected static final int QUIT_OPTION = 0;
    private final Scanner input = new Scanner(System.in);

    public final void run() {
        startProgram();
        int choice;
        do {
            choice = showMenu();
            if (choice != QUIT_OPTION) {
                try { executeAction(choice); }
                catch (IllegalStateException | IndexOutOfBoundsException ex) {
                    System.out.println("Operation failed: " + ex.getMessage());
                }
            }
        } while (choice != QUIT_OPTION);
        endProgram();
    }

    protected int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = input.nextLine();
            try { return Integer.parseInt(line.trim()); }
            catch (NumberFormatException ex) { System.out.println("Please enter a whole number."); }
        }
    }

    protected void startProgram() { System.out.println("Linked List Lab"); }
    protected void endProgram() { System.out.println("Goodbye."); }
    public abstract int showMenu();
    public abstract void executeAction(int choice);
}

>>>>>>> Stashed changes
