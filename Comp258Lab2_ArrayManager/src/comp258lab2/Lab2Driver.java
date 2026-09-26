<<<<<<< Updated upstream
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comp258lab2;

//import java.util.ArrayList;
import java.util.Scanner;
import utilities.ArrayManager;
import utilities.NoItemsException;
import utilities.OutOfBoundsException;

/**
 *
 * @author User
 */
public class Lab2Driver {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("PART 2");
        System.out.println("ARRAYMANAGER");

        // Create an ArrayManager containing nine integers.
        int[] initialValues = {12, 7, 25, 4, 18, 30, 9, 14, 20};
        ArrayManager myArrayManager = new ArrayManager(initialValues);

        int choice;
        do {
            displayMenu();
            choice = input.nextInt();
            choiceMenu(choice,myArrayManager,input);
        } while (choice != 6);
        input.close();
    }
    /**
     * Displays the ArrayManager menu.
     */
    private static void displayMenu() {
        System.out.println("=============================");
        System.out.println("1. Display number of items");
        System.out.println("2. Display all items");
        System.out.println("3. Add an item");
        System.out.println("4. Add an item at a position");
        System.out.println("5. Remove an item");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    /**
     * Processes the user's menu choice.
     * @param choice the user's menu selection
     * @param myarraymanager the ArrayManager object
     * @param input the Scanner used for input
     */
    private static void choiceMenu(int choice,ArrayManager myarraymanager,Scanner input) {
        switch (choice) {
            case 1:
                System.out.println("Number of items: "+ myarraymanager.size());
                break;
            case 2:
                myarraymanager.print();
                break;
            case 3:
                addItem(myarraymanager, input);
                break;
            case 4:
                addItemAtPosition(myarraymanager, input);
                break;
            case 5:
                removeItem(myarraymanager, input);
                break;
            case 6:
                System.out.println("Program ended.Thank you");
                break;
            default:
                System.out.println("Invalid menu option. "+ "Please select 1 to 6.");
        }
    }
    /**
     * Adds an item to the end of the ArrayManager.
     * @param manager the ArrayManager object
     * @param input the Scanner used for input
     */
    private static void addItem(ArrayManager myarraymanager,Scanner input) {
        System.out.print("Enter an item to add: ");
        int newItem = input.nextInt();
        myarraymanager.add(newItem);
        System.out.println(newItem + " was added to the end.");
    }

    /**
     * Adds an item at a specified position.
     * @param manager the ArrayManager object
     * @param input the Scanner used for input
     */
    private static void addItemAtPosition(ArrayManager myarraymanager,Scanner input) {
        System.out.print("Enter an item to add: ");
        int itemToInsert = input.nextInt();

        System.out.print("Enter the position: ");
        int insertPosition = input.nextInt();

        try {
            myarraymanager.addAt(itemToInsert,insertPosition);
            System.out.println(itemToInsert+ " was added at index "+ insertPosition + ".");
        } catch (OutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }
    /**
     * Removes an item at a specified position.
     * @param myarraymanager the ArrayManager object
     * @param input the Scanner used for input
     */
    private static void removeItem(ArrayManager myarraymanager,Scanner input) {

        System.out.print("Enter the position to remove: ");

        int removePosition = input.nextInt();

        try {
            /*
             * Calling remove() when empty allows
             * ArrayManager to throw NoItemsException.
             */
            if (myarraymanager.isEmpty()) {
                myarraymanager.remove(removePosition);

            } else if (removePosition < 0
                    || removePosition >= myarraymanager.size()) {

                System.out.println("The position is outside "+ "the valid range.");

            } else {
                myarraymanager.remove(removePosition);
                System.out.println("The item at index "+ removePosition+ " was removed.");
            }
        } catch (NoItemsException e) {
            System.out.println(e.getMessage());
        }
    }
=======
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comp258lab2;

//import java.util.ArrayList;
import java.util.Scanner;
import utilities.ArrayManager;
import utilities.NoItemsException;
import utilities.OutOfBoundsException;

/**
 *
 * @author User
 */
public class Lab2Driver {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("PART 2");
        System.out.println("ARRAYMANAGER");

        // Create an ArrayManager containing nine integers.
        int[] initialValues = {12, 7, 25, 4, 18, 30, 9, 14, 20};
        ArrayManager myArrayManager = new ArrayManager(initialValues);

        int choice;
        do {
            displayMenu();
            choice = input.nextInt();
            choiceMenu(choice,myArrayManager,input);
        } while (choice != 6);
        input.close();
    }
    /**
     * Displays the ArrayManager menu.
     */
    private static void displayMenu() {
        System.out.println("=============================");
        System.out.println("1. Display number of items");
        System.out.println("2. Display all items");
        System.out.println("3. Add an item");
        System.out.println("4. Add an item at a position");
        System.out.println("5. Remove an item");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    /**
     * Processes the user's menu choice.
     * @param choice the user's menu selection
     * @param myarraymanager the ArrayManager object
     * @param input the Scanner used for input
     */
    private static void choiceMenu(int choice,ArrayManager myarraymanager,Scanner input) {
        switch (choice) {
            case 1:
                System.out.println("Number of items: "+ myarraymanager.size());
                break;
            case 2:
                myarraymanager.print();
                break;
            case 3:
                addItem(myarraymanager, input);
                break;
            case 4:
                addItemAtPosition(myarraymanager, input);
                break;
            case 5:
                removeItem(myarraymanager, input);
                break;
            case 6:
                System.out.println("Program ended.Thank you");
                break;
            default:
                System.out.println("Invalid menu option. "+ "Please select 1 to 6.");
        }
    }
    /**
     * Adds an item to the end of the ArrayManager.
     * @param manager the ArrayManager object
     * @param input the Scanner used for input
     */
    private static void addItem(ArrayManager myarraymanager,Scanner input) {
        System.out.print("Enter an item to add: ");
        int newItem = input.nextInt();
        myarraymanager.add(newItem);
        System.out.println(newItem + " was added to the end.");
    }

    /**
     * Adds an item at a specified position.
     * @param manager the ArrayManager object
     * @param input the Scanner used for input
     */
    private static void addItemAtPosition(ArrayManager myarraymanager,Scanner input) {
        System.out.print("Enter an item to add: ");
        int itemToInsert = input.nextInt();

        System.out.print("Enter the position: ");
        int insertPosition = input.nextInt();

        try {
            myarraymanager.addAt(itemToInsert,insertPosition);
            System.out.println(itemToInsert+ " was added at index "+ insertPosition + ".");
        } catch (OutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }
    /**
     * Removes an item at a specified position.
     * @param myarraymanager the ArrayManager object
     * @param input the Scanner used for input
     */
    private static void removeItem(ArrayManager myarraymanager,Scanner input) {

        System.out.print("Enter the position to remove: ");

        int removePosition = input.nextInt();

        try {
            /*
             * Calling remove() when empty allows
             * ArrayManager to throw NoItemsException.
             */
            if (myarraymanager.isEmpty()) {
                myarraymanager.remove(removePosition);

            } else if (removePosition < 0
                    || removePosition >= myarraymanager.size()) {

                System.out.println("The position is outside "+ "the valid range.");

            } else {
                myarraymanager.remove(removePosition);
                System.out.println("The item at index "+ removePosition+ " was removed.");
            }
        } catch (NoItemsException e) {
            System.out.println(e.getMessage());
        }
    }
>>>>>>> Stashed changes
}