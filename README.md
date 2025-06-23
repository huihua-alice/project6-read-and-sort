<a id="readme-top"></a>

# About the Repository

This repository (Project 6) combines and compares Project 4 (version 1.0.0) and 
Project 5 (version 1.1.0) of `Read-and-Sort` program in one place. 

<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-program">About The Program</a>
      <ul>
        <li><a href="#purpose">Purpose</a></li>
        <li><a href="#version-overview">Version Overview</a></li>
        <li><a href="#features">Features</a></li>
        <li><a href="#solid-principle-alignment">SOLID Principle Alignment</a></li>
        <li><a href="#reuse">Reuse</a></li>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#quick-start">Quick Start</a></li>
      </ul>
    </li>
    <li><a href="#reference">Reference</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#author">Author</a></li>
  </ol>
</details>

<!-- ABOUT THE PROGRAM -->
## About The Program

`Read-and-Sort`, a Java program, reads and scans integers from user inputs, 
converts and sorts them into a collection data structure (default: `LinkedList`) from smallest to
largest.

### Purpose

This `Read-and-Sort` program demonstrates how to use Java built-in Framework
(especially Collections Framework) to read, convert, and sort user input by
applying the rule of reusability.

### Version Overview

```text
+-----------+---------+-------------------+--------------------------+
| Project   | Version | Since             | Main Focus               |
|-----------|---------|-------------------|--------------------------|
| Project 4 | 1.0.0   | Week 4 of CSC6301 | Use of LinkedList sorter |
| Project 5 | 1.1.0   | Week 4 of CSC6301 | Use of Stack sorter      |
+-----------+---------+-------------------+--------------------------+
```
Note: 
* Project 5 builds upon Project 4 by introducing a `StackSorter`. 
* Both projects share a modular architecture, use a common parser and message
system, and are built to demonstrate flexibility through interchangeable sorters.
* Each project includes its own `README.md` with detailed demo, design structures,
and notes.
Please refer to **project4-linkedlist**'s
[README.md (click here)](project4-linkedlist/README.md#about-the-project) and **project5-stack**'s
[README.md (click here)](project5-stack/README.md#about-the-project)

### Features:

This program provides **reliability**, **flexibility** and **reusability** across
features.

* Interactive User Input: Ask user inputs with customized prompts, delimiters
  and user-friendly error handling.
* Dynamic String Parser: Converts the user’s input string into a structured list
  of integers using a dedicated parser class `StringToListParser`.
* Flexible Message Handler: Provides user feedback and warnings using a custom
  utility class `Message` for consistent and centralized output handling.
* Supportive Factory Pattern: Uses a factory class `SorterFactory` to dynamically
  create the appropriate sorting component based on the specified type.
* Modular and Extensible Design: Follows the SOLID principles, allowing easy
  integration of any collection types (e.g., `LinkedList`,`Stack`, `ArrayList`).
* Cross-Platform Compatibility: Fully tested on Windows, Linux(Ubuntu) and macOS.

### SOLID Principle Alignment:

* S - Single Responsible Principle (SRP):
    - Package-level: organizes different classes and groups them into different
      feature-based subpackages.
    - Class-level: highly follows 
      [Google Java Coding Guideline](https://google.github.io/styleguide/javaguide.html)
      and implements modularity and encapsulation. Each class only has a single
      responsibility and separates concerns.
    - Method-level: each function only executes one job.

* O - Open/Closed Principle (OCP):
  The program can dynamically handle extensible needs regardless of prompt
  message, delimiter and sorter types.
    - `CollectionSorter`: Allows new implementation without modifying the logic.
    - `SorterFactory`: Uses if-else if to easily extend the sorter types.
    - `ReadAndSortApp`: The run method accepts any types of existing sorter that
      created by the SorterFactory using specific type of `CollectionSorter`, and
      any delimiter that parsed by the `StringToListParser`. The app can fully 
      remain unchanged.

* L - Liskov Substitution Principle (LSP):
  Subtypes must be substitutable for their base types.
    - `LinkedListSorter`(version 1.0.0) and `StackSorter`(version 1.1.0): 
       implement the sort method from the interface `CollectionSorter`, 
       substituting the return type `Collection<Integer>` for 
       `LinkedList<Integer>` and `Stack<Integer>` respectively while 
       interacting with `ReadAndSortApp`.
    - `SorterFactory`: the return type `CollectionSorter` will be substituted by
      specific collection-based sorter.

* I - Interface Segregation Principle (ISP):
  The `CollectionSorter` interface has only one abstract sort method - minimal
  and specific.

* D - Dependency Inversion Principle (DIP):
  `ReadAndSortApp` depends on the `CollectionSorter` interface and passes it in
  the run method. The app logic doesn't need to know the concrete sorter type —
  inversion is done through the `SorterFactory`.

### Reuse:

#### Reuse via Java Collections Framework:
* Data Structure: Uses built-in `LinkedList` and `Stack`.
* Sorting Logic: Applies`Collections.sort()`to any collection that implements
  `List`.

#### Reuse via Other Java Framework:
* User inputs: Uses `Scanner` to get user inputs.
* Handle inputs: Uses `String.trim()` to clean data, `String.split()` to
  split string into lists, `Integer.parseInt()` to parse string into integer.

#### Reuse via Modular Components:
* `StringToListParser` can be reused for any integer-parsing task.
* `CollectionSorter` interface supports different sorting strategies across
  various collection types.
* `ReadAndSortApp` controller orchestrates logic by accepting pluggable
  parser/sorter modules — making it adaptable and easy to repurpose.
* `SorterFactory` allows dynamic blending minimal changes to support other
  types of collections or algorithms.
* `Message` utility allows centralized, consistent communication with users,
  reusable in other projects.

### Built With

* Windows 11
* ![Java](https://img.shields.io/badge/Java-24-blue?logo=java)
* IntelliJ IDEA 2024.3.6 (Community Edition)
* Visual Studio Code 1.101.0

[🔝 back to top](#readme-top)

<!-- GETTING STARTED -->
## Getting Started

### Prerequisites
* Update to ![Java](https://img.shields.io/badge/Java-24-blue?logo=java)
  or newest version. Check your current Java Version with command line:
  ```cmd
  java --version
  ```
  If Java is not installed or lower than 24, go to
  [Oracle JDK downloads](https://www.oracle.com/java/technologies/downloads/)
  to download the newest one.
* Install Git (for cloning) if not already installed :
  [Download Git](https://git-scm.com/downloads)

### Quick Start
**How to work with each project with command line interface?<br>
Here are simple steps:**

#### First: Go to the designated folder and clone the repo:

   ```cmd
   git clone https://github.com/huihua-alice/project6-read-and-sort.git
   ```
#### Second:  Navigate to the chosen project:<br>

  * *Go to the project 4*
  ```cmd
   cd project6-read-and-sort/project4-linkedlist
  ```
  *Or*<br> 
  * *Go to the project 5*
  ```cmd
   cd project6-read-and-sort/project5-stack
  ```
  
#### Third: Compile the Java code

   * Linux/macOs
      ```bash
      javac -d bin readandsort/util/*.java readandsort/service/*.java readandsort/app/*.java
      ```
   * Windows cmd
      ```cmd
      javac -d bin readandsort\util\*.java readandsort\service\*.java readandsort\app\*.java
      ```
#### Fourth: Run the program
  ```cmd
  java -cp bin readandsort.app.DemoApp
  ```
#### Fifth: Generate Javadoc
  * Linux/macOs
  ```cmd
  javadoc -private -author -version -d docs -sourcepath . readandsort/package-info.java -subpackages readandsort
  ```
  * Windows cmd
  ```cmd
  javadoc -private -author -version -d docs -sourcepath . readandsort\package-info.java -subpackages readandsort
  ```
#### Sixth: View Javadoc
   * Windows cmd
      ```cmd
      start docs\index.html
      ```
   * Linux
      ```bash
      xdg-open docs/index.html
      ```
   * macOS
      ```bash
      open docs/index.html
     ```
Each project includes its own `README.md` with detailed demo, design structures,
and notes.
Please refer to **project4-linkedlist**'s
[README.md (click here)](project4-linkedlist/README.md#about-the-project) and **project5-stack**'s
[README.md (click here)](project5-stack/README.md#about-the-project)

[🔝 back to top](#readme-top)

<!-- REFERENCE -->
## Reference:

#### ChatGPT usage:
```text
    - Tutorial:
      Generated some simple sample codes for learning Java Collections Framework
      - Collections, LinkedList, ArrayList, Queue, and Stack.
     
    - Textural structure diagram:
      Helped generate package-level structure diagram based on this java code. 
      Also, helped generated the version comparison tables for quick overviews.
      
    - Rename some Java files:
      Generated some naming ideas for the root package and the interface. I 
      picked the readandsort and the CollectionSorter among those choices.
```

#### [Google java coding guideline](https://google.github.io/styleguide/javaguide.html)

#### [README.md Template](https://github.com/othneildrew/Best-README-Template)

#### Week 3, Week 4 and Week 5 course slides and related links.

[🔝 back to top](#readme-top)

<!-- LICENSE -->
## LICENSE
This program is licensed under the [MIT License](LICENSE).

[🔝 back to top](#readme-top)

<!-- AUTHOR -->
## Author
#### Name: Huihua Huang
#### Email: huangh@merrimack.edu
#### Github: https://github.com/huihua-alice

[🔝 back to top](#readme-top)