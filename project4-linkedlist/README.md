<a id="readme-top"></a>

# Read-and-Sort Program - LinkedList Focused
`Read-and-Sort`, a Java program, reads and scans integers from user inputs,
converts and sorts them into a collection data structure (default: `LinkedList`)
from smallest to largest.

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
        <li><a href="#design-overview">Design Overview</a></li>
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
1.0.0 

As for this version, it is primarily designed only for `LinkedList` output based
on the project 4 requirement of CSC6301. Because the `SorterFactory` can only 
produce a `LinkedListSorter`. However, with implementation of
[SOLID principles(click to see details)](../README.md#solid-principle-alignment),
future versions can easily integrate other collection types such as `Stack`, 
`ArrayList`.

### Since
Week 4 of CSC6301

### Demo
* Successful read-and-sort process displays original input, data type and result:
    ```text
    >>> Welcome to the Read-and-Sort Application.
    Sorting Order: smallest to largest.
    
    Please enter a list of integers separated by a space.
    For example: 50 70 60
    Note: Any other symbols or invalid data types will be rejected.
    Your input: 8 6 9 0
    
    [Success]: The read-and-sort process is successfully made. 
    Original Input: 8 6 9 0
    Sorted (LinkedList): [0, 6, 8, 9]
    ```
* Empty Input triggers another prompt:
    ```text
    >>> Welcome to the Read-and-Sort Application.
    Sorting Order: smallest to largest.
    
    Please enter a list of integers separated by a space.
    For example: 50 70 60
    Note: Any other symbols or invalid data types will be rejected.
    Your input: 
    
    [Warning]: Input cannot be empty.
    
    >>> Welcome to the Read-and-Sort Application.
    Sorting Order: smallest to largest.
    
    Please enter a list of integers separated by a space.
    For example: 50 70 60
    Note: Any other symbols or invalid data types will be rejected.
    Your input: 
    ```
* Invalid Input displays warning message and terminates program:
  (incorrect delimiter input triggers failure)
    ```text
    >>> Welcome to the Read-and-Sort Application.
    Sorting Order: smallest to largest.
    
    Please enter a list of integers separated by a space.
    For example: 50 70 60
    Note: Any other symbols or invalid data types will be rejected.
    Your input: 9,6,3
    
    [Warning]: The output is empty due to invalid user input.
    ```

### Design Overview
#### Package-Level Textual Diagram:
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

#### Class-Level UML Diagram:
[📄 View UML Diagram here.](uml.pdf)

[🔝 back to top](#readme-top)

<!-- GETTING STARTED -->
## Getting Started
How to download, compile and run this project in command line interface?

See [Prerequisites (click here) ](../README.md#prerequisites) and 
[Quick Start for project 4 (click here)](../README.md#quick-start).

[🔝 back to top](#readme-top)

<!-- USAGE EXAMPLES -->
## Usage
### Default Usage
* Split user input into a list with a space delimiter.
* Parse input into integers.
* Sort the integers in ascending order into LinkedList.
* Display the original and sorted list using a consistent message format.

### Advanced Usage - Customize configuration on the fly 

#### String Configuration for DemoApp(Main Entry)

   * prompt
   * delimiter
   * sorter type

Note: Based on this version, `Linkedlist` is the only supported `sorter type`. 
If the user sets an invalid `sorter type`, the program will automatically fall 
back to the default: `LinkedListSorter`. This ensures the program remains 
functional even with incorrect `sorter type`.
However, you can feel free to change the other two parameters.

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
    ```
Now the program accepts the input that once was treated invalid
(see the third [Demo(click here)](#demo) example above) and displays successful
message and result.
```text
  >>> Welcome to the Read-and-Sort Application.
  Sorting Order: smallest to largest.
        
  Please enter a list of integers separated by a comma.
  For example: 50,70,60
  Note: Any other symbols or invalid data types will be rejected.
  Your input: 9,6,3
        
  [Success]: The read-and-sort process is successfully made. 
  Original Input: 9,6,3
  Sorted (LinkedList): [3, 6, 9]
```
_For more details, please refer to the 
[Documentation of this version](https://huihua-alice.github.io/project4-linkedlist/docs/index.html)_

[🔝 back to top](#readme-top)
