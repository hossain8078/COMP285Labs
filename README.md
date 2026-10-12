# COMP285Labs

Java lab exercises for COMP 258: Data Structures and Frameworks.

## Lab 4: Repository Organization and Generic Collections

The existing repository has been reorganized into one project,
located in Lab4_Reorganization.

Earlier lab exercises are preserved alongside the shared console
framework, collection classes, and application launcher.

## Run the application

1. Open Lab4_Reorganization as a project in NetBeans.
2. Select Clean and Build.
3. Run the project using the main class comp258.Driver.

The project may appear as ConsoleFramework in NetBeans.

## Launcher menu

| Option | Application |
| --- | --- |
| 1 | Random Number Program |
| 2 | Array Manager Program |
| 3 | Linked List Program |
| 4 | Generic List Program |
| 0 | Exit |

Enter 0 inside an application to return to the launcher.
Enter 0 in the launcher to exit.

## Package organization

| Package | Purpose |
| --- | --- |
| comp258 | Main entry point: Driver |
| comp258.framework | Shared ConsoleProgram framework |
| comp258.programs | LabLauncher and console applications |
| comp258.collections | Collections, nodes, and Widget |
| comp258.exceptions | Custom exception classes |
| comp258.labs | Preserved standalone exercises |

## Generic collections

GenericList<T extends Comparable<T>> stores values in linked nodes.
The type constraint allows values of the same type to be compared
using compareTo().

GenericNode<T> stores a value and a reference to the next node.

The getMaximum() method:

- Finds the largest value using compareTo().
- Moves the current position to the node containing that value.
- Returns null when the list is empty.
- Selects the first maximum when multiple values compare equally.

Widget implements Comparable<Widget> and contains:

- String name
- double price

Widgets are compared by price. compareTo() returns a negative value,
zero, or a positive value for a lower, equal, or higher price.

## Run the generic list tests

1. Run comp258.Driver.
2. Choose 4 to open the Generic List Program.
3. Choose 8 to run all tests.

Each check displays PASS or FAIL.

Tests cover:

- Integer lists, including negative values.
- String ordering.
- Widget insertion and price comparisons.
- Maximum values and current-position updates.
- Insertion before and after the current node.
- Cursor movement and removal.
- Single-item lists.
- Empty-list printing, maximum, current, advance, and removal.

The interactive Generic List Program starts with an empty Widget list
and handles invalid current-node operations without closing the program.

## Build validation

All 22 Java source files compiled successfully in NetBeans.

The project was rebuilt with these additional compiler options:

-Xlint:unchecked -Xlint:rawtypes

The build output contained no unchecked or raw-type warnings.

## Supporting documents

The linked list lab document is preserved at:

docs/LinkedLists-Lab3.pdf

## Git exclusions

The .gitignore file excludes:

- Generated build directories.
- Distribution directories.
- Compiled .class files.
- Local NetBeans settings in nbproject/private.

Source files and shared project configuration remain tracked in Git.