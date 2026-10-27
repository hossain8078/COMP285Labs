/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package comp258midterm;
import java.util.Scanner;
/*
 * Part 2 - Collection Questions
 
 * 1. When is a pointer-based collection a better choice?
 *
 * A doubly linked list is useful for a music playlist where songs are
 * frequently inserted or removed beside the current song. When the
 * current node is already known, insertion and removal take O(1) time
 * because only the links need updating. An array-based collection may
 * need to shift elements.
 =============================================
 * 2. When is an index-based collection a better choice?
 *
 * An array or ArrayList is useful when an application frequently
 * retrieves elements by their position, such as accessing a student
 * record using a known index. Indexed access takes O(1) time, while
 * accessing a position in a linked list requires traversal and takes
 * O(n) time in the worst case.
 ==============================================
 * 3. What would <T extends Comparable<T>> allow?
 *
 * This restricts T to a type that implements Comparable<T>. We can
 * therefore use compareTo() to compare two elements of type T using
 * their natural ordering.
 *
 * This supports implementing sorting, ordered insertion, and finding
 * the minimum or maximum element.

 * compareTo() returns:
 * - A negative number when the first element is smaller.
 * - Zero when the elements are equal in ordering.
 * - A positive number when the first element is larger.
 * Adding this type bound does not automatically sort the list.

 *
 * @author User
 */
public class App {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        DoublyLinkedList list = new DoublyLinkedList(
                new Object[]{"Volvo", "BMW", "Ford"}
        );

        boolean running = true;

        while (running) {
            System.out.println("\nDOUBLY LINKED LIST.");
            System.out.println("Size: " + list.getSize());

            if (list.getSize() == 0) {
                System.out.println("Current: (empty list)");
            } else {
                System.out.println("Current: " + list.getCurrent());
            }

            System.out.println("1. Add before current");
            System.out.println("2. Add after current");
            System.out.println("3. Remove current");
            System.out.println("4. Move forward");
            System.out.println("5. Move backward");
            System.out.println("6. Print forward");
            System.out.println("7. Print backward");
            System.out.println("8. Run edge-case demonstration");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            String choice = input.nextLine().trim();

            switch (choice) {
                case "1":
                    System.out.print("Enter a value: ");
                    list.addBefore(input.nextLine());
                    break;

                case "2":
                    System.out.print("Enter a value: ");
                    list.addAfter(input.nextLine());
                    break;

                case "3":
                    if (list.getSize() == 0) {
                        System.out.println("The list is empty.");
                    } else {
                        Object removed = list.getCurrent();
                        list.removeCurrent();
                        System.out.println("Removed: " + removed);
                    }
                    break;

                case "4":
                    list.advance();
                    System.out.println(
                            "Moved forward if a next node exists."
                    );
                    break;

                case "5":
                    list.previous();
                    System.out.println(
                            "Moved backward if a previous node exists."
                    );
                    break;

                case "6":
                    list.printForward();
                    break;

                case "7":
                    list.printBackwards();
                    break;

                case "8":
                    runEdgeCaseDemo();
                    break;

                case "0":
                    running = false;
                    System.out.println("Goodbye.");
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
                    break;
            }
        }

        input.close();
    }

    /**
     * Demonstrates boundary cases using a separate list.
     */
    private static void runEdgeCaseDemo() {
        System.out.println("\nEDGE-CASE DEMONSTRATION.");

        DoublyLinkedList demo = new DoublyLinkedList();

        System.out.println("\n1. Empty list operations");
        demo.removeCurrent();
        demo.advance();
        demo.previous();
        showState(demo);
        System.out.println("Expected: [], [], size 0, current null");

        System.out.println("\n2. Add before an empty list");
        demo.addBefore("B");
        showState(demo);
        System.out.println("Expected: [B], [B], size 1, current B");

        System.out.println("\n3. Insert before the first node");
        demo.addBefore("A");
        showState(demo);
        System.out.println("Expected: [A, B], [B, A], size 2, current A");

        System.out.println("\n4. Insert in the middle");
        demo.addAfter("X");
        showState(demo);
        System.out.println(
                "Expected: [A, X, B], [B, X, A], size 3, current X"
        );

        System.out.println("\n5. Remove the middle node");
        demo.removeCurrent();
        showState(demo);
        System.out.println("Expected: [A, B], [B, A], size 2, current B");

        System.out.println("\n6. Insert after the last node");
        demo.addAfter("C");
        showState(demo);
        System.out.println(
                "Expected: [A, B, C], [C, B, A], size 3, current C"
        );

        System.out.println("\n7. Move beyond the last node");
        demo.advance();
        showState(demo);
        System.out.println("Expected: current remains C");

        System.out.println("\n8. Remove the last node");
        demo.removeCurrent();
        showState(demo);
        System.out.println("Expected: [A, B], [B, A], size 2, current B");

        System.out.println("\n9. Move beyond the first node");
        demo.previous();
        demo.previous();
        showState(demo);
        System.out.println("Expected: current remains A");

        System.out.println("\n10. Remove the first node");
        demo.removeCurrent();
        showState(demo);
        System.out.println("Expected: [B], [B], size 1, current B");

        System.out.println("\n11. Remove the only remaining node");
        demo.removeCurrent();
        showState(demo);
        System.out.println("Expected: [], [], size 0, current null");

        System.out.println("\n12. Add after an empty list");
        demo.addAfter("D");
        showState(demo);
        System.out.println("Expected: [D], [D], size 1, current D");

        System.out.println("\n13. Build from an array");
        DoublyLinkedList numbers = new DoublyLinkedList(
                new Object[]{10, 20, 30}
        );
        showState(numbers);
        System.out.println(
                "Expected: [10, 20, 30], [30, 20, 10], "
                + "size 3, current 10"
        );

        System.out.println("\n14. Build from an empty array");
        showState(new DoublyLinkedList(new Object[0]));
        System.out.println("Expected: [], [], size 0, current null");

        System.out.println("\n15. Build from a null array");
        showState(new DoublyLinkedList((Object[]) null));
        System.out.println("Expected: [], [], size 0, current null");
    }

    private static void showState(DoublyLinkedList list) {
        list.printForward();
        list.printBackwards();
        System.out.println("Size: " + list.getSize());
        System.out.println("Current: " + list.getCurrent());
    }
}