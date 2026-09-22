/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab2arraylistonly;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class Lab2ArrayListOnly {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("PART 2");
        System.out.println("ARRAYLIST MENU PROGRAM");

        // Create an ArrayList containing nine integers.
        ArrayList<Integer> numbers = new ArrayList<Integer>();

        numbers.add(12);
        numbers.add(7);
        numbers.add(25);
        numbers.add(4);
        numbers.add(18);
        numbers.add(30);
        numbers.add(9);
        numbers.add(14);
        numbers.add(20);

        int choice;

        do {
            displayMenu();
            choice = input.nextInt();

            choiceMenu(choice, numbers, input);

        } while (choice != 6);

        input.close();
    }

    /**
     * Displays the ArrayList menu.
     */
    private static void displayMenu() {

        System.out.println("\n=============================");
        System.out.println("1. Display number of items");
        System.out.println("2. Display all items");
        System.out.println("3. Add an item");
        System.out.println("4. Add an item at a position");
        System.out.println("5. Remove an item");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    /**
     * Processes the user's menu selection.
     *
     * @param choice user's menu selection
     * @param numbers the ArrayList of integers
     * @param input Scanner used for user input
     */
    private static void choiceMenu(
            int choice,
            ArrayList<Integer> numbers,
            Scanner input) {

        switch (choice) {

            case 1:
                System.out.println(
                        "Number of items: " + numbers.size()
                );
                break;

            case 2:
                displayItems(numbers);
                break;

            case 3:
                addItem(numbers, input);
                break;

            case 4:
                addItemAtPosition(numbers, input);
                break;

            case 5:
                removeItem(numbers, input);
                break;

            case 6:
                System.out.println("Program ended. Thank you.");
                break;

            default:
                System.out.println(
                        "Invalid menu option. Please select 1 to 6."
                );
        }
    }

    /**
     * Displays all items in the ArrayList.
     *
     * @param numbers the ArrayList of integers
     */
    private static void displayItems(ArrayList<Integer> numbers) {

        if (numbers.isEmpty()) {
            System.out.println("The ArrayList is empty.");
        } else {
            System.out.println("Items in the ArrayList:");

            for (int i = 0; i < numbers.size(); i++) {
                System.out.println(
                        "Index " + i + ": " + numbers.get(i)
                );
            }
        }
    }

    /**
     * Adds an item to the end of the ArrayList.
     *
     * @param numbers the ArrayList of integers
     * @param input Scanner used for user input
     */
    private static void addItem(
            ArrayList<Integer> numbers,
            Scanner input) {

        System.out.print("Enter an item to add: ");
        int newItem = input.nextInt();

        numbers.add(newItem);

        System.out.println(
                newItem + " was added to the end."
        );
    }

    /**
     * Adds an item at a specified position.
     *
     * @param numbers the ArrayList of integers
     * @param input Scanner used for user input
     */
    private static void addItemAtPosition(
            ArrayList<Integer> numbers,
            Scanner input) {

        System.out.print("Enter an item to add: ");
        int itemToInsert = input.nextInt();

        System.out.print("Enter the position: ");
        int insertPosition = input.nextInt();

        try {
            numbers.add(insertPosition, itemToInsert);

            System.out.println(
                    itemToInsert
                    + " was added at index "
                    + insertPosition
                    + "."
            );

        } catch (IndexOutOfBoundsException e) {
            System.out.println(
                    "The position is outside the valid range."
            );
        }
    }

    /**
     * Removes an item from a specified position.
     *
     * @param numbers the ArrayList of integers
     * @param input Scanner used for user input
     */
    private static void removeItem(
            ArrayList<Integer> numbers,
            Scanner input) {

        if (numbers.isEmpty()) {
            System.out.println(
                    "The ArrayList does not contain any items."
            );
            return;
        }

        System.out.print("Enter the position to remove: ");
        int removePosition = input.nextInt();

        try {
            int removedItem = numbers.remove(removePosition);

            System.out.println(
                    removedItem
                    + " was removed from index "
                    + removePosition
                    + "."
            );

        } catch (IndexOutOfBoundsException e) {
            System.out.println(
                    "The position is outside the valid range."
            );
        }
    }

}
