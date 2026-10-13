/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comp258.programs;
import comp258.collections.GenericList;
import comp258.collections.Widget;
import comp258.framework.ConsoleProgram;
/**
 *
 * @author User
 */
public class GenericListProgram extends ConsoleProgram {

    private GenericList<Widget> list;

    /**
     * Starts each run with an empty list.
     */
    @Override
    public void startProgram() {
        list = new GenericList<>();
        System.out.println("GENERIC LIST PROGRAM");
        System.out.println("The Widget list is initially empty.");
    }

    @Override
    public int showMenu() {
        System.out.println("\n=============================");
        System.out.println("1. Print list");
        System.out.println("2. Get maximum");
        System.out.println("3. Get current");
        System.out.println("4. Advance");
        System.out.println("5. Remove current");
        System.out.println("6. Add Widget after current");
        System.out.println("7. Start at first item");
        System.out.println("8. Run all tests");
        System.out.println(QUIT_OPTION + ". Return to launcher");

        return readInt("Select: ");
    }

    /**
     * Handles menu actions and reports invalid cursor operations.
     */
    @Override
    public void executeAction(int choice) {
        try {
            switch (choice) {
                case 1:
                    list.print();
                    System.out.println("Size: " + list.getSize());
                    break;

                case 2:
                    Widget maximum = list.getMaximum();
                    System.out.println("Maximum: " + maximum);

                    if (list.hasCurrent()) {
                        System.out.println(
                                "Current: " + list.getCurrent());
                    }
                    break;

                case 3:
                    System.out.println("Current: " + list.getCurrent());
                    break;

                case 4:
                    if (list.advance()) {
                        System.out.println(
                                "Current: " + list.getCurrent());
                    } else {
                        System.out.println(
                                "Cannot advance: no current or at the end.");
                    }
                    break;

                case 5:
                    list.deleteCurrent();
                    list.print();
                    break;

                case 6:
                    addWidget();
                    break;

                case 7:
                    list.start();

                    if (list.hasCurrent()) {
                        System.out.println(
                                "Current: " + list.getCurrent());
                    } else {
                        System.out.println("List is empty.");
                    }
                    break;

                case 8:
                    runTests();
                    break;

                default:
                    System.out.println("Choose an option from 0 to 8.");
                    break;
            }
        } catch (IllegalStateException e) {
            // Empty-list and missing-current operations do not crash the app.
            System.out.println(e.getMessage());
        }
    }

    /**
     * Reads a Widget and inserts it after the selected node.
     */
    private void addWidget() {
        // A nonempty list can have no current after deleting its tail.
        if (list.getSize() > 0 && !list.hasCurrent()) {
            System.out.println("Choose Start before adding a Widget.");
            return;
        }

        String name = readString("Widget name: ");
        double price = readDouble("Widget price: ");

        list.addAfter(new Widget(name, price));
        list.print();
    }

    /**
     * Runs tests using separate lists, leaving the menu list unchanged.
     */
    private void runTests() {
        testEmptyList();
        testIntegers();
        testStrings();
        testWidgets();
    }

    /**
     * Checks all five required operations on an empty list.
     */
    private void testEmptyList() {
        System.out.println("\n--- Empty-list tests ---");
        GenericList<Widget> empty = new GenericList<>();

        System.out.print("Empty list: ");
        empty.print();

        check("Empty size is zero", empty.getSize() == 0);
        check("Empty maximum is null", empty.getMaximum() == null);
        check("Empty list has no current", !empty.hasCurrent());
        check("Empty advance returns false", !empty.advance());

        boolean currentRejected = false;

        try {
            empty.getCurrent();
        } catch (IllegalStateException e) {
            currentRejected = true;
        }

        check("Empty getCurrent is handled", currentRejected);

        boolean removalRejected = false;

        try {
            empty.deleteCurrent();
        } catch (IllegalStateException e) {
            removalRejected = true;
        }

        check("Empty removal is handled", removalRejected);
        check("Empty removal leaves size zero", empty.getSize() == 0);
    }

