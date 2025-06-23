<a id="readme-top"></a>

# Read-and-Sort Program - Stack Focused
`Read-and-Sort`, a Java program, reads and scans integers from user inputs,
converts and sorts them into a collection data structure from smallest to largest.


<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#version">Version</a></li>
        <li><a href="#since">Since</a></li>
        <li><a href="#demo">Demo</a></li>
        <li><a href="#updated-design-overview">Updated Design Overview</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
    </li>
    <li><a href="#usage">Usage</a></li>
  </ol>
</details>

<!-- ABOUT THE PROJECT -->
## About The Project

### Version
1.1.0 

In this version, the updated `Read-and-Sort` program extends and returns a new
data structure type - `Stack` based on the project 5 requirement of CSC6301.

Now, the `SorterFactory` can produce both `LinkedListSorter` and `StackSorter` 
thanks to the implementation of
[SOLID principles(click to see details)](../README.md#solid-principle-alignment).

#### Maintenance for Project 5:

There are three steps for maintenance based on Project 4:

1. `DemoApp`: Twist prompt message for readability (Smallest element on top
   (right side)) and change the `sorter type` to `Stack`.
2. Create the `StackSorter` in the subpackage `service` by simply reusing the
   Java Collections Framework and the logic of `LinkedListSorter` in just a few
   lines of code.
3. `SorterFactory`: Add an "else if" condition to `return new StackSorter()`.

Note: The rest of the code remains untouched.

#### Versioning Summary:
* Package-level:
```text
+---------------------------+----------+------------------------+------------------------------+
| Package                   | Version  | Since                  | Notes                        |
+---------------------------+----------+------------------------+------------------------------+
| readandsort               | 1.1.0    | Week 4 of CSC6301      | Updated for stack support    |
| readandsort.app           | 1.1.0    | Week 4 of CSC6301      | DemoApp now uses stack       |
| readandsort.service       | 1.1.0    | Week 4 of CSC6301      | Added StackSorter.java       |
| readandsort.util          | 1.1.0    | Week 4 of CSC6301      | Updated SorterFactory logic  |
+---------------------------+----------+------------------------+------------------------------+

```
* Class-level
```text
+--------------------------+----------+------------------------+-------------------------------+
| Class                    | Version  | Since                  | Notes                         |
+--------------------------+----------+------------------------+-------------------------------+
| StackSorter.java         | 1.0.0    | Week 5 of CSC6301      | New class in Project 5        |
| ReadAndSortApp.java      | 1.0.0    | Week 4 of CSC6301      | Unchanged from Project 4      |
| LinkedListSorter.java    | 1.0.0    | Week 4 of CSC6301      | Unchanged from Project 4      |
| CollectionSorter.java    | 1.0.0    | Week 4 of CSC6301      | Unchanged from Project 4      |
| Message.java             | 1.0.0    | Week 4 of CSC6301      | Unchanged from Project 4      |
| StringToListParser.java  | 1.0.0    | Week 4 of CSC6301      | Unchanged from Project 4      |
| SorterFactory.java       | 1.1.0    | Week 4 of CSC6301      | Added StackSorter support     |
| DemoApp.java             | 1.1.0    | Week 4 of CSC6301      | Updated prompt and sorter type|
+--------------------------+----------+------------------------+-------------------------------+

```

### Since
Week 4 of CSC6301

### Demo

Note: The top element of the result stack is the smallest, located on the right.

* Successful read-and-sort process displays original input, data type and result:
```text
>>> Welcome to the Read-and-Sort Application.
Stack Order: Smallest element on top (right side)

Please enter a list of integers separated by a space.
For example: 50 70 60
Note: Any other symbols or invalid data types will be rejected.
Your input: 6 8 3 6

[Success]: The read-and-sort process is successfully made. 
Original Input: 6 8 3 6
Sorted (Stack): [8, 6, 6, 3]
```
* Empty Input triggers another prompt:
```text
>>> Welcome to the Read-and-Sort Application.
Stack Order: Smallest element on top (right side)

Please enter a list of integers separated by a space.
For example: 50 70 60
Note: Any other symbols or invalid data types will be rejected.
Your input: 

[Warning]: Input cannot be empty.

>>> Welcome to the Read-and-Sort Application.
Stack Order: Smallest element on top (right side)

Please enter a list of integers separated by a space.
For example: 50 70 60
Note: Any other symbols or invalid data types will be rejected.
Your input: 
```
* Invalid Input displays warning message and terminates program:
  (incorrect delimiter input triggers failure)
```text
>>> Welcome to the Read-and-Sort Application.
Stack Order: Smallest element on top (right side)

Please enter a list of integers separated by a space.
For example: 50 70 60
Note: Any other symbols or invalid data types will be rejected.
Your input: 5,6,8,1,-9

[Warning]: The output is empty due to invalid user input.

```
### Updated Design Overview

#### Package-Level Textual Diagram:

`StackSorter.java` was created in the subpackage `service`.

```text

readandsort/ (Root package)
│
├── app/ (Application Layer)
│   ├── DemoApp.java: main entry point of the application (main method)
│   ├── ReadAndSortApp.java: application controller for read-and-sort logic
│   └── package-info.java (to generate Javadoc for subpackage app)
│
├── service/ (Parsing & Sorting Logic Layer)
│   ├── StringToListParser.java: parses string into unsorted LinkedList of integers
│   ├── LinkedListSorter.java: sorts and returns a LinkedList
|   ├── StackSorter.java: sorts a integer LinkedList into a stack and returns it
│   └── package-info.java (to generate Javadoc for subpackage service)
│
├── util/ (Utility Layer)
│   ├── CollectionSorter.java: interface for sorting logics
│   ├── SorterFactory.java: creates CollectionSorter instances
│   ├── Message.java: reusable static methods (prompt, success, warning, result)
│   └── package-info.java (to generate Javadoc for subpackage util)
│
└── package-info.java(to generate Javadoc for root package)
```

### Class UML diagram:

See [updated uml diagram here](uml.pdf).

[🔝 back to top](#readme-top)

<!-- GETTING STARTED -->
## Getting Started
How to download, compile and run this project in command line interface?

See [Prerequisites (click here) ](../README.md#prerequisites) and
[Quick Start for project 5 (click here)](../README.md#quick-start).

[🔝 back to top](#readme-top)

<!-- USAGE EXAMPLES -->
## Usage
### Default Usage
* Split user input into a list with a space delimiter.
* Parse input into integers.
* Sort the integers in ascending order into a `Stack`.
* Display the original and sorted stack using a consistent message format.

### Advanced Usage - Customize configuration on the fly

#### String Configuration for DemoApp(Main Entry)

* prompt
* delimiter
* sorter type

Note: Based on this version, both `Linkedlist` and `Stack` are supported 
`sorter type`. As in the previous version, if the user sets an invalid 
`sorter type`, the program will automatically fall back to the default:
`LinkedListSorter`. This ensures the program remains functional even with 
incorrect `sorter type`.

#### How to play around the configuration

* Go the `main` method of `DemoApp` java file.
* Change the delimiter from a space, to a period, a comma or a dot (whatever you
  like). For example, set a delimiter as a comma and twist the prompt a little bit
  to match it.

    ```java
    String prompt = """
        Enter integers separated by a comma.
        For example: 5,10,15,20
        Your input:\s""";
    
    String delimiter = ",";
    String sorterType = "Stack";
    ```
Now the program accepts the input that once was treated invalid
(see the third [Demo(click here)](#demo) example above) and displays successful
message and result.
```text
>>> Welcome to the Read-and-Sort Application.
Stack Order: Smallest element on top (right side)

Please enter a list of integers separated by a comma.
For example: 50,70,60
Note: Any other symbols or invalid data types will be rejected.
Your input: 5,6,8,1,-9

[Success]: The read-and-sort process is successfully made. 
Original Input: 5,6,8,1,-9
Sorted (Stack): [8, 6, 5, 1, -9]
```
_For more details, please refer to the
[Documentation of this version](https://huihua-alice.github.io/project5-stack/docs/index.html)_

[🔝 back to top](#readme-top)



