/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilities;
/**
 * @author User
 */
public class ArrayManager {
    private int[] items;
    private int count;

    //Creates an empty ArrayManager with a capacity of 10.
    public ArrayManager() {
        items = new int[10];
        count = 0;
    }

    /**
     * Creates an empty ArrayManager with the specified capacity.
     * @param capacity the capacity of the array
     */
    public ArrayManager(int capacity) {
        items = new int[capacity];
        count = 0;
    }
    /**
     * Creates an ArrayManager containing the supplied values.
     * @param values the starting values
     */
    public ArrayManager(int[] values) {
        items = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            items[i] = values[i];
        }
        count = values.length;
    }
    /**
     * Returns the number of stored items.
     * @return the number of items
     */
    public int size() {
        return count;
    }

    /**
     * Displays all managed items.
     * 
     */
    public void print() {
        if (isEmpty()) {
            System.out.println("The ArrayManager is empty.");
            return;
        }
        for (int i = 0; i < count; i++) {
            if (i == count - 1) {
                System.out.println(items[i]);
            } else {
                System.out.print(
                        items[i] + ", ");
            }
        }
    }
    /**
     * Adds an item to the end.
     * @param n the item to add
     */
    public void add(int n) {
        if (count >= items.length) {
            resizeArray();
        }
        items[count] = n;
        count += 1;
    }
    /**
     * Removes the item at the specified position.
     * @param position the position to remove
     * @throws NoItemsException if no items exist
     */
    public void remove(int position)
            throws NoItemsException {

        if (isEmpty()) {
            throw new NoItemsException();
        }
        // Shift later items to the left.
        for (int i = position; i < count - 1; i++) {
            items[i] = items[i + 1];
        }
        count -= 1;
    }
    /**
     * Adds an item at the specified position.
     * @param n the item to add
     * @param position the insertion position
     * @throws OutOfBoundsException if position is invalid
     */
    public void addAt(int n, int position)
            throws OutOfBoundsException {
        // Valid insertion positions are 0 through count.
        if (position < 0 || position > count) {
            throw new OutOfBoundsException();
        }
        if (count >= items.length) {
            resizeArray();
        }
        /*
         * Shift items to the right.
         * Start at the end to avoid losing data.
         */
        for (int i = count; i > position; i--) {
            items[i] = items[i - 1];
        }
        items[position] = n;
        count += 1;
    }
    /**
     * Checks whether the ArrayManager is empty.
     * @return true if empty; otherwise false
     */
    public boolean isEmpty() {
        return count == 0;
    }
    /**
     * Replaces the internal array with a new, larger array.
     */
    private void resizeArray() {
        int newCapacity;
        if (items.length == 0) {
            newCapacity = 1;
        } else {
            newCapacity = items.length * 2;
        }
        int[] largerArray = new int[newCapacity];
        for (int i = 0; i < count; i++) {
            largerArray[i] = items[i];
        }
        items = largerArray;
    }
}   
