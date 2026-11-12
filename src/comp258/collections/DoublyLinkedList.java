package comp258.collections;

/**
 * MIDTERM FIX (per instructor feedback):
 * - Moved into the shared comp258.collections package so it is used by the
 *   same ConsoleProgram framework and LabLauncher as the other labs.
 * - Made generic (<T>) instead of using Object, to match GenericLinkedList.
 * - advance() and previous() now return a boolean so the driver can tell
 *   the user whether the cursor actually moved.
 *
 * A doubly linked list with a cursor (current node). New items are
 * inserted beside the cursor and become the current item.
 *
 * @param <T> the type of value stored in the list
 * @author Md Alamgir Hossain
 */
public class DoublyLinkedList<T> {

    private ListNode2Way<T> items;     // first node (head)
    private ListNode2Way<T> current;   // cursor
    private ListNode2Way<T> lastItem;  // last node (tail)
    private int size;

    /** Creates an empty list. */
    public DoublyLinkedList() {
        items = null;
        current = null;
        lastItem = null;
        size = 0;
    }

    /**
     * Builds the list from an array. The cursor starts on the first item.
     * A null or empty array produces an empty list.
     * @param values the values to add in order
     */
    public DoublyLinkedList(T[] values) {
        this();
        if (values == null) {
            return;
        }
        for (T value : values) {
            addAfter(value);
        }
        current = items;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * @return the data in the current node, or null if the list is empty
     */
    public T getCurrent() {
        return current == null ? null : current.getData();
    }

    /**
     * Inserts a new node before the current node and makes it current.
     * On an empty list the new node becomes the only node.
     * @param nodeData the value to insert
     */
    public void addBefore(T nodeData) {
        ListNode2Way<T> newNode = new ListNode2Way<T>(nodeData);

        if (current == null) {
            items = newNode;
            lastItem = newNode;
        } else {
            newNode.setNext(current);
            newNode.setPrevious(current.getPrevious());

            if (current.getPrevious() == null) {
                items = newNode;                       // new head
            } else {
                current.getPrevious().setNext(newNode);
            }
            current.setPrevious(newNode);
        }
        current = newNode;
        size++;
    }

    /**
     * Inserts a new node after the current node and makes it current.
     * On an empty list the new node becomes the only node.
     * @param nodeData the value to insert
     */
    public void addAfter(T nodeData) {
        ListNode2Way<T> newNode = new ListNode2Way<T>(nodeData);

        if (current == null) {
            items = newNode;
            lastItem = newNode;
        } else {
            newNode.setPrevious(current);
            newNode.setNext(current.getNext());

            if (current.getNext() == null) {
                lastItem = newNode;                    // new tail
            } else {
                current.getNext().setPrevious(newNode);
            }
            current.setNext(newNode);
        }
        current = newNode;
        size++;
    }

    /**
     * Removes the current node. The cursor moves to the next node, or to the
     * previous node if the removed node was the last one.
     * @return the removed value, or null if the list was empty
     */
    public T removeCurrent() {
        if (current == null) {
            return null;
        }
        T removed = current.getData();

        if (current.getPrevious() == null) {
            items = current.getNext();
        } else {
            current.getPrevious().setNext(current.getNext());
        }

        if (current.getNext() == null) {
            lastItem = current.getPrevious();
        } else {
            current.getNext().setPrevious(current.getPrevious());
        }

        ListNode2Way<T> newCurrent = (current.getNext() != null)
                ? current.getNext() : current.getPrevious();

        // Detach the removed node.
        current.setNext(null);
        current.setPrevious(null);

        current = newCurrent;
        size--;
        return removed;
    }

    /**
     * Moves the cursor forward one node. Stays put at the end of the list.
     * @return true if the cursor moved
     */
    public boolean advance() {
        if (current != null && current.getNext() != null) {
            current = current.getNext();
            return true;
        }
        return false;
    }

    /**
     * Moves the cursor back one node. Stays put at the start of the list.
     * @return true if the cursor moved
     */
    public boolean previous() {
        if (current != null && current.getPrevious() != null) {
            current = current.getPrevious();
            return true;
        }
        return false;
    }

    /** Prints the list from first to last. */
    public void printForward() {
        StringBuilder sb = new StringBuilder("[");
        ListNode2Way<T> node = items;
        while (node != null) {
            sb.append(node.getData());
            if (node.getNext() != null) {
                sb.append(", ");
            }
            node = node.getNext();
        }
        System.out.println(sb.append("]"));
    }

    /** Prints the list from last to first using the previous links. */
    public void printBackwards() {
        StringBuilder sb = new StringBuilder("[");
        ListNode2Way<T> node = lastItem;
        while (node != null) {
            sb.append(node.getData());
            if (node.getPrevious() != null) {
                sb.append(", ");
            }
            node = node.getPrevious();
        }
        System.out.println(sb.append("]"));
    }
}
