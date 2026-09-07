/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package consoleprogram;
import java.util.Random;
/**
 *
 * @author User
 */
public class RandomNumberProgram extends Consoleprogram {
    private static final int ARRAY_SIZE = 20;
    private static final int MIN_RANDOM_VALUE = 1;
    private static final int MAX_RANDOM_VALUE = 10;
    private int[] numbers;
    private final Random random = new Random();

    /**
     * Initializes the array and displays the program heading. Requirement: The
     * framework's startProgram() hook must be used to create the array and fill
     * it with random values when the program starts.
     */
    @Override
    public void startProgram() {
        numbers = new int[ARRAY_SIZE];
        fillArray();
        System.out.println("===================================");
        System.out.println("    Random Number Array Manager");
        System.out.println("===================================");
        System.out.println("Twenty random values from 1 to 10 have been generated.");
    }
    /**
     * Displays the required menu and reads the user's choice. Requirement: The inherited QUIT_OPTION constant must be used instead of hard-coding the quit value.
     * @return the menu option selected by the user
     */
    @Override
    public int showMenu() {
        System.out.println();
        System.out.println("1. Print Numbers");
        System.out.println("2. Search");
        System.out.println("3. Find and Replace");
        System.out.println(QUIT_OPTION + ". Quit");
        return readInt("Select an option: ");
    }

    /**
     * Executes the action associated with the user's menu choice.
     * Requirement: This method implements the abstract executeAction(int choice) method defined by ConsoleProgram.
     * @param choice the menu option selected by the user
     */
    @Override
    public void executeAction(int choice) {
        switch (choice) {
            case 1:
                printNumbers();
                break;
            case 2:
                searchNumbers();
                break;
            case 3:
                findAndReplace();
                break;
            default:
                System.out.println("Invalid menu option. Please choose 0, 1, 2, or 3.");
        }
    }
    /**
     * Displays the message shown after the user selects Quit. This method
     * overrides the framework's endProgram() hook.
     */
    @Override
    public void endProgram() {
        System.out.println("Program ended.");
    }
    /**
     * Fills every array element with a random integer.
     * Requirement: All random values must be between 1 and 10 inclusive.
     */
    private void fillArray() {
        for (int index = 0; index < numbers.length; index++) {
            numbers[index] = random.nextInt(
                    MAX_RANDOM_VALUE - MIN_RANDOM_VALUE + 1)
                    + MIN_RANDOM_VALUE;
        }
    }

    /**
     * Displays all values currently stored in the array.
     * Requirement: - Array indexes must remain zero-based internally. -
     * Positions displayed to the user must be one-based.
     */
    private void printNumbers() {
        System.out.println();
        System.out.println("Numbers currently stored in the array:");
        for (int index = 0; index < numbers.length; index++) {
            System.out.println(
                    "Position " + (index + 1)
                    + ": " + numbers[index]);
        }
    }

    /**
     * Asks the user for a number and reports the position of its first occurrence.
     * The program must perform a linear search. Only the first occurrence must be reported. 
     * The shared search method must be reused.
     */
    private void searchNumbers() {
        int valueToFind = readInt("Enter a number to search for: ");
        int index = findFirstOccurrence(valueToFind);
        if (index == -1) {
            System.out.println(
                    valueToFind + " was not found.");
        } else {
            System.out.println(
                    valueToFind
                    + " was first found at position "
                    + (index + 1)
                    + ".");
        }
    }

    /**
     * Finds the first occurrence of a value and replaces it with another value.
     * Requirement: - Replace only the first occurrence. - Display the one-based
     * position where the replacement occurred. - Reuse the common search
     * method.
     */
    private void findAndReplace() {
        int valueToFind = readInt("Enter the value to find: ");
        int replacementValue = readInt("Enter the replacement value: ");
        int index = findFirstOccurrence(valueToFind);
        if (index == -1) {
            System.out.println(
                    valueToFind
                    + " was not found. No value was replaced.");
        } else {
            numbers[index] = replacementValue;
            System.out.println(
                    "The first occurrence of "
                    + valueToFind
                    + " was replaced with "
                    + replacementValue
                    + " at position "
                    + (index + 1)
                    + ".");
        }
    }
    /**
     * Performs a linear search through the numbers array.
     * Return only the first occurrence. Use zero-based indexes internally.
     * Return -1 when the value is not found. Reuse this method for Search and Find and Replace.
     * @param valueToFind the integer to locate in the array
     * @return the zero-based index of the first occurrence, or -1 when the value is not found
     */
    private int findFirstOccurrence(int valueToFind) {
        for (int index = 0; index < numbers.length; index++) {
            if (numbers[index] == valueToFind) {
                return index;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        RandomNumberProgram program = new RandomNumberProgram();
        program.run();
    }
}
