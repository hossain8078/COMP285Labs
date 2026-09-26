/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab3.linkedlist;

/**
 *
 * @author User
 */
public class LinkedListApp extends ConsoleProgram {
    private final LinkedList list = new LinkedList();

    @Override public int showMenu() {
        System.out.println("\n============================ MENU ============================");
        System.out.println(" 1. Add Before       4. Get Current       7. Advance");
        System.out.println(" 2. Add After        5. Get Item At       8. Start");
        System.out.println(" 3. Print            6. Delete Current    9. Run Test");
        System.out.println(" 0. Exit Program");
        return readInt("Select: ");
    }

    @Override public void executeAction(int choice) {
        switch (choice) {
            case 1:
                list.addBefore(readInt("Value: "));
                list.print();
                break;
            case 2:
                list.addAfter(readInt("Value: "));
                list.print();
                break;
            case 3:
                list.print();
                System.out.println("Size: " + list.getSize());
                break;
            case 4:
                System.out.println("Current value: " + list.getCurrent());
                break;
            case 5:
                System.out.println("Value: " + list.getItemAt(readInt("Zero-based index: ")));
                break;
            case 6:
                list.deleteCurrent();
                list.print();
                System.out.println("Current: " + (list.hasCurrent() ? list.getCurrent() : "none; choose Start"));
                break;
            case 7:
                System.out.println(list.advance() ? "Current: " + list.getCurrent() : "Cannot advance: at the end or no current node.");
                break;
            case 8:
                list.start();
                System.out.println(list.hasCurrent() ? "Current: " + list.getCurrent() : "List is empty.");
                break;
            case 9:
                runLinkedListTest();
                break;
            default:
                System.out.println("Choose a menu number from 0 to 9.");
                break;
        }
    }

    /** The eight-number test from page 4; uses a separate list. */
    public static void runLinkedListTest() {
        LinkedList test = new LinkedList();
        for (int value = 5; value <= 12; value++) {
            test.addAfter(value);
            test.advance(); // Move onto the newly inserted item before the next add.
        }
        System.out.print("Expected [5, 6, 7, 8, 9, 10, 11, 12]; actual ");
        test.print();
    }

    public static void main(String[] args) { 
        
        new LinkedListApp().run(); 
    
    }
}
