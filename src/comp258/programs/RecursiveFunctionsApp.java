/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comp258.programs;
import comp258.collections.GenericLinkedList;
import comp258.framework.ConsoleProgram;
/**
 *
 * @author User
 * Demonstrates recursive mathematical and string-processing methods.
 */
public class RecursiveFunctionsApp extends ConsoleProgram {

    // List used to demonstrate recursive printing.
    private GenericLinkedList<Integer> numbers;

    /**
     * Creates the sample list before the menu starts.
     */
    @Override
    public void startProgram() {

        System.out.println();
        System.out.println("========== LAB 5: RECURSION ==========");

        Integer[] values = {10, 20, 30, 40, 50};
        numbers = new GenericLinkedList<Integer>(values);
    }

    /**
     * Displays the recursion menu.
     *
     * The framework uses 0 to stop its menu loop,
     * so menu option 8 is converted to QUIT_OPTION.
     */
    @Override
    public int showMenu() {

        System.out.println();
        System.out.println("1. Calculate factorial");
        System.out.println("2. Calculate powers");
        System.out.println("3. Check if a word is a palindrome");
        System.out.println("4. Print number's digit sum");
        System.out.println("5. Run Indent-o-tron");
        System.out.println("6. Print linked list with recursion");
        System.out.println("7. Print linked list backwards with recursion");
        System.out.println("8. Exit program");

        int choice = readInt("Choose an option: ");

        // Validate before returning a choice to the framework.
        while (choice < 1 || choice > 8) {
            System.out.println("Please select an option from 1 to 8.");
            choice = readInt("Choose an option: ");
        }

        if (choice == 8) {
            return QUIT_OPTION;
        }

        return choice;
    }

    /**
     * Executes the selected operation using a plain switch.
     * @param choice
     */
    @Override
    public void executeAction(int choice) {

        try {

            switch (choice) {

                case 1: {
                    int number = readInt("Enter a number from 0 to 12: ");

                    System.out.println(
                            number + "! = " + factorial(number));
                    break;
                }

                case 2: {
                    int base = readInt("Enter the base: ");
                    int exponent = readInt(
                            "Enter a non-negative exponent: ");

                    System.out.println(
                            base + " raised to " + exponent
                            + " = " + calculatePower(base, exponent));
                    break;
                }

                case 3: {
                    String word = readString("Enter a word: ");

                    if (isPalindrome(word)) {
                        System.out.println(
                                "\"" + word + "\" is a palindrome.");
                    } else {
                        System.out.println(
                                "\"" + word + "\" is not a palindrome.");
                    }

                    break;
                }

                case 4: {
                    int number = readInt("Enter an integer: ");

                    System.out.println(
                            "Digit sum = " + digitSum(number));
                    break;
                }

                case 5: {
                    int maximum = readInt(
                            "Enter the maximum call number: ");

                    indentoTron(maximum);
                    break;
                }

                case 6:
                    System.out.println("Linked list forward:");
                    numbers.printForward();
                    break;

                case 7:
                    System.out.println("Linked list backwards:");
                    numbers.printBackwards();
                    break;

                default:
                    System.out.println("Invalid menu option.");
                    break;
            }

        } catch (IllegalArgumentException ex) {

            System.out.println("Input error: " + ex.getMessage());

        } catch (ArithmeticException ex) {

            System.out.println("Calculation error: " + ex.getMessage());
        }
    }

    /**
     * Called when the recursion menu ends.
     */
    @Override
    public void endProgram() {
        System.out.println("Recursion program ended.");
    }

    /**
     * Calculates the factorial of a non-negative integer.
     */
    public int factorial(int n) {

        if (n < 0 || n > 12) {
            throw new IllegalArgumentException(
                    "Enter a number from 0 to 12.");
        }

        // Base case: 0! and 1! equal 1.
        if (n <= 1) {
            return 1;
        }

        // Recursive case: reduce the number by one.
        return n * factorial(n - 1);
    }

    /**
     * Calculates a base raised to a non-negative exponent.
     */
    public int calculatePower(int base, int exponent) {

        if (exponent < 0) {
            throw new IllegalArgumentException(
                    "The exponent must be zero or greater.");
        }

        // Base case.
        if (exponent == 0) {
            return 1;
        }

        // Recursive case.
        int smallerPower = calculatePower(base, exponent - 1);

        // Check the multiplication before converting to int.
        long result = (long) base * smallerPower;

        if (result > Integer.MAX_VALUE
                || result < Integer.MIN_VALUE) {

            throw new ArithmeticException(
                    "The answer is outside the int range.");
        }

        return (int) result;
    }

    /**
     * Wrapper: starts checking at the first and last characters.
     */
    public boolean isPalindrome(String word) {

        if (word == null) {
            throw new IllegalArgumentException(
                    "The word cannot be null.");
        }

        return isPalindrome(word, 0, word.length() - 1);
    }

    /**
     * Recursively checks matching characters from both ends.
     * Comparisons are case-sensitive.
     */
    public boolean isPalindrome(String word, int start, int end) {

        if (word == null) {
            throw new IllegalArgumentException(
                    "The word cannot be null.");
        }

        // Base case: all required pairs have been checked.
        if (start >= end) {
            return true;
        }

        // Stop immediately if a pair does not match.
        if (word.charAt(start) != word.charAt(end)) {
            return false;
        }

        // Recursive case: move both indexes toward the centre.
        return isPalindrome(word, start + 1, end - 1);
    }

    /**
     * Recursively adds the digits of an integer.
     * Negative integers are supported.
     */
    public int digitSum(int number) {

        // Base case: one digit remains.
        if (number > -10 && number < 10) {
            return Math.abs(number);
        }

        // Add the last digit to the sum of the remaining digits.
        return Math.abs(number % 10) + digitSum(number / 10);
    }

    /**
     * Wrapper: starts Indent-o-tron at call number 1.
     */
    public void indentoTron(int maxNum) {

        if (maxNum < 1) {
            throw new IllegalArgumentException(
                    "The maximum must be at least 1.");
        }

        indentoTron(1, maxNum);
    }

    /**
     * Prints before recursion and again during stack unwinding.
     */
    public void indentoTron(int currentNum, int maxNum) {

        // Base case: stop after the maximum call number.
        if (currentNum > maxNum) {
            return;
        }

        for (int i = 1; i < currentNum; i++) {
            System.out.print("    ");
        }

        System.out.println(
                "This was written by call number "
                + currentNum + ".");

        // Recursive case: move to the next call.
        indentoTron(currentNum + 1, maxNum);

        for (int i = 1; i < currentNum; i++) {
            System.out.print("    ");
        }

        // Runs after the deeper recursive call returns.
        System.out.println(
                "This ALSO written by call number "
                + currentNum + ".");
    }
}