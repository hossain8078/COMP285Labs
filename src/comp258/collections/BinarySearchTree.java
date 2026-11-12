package comp258.collections;

/**
 * A generic Binary Search Tree. This class manages the root and size and
 * delegates the recursive work to BSTNode.
 *
 * @param <T> the type of value stored; must be Comparable
 * @author Md Alamgir Hossain
 */
public class BinarySearchTree<T extends Comparable<T>> {

    private BSTNode<T> root;
    private int size;

    /** Creates an empty tree. */
    public BinarySearchTree() {
        root = null;
        size = 0;
    }

    // ---------- getters and setters ----------

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return root == null;
    }

    // ---------- functional methods ----------

    /**
     * Adds a value to the tree.
     * @param newData the value to add
     */
    public void add(T newData) {
        if (newData == null) {
            throw new IllegalArgumentException("Cannot add a null value.");
        }
        if (root == null) {
            root = new BSTNode<T>(newData);
        } else {
            root.add(newData);
        }
        size++;
    }

    /**
     * Checks whether a value exists in the tree.
     * @param target the value to look for
     * @return true if found, false otherwise
     */
    public boolean searchTree(T target) {
        if (root == null || target == null) {
            return false;
        }
        return root.searchTree(target);
    }

    /** Prints all values in ascending order. */
    public void printTree() {
        if (root == null) {
            System.out.println("The tree is empty.");
            return;
        }
        root.printTree();
    }

    /** Prints all values in descending order. */
    public void printTreeBackward() {
        if (root == null) {
            System.out.println("The tree is empty.");
            return;
        }
        root.printTreeBackward();
    }

    /** Prints the smallest value in the tree. */
    public void printSmallest() {
        if (root == null) {
            System.out.println("The tree is empty.");
            return;
        }
        root.printSmallest();
    }

    /** Prints the largest value in the tree. */
    public void printLargest() {
        if (root == null) {
            System.out.println("The tree is empty.");
            return;
        }
        root.printLargest();
    }

    /** @return the smallest value, or null when the tree is empty */
    public T getSmallest() {
        return root == null ? null : root.getSmallest();
    }

    /** @return the largest value, or null when the tree is empty */
    public T getLargest() {
        return root == null ? null : root.getLargest();
    }
}
