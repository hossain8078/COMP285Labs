# \# COMP285Labs

# 

# Java labs for COMP 258: Data Structures and Frameworks.

# 

# \## Run the application

# 

# 1\. Open the Lab4\_Reorganization folder as a project in NetBeans.

# 2\. Select Clean and Build.

# 3\. Run the project using the main class comp258.Driver.

# 

# The project may appear as ConsoleFramework in NetBeans.

# 

# \## Launcher menu

# 

# \- 1: Random Number Program

# \- 2: Array Manager Program

# \- 3: Linked List Program

# \- 4: Generic List Program

# \- 0: Exit

# 

# Enter 0 inside a lab application to return to the launcher.

# 

# \## Packages

# 

# \- comp258: Main driver.

# \- comp258.framework: Shared console framework.

# \- comp258.programs: Launcher and console applications.

# \- comp258.collections: Collection classes, nodes, and Widget.

# \- comp258.exceptions: Custom exceptions.

# \- comp258.labs: Preserved earlier lab exercises.

# 

# \## Generic collections

# 

# GenericList<T extends Comparable<T>> stores comparable values

# in linked nodes.

# 

# The getMaximum() method returns the largest value and selects

# its node as the current node. It returns null when the list is empty.

# 

# Widget implements Comparable<Widget> and compares widgets by price.

# 

# \## Run the generic list tests

# 

# 1\. Run comp258.Driver.

# 2\. Choose 4 to open the Generic List Program.

# 3\. Choose 8 to run the tests.

# 

# Tests cover:

# 

# \- Integer, String, and Widget lists.

# \- Widget price comparisons.

# \- Maximum selection and current-node updates.

# \- Cursor movement.

# \- Insertion and removal.

# \- Single-item and empty lists.

# 

# \## Earlier labs

# 

# Earlier lab exercises are preserved in the comp258.labs package.

# Shared collections and the console framework are used by the

# applications in comp258.programs.

# 

# \## Supporting documents

# 

# The linked list lab document is saved in:

# 

# docs/LinkedLists-Lab3.pdf

# 

# \## Git exclusions

# 

# The .gitignore file excludes generated build files, distribution

# files, compiled classes, and local NetBeans settings.

