/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3.linkedlist;

/**
 *
 * @author User
 */
public class LinkedList {
   private ListNode items;   // Head: first node, or null for an empty list.
    private ListNode current; // Cursor: selected node, or null after deleting the last one.
    private int size;

    public LinkedList() { }

    /** Copies values into independent nodes; the array is never retained. */
    public LinkedList(int[] initialValues) {
        if (initialValues == null) throw new IllegalArgumentException("Input array is null");
        ListNode tail = null;
        for (int value : initialValues) {
            ListNode node = new ListNode(value);
            if (items == null) items = node;
            else tail.setNextNode(node);
            tail = node;
            size++;
        }
        current = items;
    }

    public int getSize() { return size; }
    public boolean hasCurrent() { return current != null; }
    public void start() { current = items; }

    public int getCurrent() {
        requireCurrent();
        return current.getData();
    }

    /** Returns false without changing the cursor at the end (or in an empty list). */
    public boolean advance() {
        if (current == null || current.getNextNode() == null) return false;
        current = current.getNextNode();
        return true;
    }

    public void addAfter(int value) {
        ListNode node = new ListNode(value);
        if (items == null) { items = node; current = node; }
        else {
            requireCurrent();
            // Link the new node to the remainder BEFORE changing current's link.
            node.setNextNode(current.getNextNode());
            current.setNextNode(node);
        }
        size++;
        // When nonempty, current stays on its original node.
    }

    public void addBefore(int value) {
        ListNode node = new ListNode(value);
        if (items == null) { items = node; current = node; }
        else {
            requireCurrent();
            node.setNextNode(current);
            if (current == items) items = node;
            else previous().setNextNode(node);
        }
        size++;
    }

    /** Removes current and selects its next node; if there is none, current becomes null. */
    public void deleteCurrent() {
        requireCurrent();
        ListNode next = current.getNextNode();
        if (current == items) items = next;
        else previous().setNextNode(next);
        current.setNextNode(null); // Disconnect the removed node.
        current = next;
        size--;
    }

    /** Zero-based access; reach an index by following next links from the head. */
    public int getItemAt(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index " + index + ", size " + size);
        ListNode cursor = items;
        for (int i = 0; i < index; i++) cursor = cursor.getNextNode();
        return cursor.getData();
    }

    public void print() {
        ListNode cursor = items; // Independent cursor: printing does not move current.
        System.out.print("[");
        while (cursor != null) {
            System.out.print(cursor.getData());
            cursor = cursor.getNextNode();
            if (cursor != null) System.out.print(", ");
        }
        System.out.println("]");
    }

    /** Conversion is allowed: nodes remain the internal storage. */
    public int[] toArray() {
        int[] copy = new int[size];
        ListNode cursor = items;
        for (int i = 0; i < size; i++) {
            copy[i] = cursor.getData();
            cursor = cursor.getNextNode();
        }
        return copy;
    }

    private void requireCurrent() {
        if (current == null) throw new IllegalStateException("No current node. Choose Start first, or add to an empty list.");
    }

    private ListNode previous() {
        ListNode cursor = items;
        while (cursor != null && cursor.getNextNode() != current) cursor = cursor.getNextNode();
        if (cursor == null) throw new IllegalStateException("Current node is not in this list");
        return cursor;
    }
}
