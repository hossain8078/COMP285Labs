/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comp258midterm;

/**
 *
 * @author User
 */
public class ListNode2Way {

    private Object data;
    public ListNode2Way next;
    public ListNode2Way previous;

    public ListNode2Way() {
        this(null);
    }

    public ListNode2Way(Object data) {
        this.data = data;
        this.next = null;
        this.previous = null;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
