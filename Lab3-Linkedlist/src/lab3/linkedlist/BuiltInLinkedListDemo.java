/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab3.linkedlist;
import java.util.LinkedList;

/**
 * Demonstrates the required operations using Java's built-in LinkedList.
 * @author User
 */
public class BuiltInLinkedListDemo {

    public static void main(String[] args) {
        LinkedList<Integer> numbers = new LinkedList<Integer>();

        numbers.add(12);
        numbers.add(7);
        numbers.add(25);
        numbers.add(4);
        numbers.add(18);

        System.out.println("1. Number of items: " + numbers.size());

        System.out.println("2. All items:");
        displayList(numbers);

        numbers.addLast(30);
        System.out.println("3. After adding 30 to the end:");
        displayList(numbers);

        numbers.add(2, 15);
        System.out.println("4. After adding 15 at index 2:");
        displayList(numbers);

        numbers.remove(4);
        System.out.println("5. After removing the item at index 4:");
        displayList(numbers);

        System.out.println("6. Item at index 3: " + numbers.get(3));

        numbers.set(0, 100);
        System.out.println("7. After replacing the item at index 0 with 100:");
        displayList(numbers);

        numbers.addFirst(50);
        System.out.println("8. After adding 50 to the front:");
        displayList(numbers);

        numbers.addLast(60);
        System.out.println("9. After adding 60 to the end:");
        displayList(numbers);

        numbers.removeFirst();
        System.out.println("10. After removing the first item:");
        displayList(numbers);

        numbers.removeLast();
        System.out.println("11. After removing the last item:");
        displayList(numbers);

        System.out.println("Final size: " + numbers.size());
    }
    // method to display/print the linkedlis
    private static void displayList(LinkedList<Integer> numbers) {
        System.out.print("[");
        boolean firstItem = true;
        // using enhanced loop to loop through the list
        for (Integer number : numbers) {
            if (!firstItem) {
                System.out.print(", ");
            }

            System.out.print(number);
            firstItem = false;
        }

        System.out.println("]");
    }
}
