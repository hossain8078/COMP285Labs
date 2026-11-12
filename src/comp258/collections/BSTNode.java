package comp258.collections;

/**
 * A single node in a Binary Search Tree.
 * Values smaller than this node's data are stored in the left subtree;
 * values greater than or equal to it are stored in the right subtree.
 * All functional methods are recursive.
 *
 * @param <T> the type of value stored; must be Comparable
 * @author Md Alamgir Hossain
 */
public class BSTNode<T extends Comparable<T>> {

    private T data;
    private BSTNode<T> left;
    private BSTNode<T> right;

    /**
     * Creates a leaf node containing the supplied value.
     * @param data the value to store
     */
    public BSTNode(T data) {
        this.data = data;
    }

    // ---------- getters and setters ----------

    public void setData(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    // ---------- functional methods (recursive) ----------

    /**
     * Adds a value to the subtree rooted at this node.
     * compareTo() decides whether the value goes left or right.
     * @param newData the value to add
     */
    public void add(T newData) {
        if (newData.compareTo(data) < 0) {
            // Smaller values belong in the left subtree.
            if (left == null) {
                left = new BSTNode<T>(newData);   // base case
            } else {
                left.add(newData);                // recursive case
            }
        } else {
            // Larger or equal values belong in the right subtree.
            if (right == null) {
                right = new BSTNode<T>(newData);  // base case
            } else {
                right.add(newData);               // recursive case
            }
        }
    }

    /**
     * Checks whether a value exists in the subtree rooted at this node.
     * Only one branch is searched at each level.
     * @param target the value to look for
     * @return true if a matching value is found
     */
    public boolean searchTree(T target) {
        int comparison = target.compareTo(data);

        // Base case: match found.
        if (comparison == 0) {
            return true;
        }
        // Recursive cases: go left or right; a null child means not found.
        if (comparison < 0) {
            return left != null && left.searchTree(target);
        }
        return right != null && right.searchTree(target);
    }

    /**
     * Prints all values in ascending order (in-order traversal:
     * left subtree, this node, right subtree).
     */
    public void printTree() {
        if (left != null) {
            left.printTree();
        }
        System.out.println(data);
        if (right != null) {
            right.printTree();
        }
    }

    /**
     * Prints all values in descending order (reverse in-order traversal:
     * right subtree, this node, left subtree).
     */
    public void printTreeBackward() {
        if (right != null) {
            right.printTreeBackward();
        }
        System.out.println(data);
        if (left != null) {
            left.printTreeBackward();
        }
    }

    /**
     * Finds the smallest value by following left links.
     * @return the smallest value in this subtree
     */
    public T getSmallest() {
        // Base case: no left child, so this node is the smallest.
        if (left == null) {
            return data;
        }
        return left.getSmallest();
    }

    /**
     * Finds the largest value by following right links.
     * @return the largest value in this subtree
     */
    public T getLargest() {
        // Base case: no right child, so this node is the largest.
        if (right == null) {
            return data;
        }
        return right.getLargest();
    }

    /** Prints the smallest value in this subtree. */
    public void printSmallest() {
        System.out.println(getSmallest());
    }

    /** Prints the largest value in this subtree. */
    public void printLargest() {
        System.out.println(getLargest());
    }
}
