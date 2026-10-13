/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comp258.programs;
import comp258.collections.ArrayManager;
import comp258.exceptions.NoItemsException;
import comp258.exceptions.OutOfBoundsException;
import comp258.framework.ConsoleProgram;
/**
 *
 * @author User
 */
public class ArrayManagerProgram extends ConsoleProgram {

    private ArrayManager myArrayManager;

    @Override
    public void startProgram() {
        System.out.println("PART 2");
        System.out.println("ARRAYMANAGER");

        int[] initialValues = {12, 7, 25, 4, 18, 30, 9, 14, 20};
        myArrayManager = new ArrayManager(initialValues);
    }

    @Override
    public int showMenu() {
        System.out.println("=============================");
        System.out.println("1. Display number of items");
        System.out.println("2. Display all items");
        System.out.println("3. Add an item");
        System.out.println("4. Add an item at a position");
        System.out.println("5. Remove an item");
        System.out.println(QUIT_OPTION + ". Return to launcher");

        return readInt("Enter your choice: ");
    }

    @Override
    public void executeAction(int choice) {
        switch (choice) {
            case 1:
                System.out.println(
                        "Number of items: " + myArrayManager.size());
                break;
            case 2:
                myArrayManager.print();
                break;
            case 3:
                addItem();
                break;
            case 4:
                addItemAtPosition();
                break;
            case 5:
                removeItem();
                break;
            default:
                System.out.println("Invalid menu option.");
                break;
        }
    }

    private void addItem() {
        int newItem = readInt("Enter an item to add: ");
        myArrayManager.add(newItem);
        System.out.println(newItem + " was added to the end.");
    }

    private void addItemAtPosition() {
        int itemToInsert = readInt("Enter an item to add: ");
        int insertPosition = readInt("Enter the position: ");

        try {
            myArrayManager.addAt(itemToInsert, insertPosition);
            System.out.println(itemToInsert
                    + " was added at index " + insertPosition + ".");
        } catch (OutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }

    private void removeItem() {
        int removePosition = readInt("Enter the position to remove: ");

        try {
            if (myArrayManager.isEmpty()) {
                myArrayManager.remove(removePosition);
            } else if (removePosition < 0
                    || removePosition >= myArrayManager.size()) {
                System.out.println("The position is outside the valid range.");
            } else {
                myArrayManager.remove(removePosition);
                System.out.println("The item at index "
                        + removePosition + " was removed.");
            }
        } catch (NoItemsException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void endProgram() {
        System.out.println("Leaving ArrayManager.");
    }
}
