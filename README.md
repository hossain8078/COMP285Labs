# COMP285Labs

Java lab exercises for COMP 258: Data Structures and Frameworks.

## Overview

The repository contains one NetBeans project located directly in the
repository root.

Earlier exercises are preserved alongside the shared console framework,
collections, application launcher, and recursive algorithms.

- Lab 4: Repository Organization and Generic Collections
- Lab 5: Recursion

## Run the application

1. Open the COMP285Labs repository folder as a project in NetBeans.
2. Select Clean and Build.
3. Run the project using the main class `comp258.Driver`.

The project may appear as `ConsoleFramework` in NetBeans.

## Launcher menu

| Option | Application |
| --- | --- |
| 1 | Manage data with ArrayManager |
| 2 | Manage data with LinkedList |
| 3 | Manage data with GenericLinkedList |
| 4 | Showcase Recursive Functions |
| 5 | Exit |

In the Array Manager, Linked List, and Generic List applications,
enter `0` to return to the launcher.

In the Recursive Functions application, enter `8` to return to the launcher.

Enter `5` in the launcher to close the application.

The earlier Random Number Program is preserved in the source code.

## Repository structure

| Path | Contents |
| --- | --- |
| src/comp258 | Driver and Java packages |
| nbproject | NetBeans project configuration |
| build.xml | Ant build script |
| manifest.mf | Application manifest |
| Requirement_docs | Supporting lab requirements |
| README.md | Project instructions |
| .gitignore | Git exclusion rules |

## Package organization

| Package | Purpose |
| --- | --- |
| comp258 | Main entry point: Driver |
| comp258.framework | Shared ConsoleProgram framework |
| comp258.programs | LabLauncher and console applications |
| comp258.collections | Collections, nodes, and Widget |
| comp258.exceptions | Custom exception classes |
| comp258.labs | Preserved standalone exercises |

## Shared console framework

`ConsoleProgram` provides the application lifecycle, menu loop,
and input-reading methods.

Its final `run()` method controls:

1. `startProgram()`
2. Repeated calls to `showMenu()` and `executeAction()`
3. `endProgram()`

Applications extend `ConsoleProgram` and implement their own menus
and actions.

`LabLauncher` stores the selected application in a private
`ConsoleProgram` variable named `currentProgram`.

`Driver` starts the launcher through a `ConsoleProgram` reference,
demonstrating inheritance and polymorphism.

The framework uses `QUIT_OPTION`, which is `0`, to stop a menu loop.
The launcher converts option `5` to this value, and the recursion
application converts option `8` to this value.

## Lab 4: Repository Organization and Generic Collections

The existing exercises were reorganized into shared packages within
one NetBeans project.

### Generic linked list

`GenericLinkedList<T extends Comparable<T>>` stores values in linked nodes.

The type constraint allows values of the same type to be compared
using `compareTo()`.

`GenericNode<T>` stores a value and a reference to the next node.

The collection supports:

- Insertion before and after the current node.
- Removal of the current node.
- Reading values by zero-based index.
- Moving the current position to the first or next node.
- Printing values without moving the current position.
- Copying values into an independent Object array.
- Finding the maximum value.

The `getMaximum()` method:

- Finds the largest value using `compareTo()`.
- Moves the current position to the node containing that value.
- Returns `null` when the list is empty.
- Selects the first maximum when multiple values compare equally.

### Widget comparisons

`Widget` implements `Comparable<Widget>` and contains:

- `String name`
- `double price`

Widgets are compared by price.

`compareTo()` returns:

- A negative value when the price is lower.
- Zero when the prices are equal.
- A positive value when the price is higher.

### Run the generic list tests

1. Run `comp258.Driver`.
2. Choose `3` to open the Generic List Program.
3. Choose `8` to run all tests.

Each check displays `PASS` or `FAIL`.

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

## Lab 5: Recursion

`RecursiveFunctionsApp` extends `ConsoleProgram` and demonstrates
recursive mathematical operations, string processing, and linked-list
traversal.

### Recursion menu

Choose `4` in the launcher to open this menu:

| Option | Operation |
| --- | --- |
| 1 | Calculate factorial |
| 2 | Calculate powers |
| 3 | Check if a word is a palindrome |
| 4 | Print number's digit sum |
| 5 | Run Indent-o-tron |
| 6 | Print linked list with recursion |
| 7 | Print linked list backwards with recursion |
| 8 | Exit program and return to launcher |

### Factorial

`factorial(int n)` calculates the factorial recursively.

- Base case: `n` is `0` or `1`; return `1`.
- Recursive case: return `n * factorial(n - 1)`.

Example:

```text
factorial(5) = 5 × 4 × 3 × 2 × 1 = 120
```

The method accepts values from `0` through `12`.
Larger factorials exceed the range of an `int`.

### Powers

`calculatePower(int base, int exponent)` calculates a power recursively.

- Base case: exponent is `0`; return `1`.
- Recursive case: multiply the base by the result for exponent minus one.

Example:

