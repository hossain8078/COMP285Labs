/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comp258midterm;

/**
 * 
 * @author User
 */
public class DoublyLinkedList {

    private ListNode2Way items;     // first node (head)
    private ListNode2Way current;   // cursor
    private ListNode2Way lastItem;  // last node (tail)
    private int size;

    public DoublyLinkedList() {
        items = null;
        current = null;
        lastItem = null;
        size = 0;
    }

    /**
     * Builds the list from an array. The cursor starts on the first item.
     * A null or empty array produces an empty list.
     */
    public DoublyLinkedList(Object[] items) {
        this();

        if (items == null) {
            return;
        }

        for (Object item : items) {
            addAfter(item);
        }

        current = this.items;
    }

    public int getSize() {
        return size;
    }

    /**
     * Returns the data in the current node, or null if the list is empty.
     */
    public Object getCurrent() {
        if (current == null) {
            return null;
        }
        return current.getData();
    }

    /**
     * Inserts a new node before the current node and makes it current.
     * On an empty list the new node becomes the only node.
     */
    public void addBefore(Object nodeData) {
        ListNode2Way newNode = new ListNode2Way(nodeData);

        if (current == null) {
            items = newNode;
            lastItem = newNode;
        } else {
            newNode.next = current;
            newNode.previous = current.previous;

            if (current.previous == null) {
                // inserting before the head
                items = newNode;
            } else {
                current.previous.next = newNode;
            }
            current.previous = newNode;
        }

        current = newNode;
        size++;
    }

    /**
     * Inserts a new node after the current node and makes it current.
     * On an empty list the new node becomes the only node.
     */
    public void addAfter(Object nodeData) {
        ListNode2Way newNode = new ListNode2Way(nodeData);

        if (current == null) {
            items = newNode;
            lastItem = newNode;
        } else {
            newNode.previous = current;
            newNode.next = current.next;

            if (current.next == null) {
                // inserting after the tail
                lastItem = newNode;
            } else {
                current.next.previous = newNode;
            }
            current.next = newNode;
        }

        current = newNode;
        size++;
    }

    //Removes the current node. The cursor moves to the next node, or to the previous node if the removed node was the last one. Does nothing on an empty list.
    public void removeCurrent() {
        if (current == null) {
            return;
        }

        if (current.previous == null) {
            items = current.next;
        } else {
            current.previous.next = current.next;
        }

        if (current.next == null) {
            lastItem = current.previous;
        } else {
            current.next.previous = current.previous;
        }

        ListNode2Way newCurrent =
                (current.next != null) ? current.next : current.previous;

        // detach the removed node
        current.next = null;
        current.previous = null;

        current = newCurrent;
        size--;
    }

    //Moves the cursor forward one node. Stays put at the end of the list.
    public void advance() {
        if (current != null && current.next != null) {
            current = current.next;
        }
    }

    /**
     * Moves the cursor back one node. Stays put at the start of the list.
     */
    public void previous() {
        if (current != null && current.previous != null) {
            current = current.previous;
        }
    }

    /**
     * Prints the list from first to last.
     */
    public void printForward() {
        StringBuilder sb = new StringBuilder("[");
        ListNode2Way node = items;

        while (node != null) {
            sb.append(node.getData());
            if (node.next != null) {
                sb.append(", ");
            }
            node = node.next;
        }

        sb.append("]");
        System.out.println(sb);
    }

    /**
     * Prints the list from last to first using the previous pointers.
     */
    public void printBackwards() {
        StringBuilder sb = new StringBuilder("[");
        ListNode2Way node = lastItem;

        while (node != null) {
            sb.append(node.getData());
            if (node.previous != null) {
                sb.append(", ");
            }
            node = node.previous;
        }

        sb.append("]");
        System.out.println(sb);
    }
}
