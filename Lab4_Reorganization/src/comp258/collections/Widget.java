/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comp258.collections;

/**
 *Represents an item with a name and price
 * Widgets are ordered by price
 * @author User
 */
public class Widget implements Comparable<Widget> {

    private String name;
    private double price;

    /**
     * Creates a Widget with the supplied name and price.
     * @param name the Widget's name
     * @param price the Widget's price
     */
    public Widget(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    /**
     * Compares this Widget's price with another Widget's price.
     * @param other the Widget to compare with
     * @return a negative value, zero, or a positive value when
     *         this price is lower, equal, or higher
     */
    @Override
    public int compareTo(Widget other) {
        return Double.compare(this.price, other.price);
    }

    /**
     * Provides readable output when the Widget is printed.
     * @return the name and price
     */
    @Override
    public String toString() {
        return String.format("%s ($%.2f)", name, price);
    }
}
