/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comp258.collections;

/**
 *@param <T> the type of value stored in the node
 * Stores one value and a reference to the next node
 * @author User
 */
public class GenericNode<T> {
    private T data;
    private GenericNode<T> nextNode;

    /**
     * Creates a node containing the supplied value.
     * @param data the value to store
     */
    public GenericNode(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public GenericNode<T> getNextNode() {
        return nextNode;
    }

    public void setNextNode(GenericNode<T> nextNode) {
        this.nextNode = nextNode;
    }
}
