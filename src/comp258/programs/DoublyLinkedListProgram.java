package comp258.programs;

import comp258.collections.DoublyLinkedList;
import comp258.framework.ConsoleProgram;

/**
 * MIDTERM FIX (per instructor feedback:
 * "some inconsistencies in driver; no reusable ConsoleProgram framework"):
 * - The midterm driver previously ran everything inside main() with its own
 *   Scanner, while loop and String switch. It now extends the reusable
 *   ConsoleProgram framework: run() controls the lifecycle and this class
 *   only implements startProgram(), showMenu(), executeAction() and
 *   endProgram(), the same as the other lab programs.
 * - Input now uses the framework's readInt()/readString() with range
 *   validation, instead of reading the choice as a String.
 * - Exit is now the last menu number (9), consistent with the other
 *   programs, instead of 0. Exiting returns to the LabLauncher.
 * - The program is launched from LabLauncher (option 6) instead of having
 *   its own separate main() method.
 * - Move forward/backward now report whether the cursor actually moved.
 * - The Part 2 written answers were moved out of the driver's comments
 *   into the comment at the top of comp258.collections.DoublyLinkedList.
 *
 * @author Md Alamgir Hossain
 */
public class DoublyLinkedListProgram extends ConsoleProgram {

    private DoublyLinkedList<String> list;

    /** Creates the sample list before the menu starts. */
    @Override
    public void startProgram() {
        System.out.println();
        System.out.println("===== MIDTERM: DOUBLY LINKED LIST =====");
        list = new DoublyLinkedList<String>(
                new String[]{"Volvo", "BMW", "Ford"});
    }

    /**
     * Displays the menu. Option 9 is converted to QUIT_OPTION.
     */
    @Override
    public int showMenu() {
        System.out.println();
        System.out.println("Size: " + list.getSize());
        System.out.println("Current: "
                + (list.isEmpty() ? "(empty list)" : list.getCurrent()));
        System.out.println("1. Add before current");
        System.out.println("2. Add after current");
        System.out.println("3. Remove current");
        System.out.println("4. Move forward");
        System.out.println("5. Move backward");
        System.out.println("6. Print forward");
        System.out.println("7. Print backward");
        System.out.println("8. Run edge-case demonstration");
        System.out.println("9. Exit program");

        int choice = readInt("Choose an option: ");
        while (choice < 1 || choice > 9) {
            System.out.println("Please select an option from 1 to 9.");
            choice = readInt("Choose an option: ");
        }

        if (choice == 9) {
            return QUIT_OPTION;
        }
        return choice;
    }

    @Override
    public void executeAction(int choice) {
        switch (choice) {
            case 1:
                list.addBefore(readString("Enter a value: "));
                System.out.println("Added before. Current: " + list.getCurrent());
                break;
            case 2:
                list.addAfter(readString("Enter a value: "));
                System.out.println("Added after. Current: " + list.getCurrent());
                break;
            case 3:
                if (list.isEmpty()) {
                    System.out.println("The list is empty.");
                } else {
                    System.out.println("Removed: " + list.removeCurrent());
                }
                break;
            case 4:
                if (list.advance()) {
                    System.out.println("Moved forward to: " + list.getCurrent());
                } else {
                    System.out.println("Already at the end of the list.");
                }
                break;
            case 5:
                if (list.previous()) {
                    System.out.println("Moved backward to: " + list.getCurrent());
                } else {
                    System.out.println("Already at the start of the list.");
                }
                break;
            case 6:
                list.printForward();
                break;
            case 7:
                list.printBackwards();
                break;
            case 8:
                runEdgeCaseDemo();
                break;
            default:
                System.out.println("Invalid menu option.");
                break;
        }
    }

    @Override
    public void endProgram() {
        System.out.println("Doubly linked list program ended.");
    }

    /** Demonstrates boundary cases using a separate list. */
    private void runEdgeCaseDemo() {
        System.out.println("\nEDGE-CASE DEMONSTRATION");
        DoublyLinkedList<String> demo = new DoublyLinkedList<String>();

        System.out.println("\n1. Empty list operations");
        demo.removeCurrent();
        demo.advance();
        demo.previous();
        showState(demo, "[], [], size 0, current null");

        System.out.println("\n2. Add before on an empty list");
        demo.addBefore("B");
        showState(demo, "[B], [B], size 1, current B");

        System.out.println("\n3. Insert before the first node");
        demo.addBefore("A");
        showState(demo, "[A, B], [B, A], size 2, current A");

        System.out.println("\n4. Insert in the middle");
        demo.addAfter("X");
        showState(demo, "[A, X, B], [B, X, A], size 3, current X");

        System.out.println("\n5. Remove the middle node");
        demo.removeCurrent();
        showState(demo, "[A, B], [B, A], size 2, current B");

        System.out.println("\n6. Insert after the last node");
        demo.addAfter("C");
        showState(demo, "[A, B, C], [C, B, A], size 3, current C");

        System.out.println("\n7. Move beyond the last node");
        demo.advance();
        showState(demo, "current remains C");

        System.out.println("\n8. Remove the last node");
        demo.removeCurrent();
        showState(demo, "[A, B], [B, A], size 2, current B");

        System.out.println("\n9. Move beyond the first node");
        demo.previous();
        demo.previous();
        showState(demo, "current remains A");

        System.out.println("\n10. Remove the first node");
        demo.removeCurrent();
        showState(demo, "[B], [B], size 1, current B");

        System.out.println("\n11. Remove the only remaining node");
        demo.removeCurrent();
        showState(demo, "[], [], size 0, current null");

        System.out.println("\n12. Add after on an empty list");
        demo.addAfter("D");
        showState(demo, "[D], [D], size 1, current D");

        System.out.println("\n13. Build from an array");
        showState(new DoublyLinkedList<Integer>(new Integer[]{10, 20, 30}),
                "[10, 20, 30], [30, 20, 10], size 3, current 10");

        System.out.println("\n14. Build from an empty array");
        showState(new DoublyLinkedList<String>(new String[0]),
                "[], [], size 0, current null");

        System.out.println("\n15. Build from a null array");
        showState(new DoublyLinkedList<String>(null),
                "[], [], size 0, current null");
    }

    private <E> void showState(DoublyLinkedList<E> demoList, String expected) {
        demoList.printForward();
        demoList.printBackwards();
        System.out.println("Size: " + demoList.getSize());
        System.out.println("Current: " + demoList.getCurrent());
        System.out.println("Expected: " + expected);
    }
}
