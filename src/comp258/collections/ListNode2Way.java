package comp258.collections;

/**
 * MIDTERM FIX (per instructor feedback):
 * - Made generic (<T>) instead of storing Object, to match GenericNode.
 * - next/previous links are now private with getters and setters,
 *   consistent with the other node classes in this project.
 *
 * Stores one value and links to the next and previous nodes.
 *
 * @param <T> the type of value stored in the node
 * @author Md Alamgir Hossain
 */
public class ListNode2Way<T> {

    private T data;
    private ListNode2Way<T> next;
    private ListNode2Way<T> previous;

    /**
     * Creates a node containing the supplied value.
     * @param data the value to store
     */
    public ListNode2Way(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ListNode2Way<T> getNext() {
        return next;
    }

    public void setNext(ListNode2Way<T> next) {
        this.next = next;
    }

    public ListNode2Way<T> getPrevious() {
        return previous;
    }

    public void setPrevious(ListNode2Way<T> previous) {
        this.previous = previous;
    }
}
