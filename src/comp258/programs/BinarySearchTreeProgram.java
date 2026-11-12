package comp258.programs;

import comp258.collections.BinarySearchTree;
import comp258.collections.Widget;
import comp258.framework.ConsoleProgram;

/**
 * Lab 7: manages Widgets with a Binary Search Tree.
 * Widgets are ordered by price (see Widget.compareTo).
 *
 * @author Md Alamgir Hossain
 */
public class BinarySearchTreeProgram extends ConsoleProgram {

    private BinarySearchTree<Widget> tree;

    /**
     * Creates the tree and loads sample Widgets. The middle price is added
     * first, then the middle of each half, so the tree is well balanced:
     *
     *                 25.00
     *              /         \
     *          12.50          37.50
     *         /    \         /     \
     *      6.25   18.75   31.25   43.75
     */
    @Override
    public void startProgram() {
        System.out.println();
        System.out.println("===== LAB 7: BINARY SEARCH TREE =====");

        tree = new BinarySearchTree<Widget>();
        tree.add(new Widget("Gear", 25.00));
        tree.add(new Widget("Bolt", 12.50));
        tree.add(new Widget("Spring", 37.50));
        tree.add(new Widget("Nut", 6.25));
        tree.add(new Widget("Hinge", 18.75));
        tree.add(new Widget("Pulley", 31.25));
        tree.add(new Widget("Valve", 43.75));

        System.out.println(tree.getSize() + " sample widgets loaded.");
    }

    /**
     * Displays the BST menu. Option 7 is converted to QUIT_OPTION.
     */
    @Override
    public int showMenu() {
        System.out.println();
        System.out.println("1. Add item");
        System.out.println("2. Check if item exists");
        System.out.println("3. Print Binary Search Tree Forward");
        System.out.println("4. Print Binary Search Tree Backward");
        System.out.println("5. Print smallest item");
        System.out.println("6. Print largest item");
        System.out.println("7. Exit program");

        int choice = readInt("Choose an option: ");
        while (choice < 1 || choice > 7) {
            System.out.println("Please select an option from 1 to 7.");
            choice = readInt("Choose an option: ");
        }

        if (choice == 7) {
            return QUIT_OPTION;
        }
        return choice;
    }

    @Override
    public void executeAction(int choice) {
        switch (choice) {
            case 1: {
                String name = readString("Enter widget name: ");
                double price = readDouble("Enter widget price: ");
                Widget widget = new Widget(name, price);
                tree.add(widget);
                System.out.println("Added " + widget
                        + ". Tree size: " + tree.getSize());
                break;
            }
            case 2: {
                // Widgets are compared by price, so search by price.
                double price = readDouble("Enter the price to search for: ");
                Widget target = new Widget("search", price);
                if (tree.searchTree(target)) {
                    System.out.printf("A widget priced $%.2f exists in the tree.%n", price);
                } else {
                    System.out.printf("No widget priced $%.2f was found.%n", price);
                }
                break;
            }
            case 3:
                System.out.println("Widgets in ascending order:");
                tree.printTree();
                break;
            case 4:
                System.out.println("Widgets in descending order:");
                tree.printTreeBackward();
                break;
            case 5:
                System.out.print("Smallest item: ");
                tree.printSmallest();
                break;
            case 6:
                System.out.print("Largest item: ");
                tree.printLargest();
                break;
            default:
                System.out.println("Invalid menu option.");
                break;
        }
    }

    @Override
    public void endProgram() {
        System.out.println("Binary Search Tree program ended.");
    }
}