```text
calculatePower(2, 3) = 8
```

Negative exponents are rejected because this method returns an integer.
Multiplication results are checked for integer overflow.

### Palindrome

The palindrome operation has two methods:

```java
boolean isPalindrome(String word)
boolean isPalindrome(String word, int start, int end)
```

The wrapper accepts a word and supplies its first and last indexes.

The recursive method compares characters from both ends:

- Return `false` if the characters differ.
- Otherwise, move both indexes toward the centre.
- Return `true` when the indexes meet or cross.

Examples:

```text
mom     → true
level   → true
alamgir → false
```

Comparisons are case-sensitive. Spaces and punctuation are treated
as characters.

### Digit sum

`digitSum(int number)` adds the digits recursively.

- `% 10` extracts the final digit.
- `/ 10` removes the final digit.
- The base case returns the absolute value of a single digit.

Examples:

```text
digitSum(5) = 5
digitSum(42) = 6
digitSum(1234) = 10
digitSum(99999) = 45
```

Negative integers are also supported.

### Indent-o-tron

The operation has two methods:

```java
void indentoTron(int maxNum)
void indentoTron(int currentNum, int maxNum)
```

The wrapper starts at call number `1`.

Each recursive call:

1. Prints an indented line.
2. Calls the method for the next number.
3. Prints another line after that call returns.

The base case stops recursion when `currentNum` exceeds `maxNum`.

Example for a maximum of `4`:

```text
This was written by call number 1.
    This was written by call number 2.
        This was written by call number 3.
            This was written by call number 4.
            This ALSO written by call number 4.
        This ALSO written by call number 3.
    This ALSO written by call number 2.
This ALSO written by call number 1.
```

This demonstrates recursive descent and stack unwinding.
Loops are used to print indentation spaces.

### Recursive linked-list printing

The recursion application creates a test list containing:

```text
[10, 20, 30, 40, 50]
```

These are sample values initialized in `startProgram()`.
The lab requires a populated test list but does not specify these values
or a fixed number of nodes.

`GenericLinkedList` provides two recursive printing operations:

| Method | Behaviour |
| --- | --- |
| printForward() | Prints the current value before processing the next node |
| printBackwards() | Processes the next node before printing the current value |

Both operations:

- Start from the first node.
- Follow next-node references.
- Stop when the node is `null`.
- Preserve the node links and the selected current position.

Backward printing does not use previous-node references.

Expected output:

```text
Forward:
[10, 20, 30, 40, 50]

Backwards:
[50, 40, 30, 20, 10]
```

Printing forward again produces the original order because the links
are unchanged.

### Manual verification

The following results were demonstrated during a manual run:

| Operation | Input | Result |
| --- | --- | --- |
| Factorial | 8 | 40320 |
| Power | Base 15, exponent 3 | 3375 |
| Palindrome | mom | Palindrome |
| Palindrome | alamgir | Not a palindrome |
| Digit sum | 99 | 18 |
| Indent-o-tron | 12 | Calls increase from 1 to 12 and return from 12 to 1 |
| Forward printing | Sample list | [10, 20, 30, 40, 50] |
| Backward printing | Sample list | [50, 40, 30, 20, 10] |
| Recursion exit | Option 8 | Returns to launcher |
| Launcher exit | Option 5 | Closes application |

The demonstrated NetBeans run ended with `BUILD SUCCESSFUL`.

Additional useful checks include:

- `factorial(0)` returns `1`.
- A power with exponent `0` returns `1`.
- `digitSum(0)` returns `0`.
- Empty and single-node lists print correctly.
- Invalid factorial inputs and negative exponents show an error message.

Very large recursive inputs can exceed the available call-stack space.

## ArrayManager

The reusable `comp258.collections.ArrayManager` supports:

- Empty, capacity-based, and array-based constructors.
- Adding items to the end.
- Inserting items at a specified position.
- Removing items by position.
- Printing stored items.
- Checking the number of items and whether the manager is empty.
- Growing the internal array when capacity is reached.

Removal validates that the manager is not empty and that the position
is within the valid range before changing stored data.

The older `comp258.labs.ArrayManager` is preserved separately.
Classes with the same name can coexist because they belong to
different packages.

## Compiler checks

Additional compiler options:

```text
-Xlint:unchecked -Xlint:rawtypes
```

These options report unchecked operations and raw generic types.
After making changes, run Clean and Build and review the output.

## Supporting documents

Lab requirements are stored in `Requirement_docs`.

## Git workflow for Lab 5

The required development branch is `Recursion`.

Submission steps:

1. Commit the Lab 5 changes on `Recursion`.
2. Push the branch to GitHub.
3. Merge `Recursion` into `main`.
4. Keep the `Recursion` branch after merging.

Merging a pull request closes the pull request automatically.
The branch should remain available.

## Git exclusions

The `.gitignore` file excludes:

- Generated build directories.
- Distribution directories.
- Compiled `.class` files.
- Local NetBeans settings in `nbproject/private`.

Source files and shared project configuration remain tracked in Git.