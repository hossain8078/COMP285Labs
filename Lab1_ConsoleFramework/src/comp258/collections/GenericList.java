/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comp258.collections;

/**
 *
 * @author User
 */
public class GenericList<T extends Comparable<T>> {

    // First node in the list.
    private GenericNode<T> items;

    // Currently selected node.
    private GenericNode<T> current;

    // Number of nodes in the list.
    private int size;

    /**
     * Creates an empty list.
     */
    public GenericList() {
    }

    /**
     * Copies array values into independent nodes in their original order.
     *
     * @param initialValues the values to insert
     */
    public GenericList(T[] initialValues) {
        if (initialValues == null) {
            throw new IllegalArgumentException("Input array is null.");
        }

        GenericNode<T> tail = null;

        for (T value : initialValues) {
            requireValue(value);
            GenericNode<T> node = new GenericNode<>(value);

            if (items == null) {
                items = node;
            } else {
                tail.setNextNode(node);
            }

            tail = node;
            size++;
        }

        current = items;
    }

    public int getSize() {
        return size;
    }

    public boolean hasCurrent() {
        return current != null;
    }

    /**
     * Selects the first node, or null if the list is empty.
     */
    public void start() {
        current = items;
    }

    /**
     * Returns the selected value.
     *
     * @return the current value
     * @throws IllegalStateException when no node is selected
     */
    public T getCurrent() {
        requireCurrent();
        return current.getData();
    }

    /**
     * Moves to the next node if one exists.
     * At the end, the current position remains unchanged.
     *
     * @return true if the current position moved
     */
    public boolean advance() {
        if (current == null || current.getNextNode() == null) {
            return false;
        }

        current = current.getNextNode();
        return true;
    }

    /**
     * Inserts after current without moving current.
     * In an empty list, the new node becomes current.
     *
     * @param value the value to insert
     */
    public void addAfter(T value) {
        requireValue(value);
        GenericNode<T> node = new GenericNode<>(value);

        if (items == null) {
            items = node;
            current = node;
        } else {
            requireCurrent();

            // Preserve the remaining chain before linking the new node.
            node.setNextNode(current.getNextNode());
            current.setNextNode(node);
        }

        size++;
    }

    /**
     * Inserts before current without moving current.
     * In an empty list, the new node becomes current.
     *
     * @param value the value to insert
     */
    public void addBefore(T value) {
        requireValue(value);
        GenericNode<T> node = new GenericNode<>(value);

        if (items == null) {
            items = node;
            current = node;
        } else {
            requireCurrent();
            node.setNextNode(current);

            if (current == items) {
                items = node;
            } else {
                previous().setNextNode(node);
            }
        }

        size++;
    }

    /**
     * Deletes current and selects its next node.
     * Deleting the tail leaves no current node.
     */
    public void deleteCurrent() {
        requireCurrent();
        GenericNode<T> next = current.getNextNode();

        if (current == items) {
            items = next;
        } else {
            previous().setNextNode(next);
        }

        // Disconnect the deleted node from the remaining chain.
        current.setNextNode(null);
        current = next;
        size--;
    }

    /**
     * Reads an item by zero-based index without moving current.
     *
     * @param index the position to read
     * @return the value at that position
     */
    public T getItemAt(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(
                    "Index " + index + ", size " + size);
        }

        GenericNode<T> cursor = items;

        for (int i = 0; i < index; i++) {
            cursor = cursor.getNextNode();
        }

        return cursor.getData();
    }

    /**
     * Finds the greatest value using compareTo().
     * Selects the node containing that value.
     * If several values tie, selects the first maximum.
     *
     * @return the maximum value, or null for an empty list
     */
    public T getMaximum() {
        if (items == null) {
            current = null;
            return null;
        }

        // Begin by treating the first node as the maximum.
        GenericNode<T> maximum = items;
        GenericNode<T> cursor = items.getNextNode();

        while (cursor != null) {

            // A positive result means cursor's value is greater.
            if (cursor.getData().compareTo(maximum.getData()) > 0) {
                maximum = cursor;
            }

            cursor = cursor.getNextNode();
        }

        // The lab requires current to move to the maximum node.
        current = maximum;
        return maximum.getData();
    }

    /**
     * Prints all values without moving current.
     */
    public void print() {
        GenericNode<T> cursor = items;
        System.out.print("[");

        while (cursor != null) {
            System.out.print(cursor.getData());
            cursor = cursor.getNextNode();

            if (cursor != null) {
                System.out.print(", ");
            }
        }

        System.out.println("]");
    }

    /**
     * Copies values into an Object array without moving current.
     * Nodes remain the list's internal storage.
     *
     * @return an independent array containing the list values
     */
    public Object[] toArray() {
        // Java does not allow creating an array with new T[size].
        Object[] copy = new Object[size];
        GenericNode<T> cursor = items;

        for (int i = 0; i < size; i++) {
            copy[i] = cursor.getData();
            cursor = cursor.getNextNode();
        }

        return copy;
    }

    /**
     * Rejects null values because they cannot be compared.
     */
    private void requireValue(T value) {
        if (value == null) {
            throw new IllegalArgumentException(
                    "Null values are not supported.");
        }
    }

    /**
     * Checks that a current node exists before using it.
     */
    private void requireCurrent() {
        if (current == null) {
            throw new IllegalStateException(
                    "No current node. Choose Start first, "
                    + "or add to an empty list.");
        }
    }

    /**
     * Finds the node immediately before current.
     */
    private GenericNode<T> previous() {
        GenericNode<T> cursor = items;

        while (cursor != null && cursor.getNextNode() != current) {
            cursor = cursor.getNextNode();
        }

        if (cursor == null) {
            throw new IllegalStateException(
                    "Current node is not in this list.");
        }

        return cursor;
    }
}