    /**
     * Checks numeric ordering, insertion, and cursor movement.
     */
    private void testIntegers() {
        System.out.println("\n--- Integer tests ---");

        Integer[] values = {12, 7, 30, 4};
        GenericList<Integer> numbers = new GenericList<>(values);

        numbers.print();
        check("Integer maximum is 30", numbers.getMaximum() == 30);
        check("Current moves to 30", numbers.getCurrent() == 30);

        numbers.addBefore(25);
        numbers.addAfter(35);

        check("25 inserted before maximum",
                numbers.getItemAt(2) == 25);
        check("35 inserted after maximum",
                numbers.getItemAt(4) == 35);
        check("Insertion preserves current",
                numbers.getCurrent() == 30);
        check("New maximum is 35", numbers.getMaximum() == 35);
        check("Current moves to 35", numbers.getCurrent() == 35);

        numbers.deleteCurrent();
        check("Removal selects next value",
                numbers.getCurrent() == 4);
        check("Size after removal is five", numbers.getSize() == 5);

        // Negative values verify that maximum is not initialized to zero.
        GenericList<Integer> negatives =
                new GenericList<>(new Integer[]{-9, -2, -15});

        check("Negative maximum is -2", negatives.getMaximum() == -2);
    }

    /**
     * Checks String ordering using compareTo().
     */
    private void testStrings() {
        System.out.println("\n--- String tests ---");

        GenericList<String> words =
                new GenericList<>(new String[]{"Apple", "Zebra", "Banana"});

        words.print();
        check("String maximum is Zebra",
                "Zebra".equals(words.getMaximum()));
        check("Current moves to Zebra",
                "Zebra".equals(words.getCurrent()));

        words.print();
        check("Printing preserves current",
                "Zebra".equals(words.getCurrent()));
    }

    /**
     * Checks Widget insertion, price comparisons, ties, and removal.
     */
    private void testWidgets() {
        System.out.println("\n--- Widget tests ---");

        Widget pen = new Widget("Pen", 2.50);
        Widget bag = new Widget("Bag", 25.00);
        Widget book = new Widget("Book", 12.00);
        Widget equalPrice = new Widget("Case", 25.00);

        check("Lower price compares negative", pen.compareTo(bag) < 0);
        check("Equal prices compare zero", bag.compareTo(equalPrice) == 0);
        check("Higher price compares positive", bag.compareTo(book) > 0);

        GenericList<Widget> widgets = new GenericList<>();

        widgets.addAfter(pen);
        widgets.addAfter(bag);
        widgets.advance();
        widgets.addAfter(book);

        widgets.print();

        // Identity checks confirm that the expected objects were inserted.
        check("Pen is first", widgets.getItemAt(0) == pen);
        check("Bag is second", widgets.getItemAt(1) == bag);
        check("Book is third", widgets.getItemAt(2) == book);
        check("Widget maximum is Bag", widgets.getMaximum() == bag);
        check("Current moves to Bag", widgets.getCurrent() == bag);

        widgets.addAfter(equalPrice);
        check("First tied maximum is selected",
                widgets.getMaximum() == bag);

        widgets.deleteCurrent();
        check("Removal selects Case", widgets.getCurrent() == equalPrice);

        GenericList<Widget> single = new GenericList<>();
        single.addAfter(pen);

        check("Single-item maximum is Pen", single.getMaximum() == pen);
        check("Cannot advance past single item", !single.advance());

        single.deleteCurrent();

        check("Removing only item empties list", single.getSize() == 0);
        check("Removed only item leaves no current", !single.hasCurrent());
        check("Maximum after removal is null", single.getMaximum() == null);
    }

    /**
     * Displays an explicit result for each test.
     */
    private void check(String description, boolean passed) {
        System.out.println(
                (passed ? "PASS: " : "FAIL: ") + description);
    }

    @Override
    public void endProgram() {
        System.out.println("Leaving Generic List.");
    }

    /**
     * Allows this program to be tested before connecting the launcher.
     */
    public static void main(String[] args) {
        new GenericListProgram().run();
    }
}
