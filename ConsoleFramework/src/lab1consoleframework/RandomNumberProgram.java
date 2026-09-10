/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab1consoleframework;
import java.util.Random;

/**
 * @author User
 */
public class RandomNumberProgram extends ConsoleProgram {
    //the array must contain exactly 20 elements
    private static final int ARRAY_SIZE = 20;
    //randomly generated values start at 1. 
    private static final int MIN_RANDOM_VALUE = 1;
    //randomly generated values end at 10 inclusive.
    private static final int MAX_RANDOM_VALUE = 10;
    //the numbers must be stored in an int[].
    private int[] numbers;
    //Generates the random values used to populate the array.
    private final Random random = new Random();
    /**
     * Initializes the array and displays the application heading.
     * Hook is used to create and initialize the array when the program starts.
     */
    @Override
    public void startProgram() {
        numbers = new int[ARRAY_SIZE];
        fillArray();
        System.out.println("================================");
        System.out.println("   Random Number Program  ");
        System.out.println("================================");
        System.out.println("Twenty random values from 1 to 10 have been generated.");
    }
    /**
     * Displays all required menu options and reads the user's choice.
     * QUIT_OPTION is inherited from ConsoleProgram and is used here instead of hard-coding the quit value.
     * @return the menu choice entered by the user
     */
    @Override
    public int showMenu() {
        System.out.println();
        System.out.println("1. Print Numbers");
        System.out.println("2. Search");
        System.out.println("3. Find and Replace");
        System.out.println(QUIT_OPTION + ". Quit");
        return readInt("Enter your choice: ");
    }
    /**
     * Executes the operation associated with the user's menu choice.
     * @param choice the user's menu choice
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
     * Displays the message shown after the framework ends the menu loop.
     */
    @Override
    public void endProgram() {
        System.out.println("Program ended.");
    }
    /**
     * Fills every position in the array with a random integer.
     * each value must be between 1 and 10 inclusive.
     * Adding MIN_RANDOM_VALUE converts Random's zero-based result to this range.
     */
    private void fillArray() {
        for (int index = 0; index < numbers.length; index++) {
            numbers[index] = random.nextInt(
                    MAX_RANDOM_VALUE - MIN_RANDOM_VALUE + 1)
                    + MIN_RANDOM_VALUE;
        }
    }
    /**
     * Displays every value currently stored in the array.
     * indexes remain zero-based internally, but positions
     * displayed to the user must be one-based. Therefore, index + 1 is shown.
     */
    private void printNumbers() {
        System.out.println();
        System.out.println("Numbers currently stored in the array:");
        for (int index = 0; index < numbers.length; index++) {
            System.out.println("Position " + (index + 1) + ": " + numbers[index]);
        }
    }

    /**
     * Asks for a number and reports the position of its first occurrence.
     * Search reports only the first occurrence. It calls findFirstOccurrence() so the search logic is not duplicated.
     */
    private void searchNumbers() {
        int valueToFind = readInt("Enter a number to search for: ");
        int index = findFirstOccurrence(valueToFind);
        //-1 internally means the value was not found.
        if (index == -1) {
            System.out.println(valueToFind + " was not found.");
        } else {
            // Convert the internal zero-based index to a one-based position.
            System.out.println(valueToFind + " was first found at position "
                    + (index + 1) + ".");
        }
    }

    /**
     * Finds the first occurrence of a value and replaces only that occurrence.
     * Find and Replace shares findFirstOccurrence() with Search instead of duplicating the linear-search logic.
     */
    private void findAndReplace() {
        int valueToFind = readInt("Enter the value to find: ");
        int replacementValue = readInt("Enter the replacement value: ");
        int index = findFirstOccurrence(valueToFind);
        if (index == -1) {
            System.out.println(valueToFind
                    + " was not found. No value was replaced.");
        } else {
            // Only the first occurrence returned by the shared search is changed.
            numbers[index] = replacementValue;
            System.out.println("The first occurrence of " + valueToFind
                    + " was replaced with " + replacementValue
                    + " at position " + (index + 1) + ".");
        }
    }

    /**
     * Performs a linear search from the first array element to the last.
     * Return immediately when the first occurrence is found.
     * Keep array indexes zero-based internally.
     * Return -1 when the target value is not found.
     * @param valueToFind the integer to locate in the array
     * @return the zero-based index of the first occurrence, or -1 if not found
     */
    private int findFirstOccurrence(int valueToFind) {
        for (int index = 0; index < numbers.length; index++) {
            if (numbers[index] == valueToFind) {
                return index;
            }
        }
        return -1;
    }
}
