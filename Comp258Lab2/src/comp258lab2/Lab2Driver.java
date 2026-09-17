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

//        /*
//         * Part 1: Working with ArrayList
//         */
//        System.out.println("Part 1");
//        System.out.println("ARRAYLIST");
//        ArrayList<Integer> numbers = new ArrayList<Integer>();
//
//        numbers.add(12);
//        numbers.add(7);
//        numbers.add(25);
//        numbers.add(4);
//        numbers.add(18);
//
//        // 1. Display the number of items.
//        System.out.println("Number of items: " + numbers.size());
//        // 2. Display all items using a loop.
//        System.out.println("Starting items:");
//
//        for (int i = 0; i < numbers.size(); i++) {
//            System.out.println("#" + i + ": " + numbers.get(i));
//        }
//        // 3. Add 30 to the end.
//        numbers.add(30);
//
//        System.out.println("Update array list after adding 30: " + numbers);
//
//        // 4. Insert 15 at index 2.
//        numbers.add(2, 15);
//        System.out.println("Update array list after inserting 15 at index 2: " + numbers);
//
//        // 5. Remove the item at index 4.
//        numbers.remove(4);
//
//        System.out.println("Update array list after removing the item at index 4: " + numbers);
//
//        // 6. Display the item stored at index 3.
//        System.out.println("Item at index 3: " + numbers.get(3));
//        
//        // 7. Change the item at index 0 to 100.
//        numbers.set(0, 100);
//        System.out.println("Update array list after changing index 0 to 100: "+ numbers);
//
//        // 8. Display the completed ArrayList.
//        System.out.println("Final ArrayList: " + numbers);
//
//        
        /*
         * Part 2: Working with ArrayManager
         */
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
}
///**
// *
// * @author User
// */
//public class Main {
//
//    /**
//     * 12, 7, 25, 4, 18  
//
//     * @param args the command line arguments
//     */
//    public static void main(String[] args) {
//        
//        // TODO code application logic here
//        ArrayList<Integer> numbers = new ArrayList<Integer>();
//        
//        numbers.add(12);
//        numbers.add(7);
//        numbers.add(25);
//        numbers.add(444);
//        numbers.add(18);
//        numbers.add(50);
//        
////1. Display the number of items  in the ArrayList. 
//System.out.println("Item count:" +numbers.size());
////2. Use a loop to display all of the items. 
//for (int i=0; i<numbers.size();i++){
//    System.out.println(i+ ":"+numbers.get(i)+",");
//}
////3. Add the value 30 to the end of the list. 
//numbers.add(30);
//
////4. Insert the value 15 at index 2. 
//numbers.add(2,15);
////5. Remove the item at index 4. 
//numbers.remove(4);
////6. Display the item stored at index 3. 
//System.out.println("Items[3]"+numbers.get(3));
////7. Change the item at index 0 to 100. 
//numbers.set(0,100);
////8. Display the completed ArrayList.
//System.out.println("ArrayList: "+numbers);
//
////bonus create a new Arraylist with String, not integers
//     ArrayList <String> names = new ArrayList<String>();
//     names.add("Jone");
//     names.add("Jane");
//        System.out.println("names : "+names);
//        
//    }
//    
//}
