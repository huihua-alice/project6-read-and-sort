package readandsort.app;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Scanner;

import readandsort.service.StringToListParser;
import readandsort.util.CollectionSorter;
import readandsort.util.Message;

/**
 * The {@code ReadAndSortApp} class serves as the application controller in
 * related read-and-sort workflows.
 * <p>It coordinates user inputs, string parsing({@code StringToListParser}),
 * list sorting({@code CollectionSorter}) with specific prompt and delimiter
 * as configuration. It also displays output using the {@code Message} utility.
 * </p>
 * <p>
 * This class is designed for flexibility and reuse. Regardless of prompt
 * message, delimiter(space, comma, asterisk, period...), or sorting logic
 * ({@code LinkedListSorter}(existing), {@code StackSorter}(existing),
 * {@code ArrayListSorter}(future)) as provided by {@code SorterFactory}, the
 * main logic remains unchanged.
 * </p>
 * @author Huihua Huang
 * @version 1.0.0
 * @since Week 4 of CSC6301
 * @see readandsort.util.SorterFactory
 * @see StringToListParser
 * @see CollectionSorter
 * @see Message
 */
public class ReadAndSortApp {

    /**
     * The specific prompt message for user input.
     */
    private String prompt;

    /**
     * The specific delimiter for splitting string into list.
     */
    private String delimiter;

    /**
     * The scanned user input.
     */
    private String userInput;

    /**
     * The sorted result list in a generic collection data structure created by
     * a sorter, which implements the {@code CollectionSorter} as provided by
     * {@code SorterFactory}.
     */
    private Collection<Integer> resultList;
    /*
    Reusability:
    This resultList field holds the sorted result provided by any implementation
    of the CollectionSorter interface, such as the existing LinkedListSorter,
    StackSorter class, and future ArrayListSorter - all of those reuse the
    Java Collections Framework(Collection<Integer> and Collections.sort())
     */

    /**
     * Constructs a read-and-sort app with given prompt message and delimiter.
     * @param pPrompt the prompt message for user input.
     * @param pDelimiter the delimiter for splitting string into list.
     */
    public ReadAndSortApp(String pPrompt, String pDelimiter) {
        this.prompt = pPrompt;
        this.delimiter = pDelimiter;
    }

    /**
     * Runs a read-and-sort workflow to get sorted integer lists into a
     * collection structure from user input.
     * <p>The process as below:<br>
     * Ask user for input.<br>
     * Split and parse raw string into an unsorted LinkedList.<br>
     * Sort this LinkedList into any form of collection structure based on
     * provided sorter.<br>
     * Print the result message and list.<br>
     * </p>
     * @param sorter an implementation of {@code CollectionSorter} that defines
     *              the sorting logic and the type of collection to return.
     * @param converter an object of {@code StringToListParser} to parse string
     *                  into an unsorted LinkedList.
     */
    public void run(CollectionSorter sorter, StringToListParser converter) {
        /*
        Reusability:
        1) Uses aggregation and loose coupling:
        It uses aggregation relation and loosely couples with object from
        CollectionSorter(sorter) and object from StringToListParser(converter).
        The sorter can be any collection data type created by SorterFactory such
        as LinkedListSorter, StackSorter or ArrayListSorter.

        2) Supports various delimiter and user input:
        This block of code remains unchanged regardless of delimiter or sorter
        type in configuration and the user input.
        Such as:
        - Delimiter: " "(space), ","(comma), "."(period), "*"(asterisk) ...
        - Sorter Type: "LinkedList", "Stack", "ArrayList" ...
        - User Input: Any integers separated by a delimiter, detail explanation
        is in the askInput method.

        3) Adapts to any sorter type:
        The public static method sort from sorter reuses
        Collections.sort() logic from collections framework, returns sorted list
        to resultList attribute. This result list can be any collection type
        based on specific sorter.

        For examples:
        - Step 1: Choose a space as delimiter, it can handle any user input like
        "5 0 9 0", the public static method parseList from converter splits the
        string, parses and returns it into an unsorted LinkedList: [5, 0, 9, 0].

        - Step 2: Choose a sorter to execute sorting logic.
            - LinkedListSorter:
                Returns LinkedList<Integer> [0, 0, 5, 9]
            - StackSorter: Stack is special since the smallest is the top of
             stack on the right.
                Returns Stack<Integer> [9, 5, 0, 0]
            - ArrayListSorter(future implementation):
                Returns ArrayList<Integer> [0, 0, 5, 9]
           This logic applies to any supported sorter from SorterFactory.

        4) Prints any result with displayed collection type.
        Detail explanation in the printResult method.

        This logic can be reused with any user input, delimiter and sorter types.
         */

        // Ask user to enter a string of integers.
        this.askInput();

        // Convert raw string into unsorted integer list
        LinkedList<Integer> unsortedList = converter.parseList(
                this.userInput, this.delimiter);

        // Sort the integer list into any collections data structure
        this.resultList = sorter.sort(unsortedList);

        // Print the result.
        this.printResult();

    }

    /**
     * Prompts user continuously until non-empty input is entered.
     * It warns user to re-enter if the initial input is empty. If the input is
     * non-empty, the scanner stores trimmed input to the userInput attribute
     * for future use.
     */
    private void askInput() {
        while (true) {
            // Display customized prompt message and ask user input.
            Message.prompt(this.prompt);

            // Scan the user input.
            Scanner scanner = new Scanner(System.in);
            this.userInput = scanner.nextLine().trim();

            // User input is empty.
            if (userInput.isEmpty()) {
                Message.warning("Input cannot be empty.");
                continue;
            }
            break;
            /*
            Reusability:
            Closing the scanner also closes the underlying System.in stream,
            which may cause issue if the user needs to enter the input again.
            For the consideration for the reusability, let the JVM handle
            resource cleanup when the program terminates for this small project.
            So do not close the scanner manually here for future reuse.
             */
        }
        /*
        Reusability:
        Reuses the static methods from the utility class Message.
            - Prompt message: reuses the prompt method to ask user input.
            - Display warning: reuses the warning method to indicate the rule:
            [Warning]: Input cannot be empty.
         */
    }

    /**
     * Prints formatted result with success/warning message, the sorted list and
     * its related collection type if it is successful.
     */
    private void printResult() {

        // If the unsorted list is empty, it means the user input is invalid.
        if (this.resultList == null || this.resultList.isEmpty()) {
            Message.warning("The output is empty due to invalid user input.");
            return;
        }

        // Print successful message and result.
        String className = this.resultList.getClass().getSimpleName();
        String prefix = "Sorted (" + className + "): ";
        Message.success("The read-and-sort process is successfully made. ");
        Message.result("Original Input: ", this.userInput);
        Message.result(prefix, this.resultList);

        /*
        Reusability:
        Detail explanation for the print result section (see run method).
        1) Display warning: Reuses static warning method from the Message class.
            - Invalid type input: If user enters in unexpected delimiter or data
              type, the resultList attribute will be empty.

              Set the example with a single space delimiter and LinkedListSorter.
              If user enters situations including but not limited to:
              - "4.5 5 6 9.3" (float)
              - "4,5,6,9"(using comma instead of expected space delimiter)
              - "str 8 6 9" (string)
              - "8  9 10"(multiple consecutive spaces between integers):
              When using a single space (" ") as the delimiter, the converter
              splits the string only by one space. This input will result in an
              array like ["8", "", "9", "10"], where the empty string ("")
              triggers a NumberFormatException.

              The StringToListParser will detect these kinds of errors and
              return an empty LinkedList, so the resultList attribute remains
              empty because the sorter works on the empty unsorted list.

              Thus, this method returns the results from these four examples:
              [Warning]: The output is empty due to invalid user input.

        2) Display successful results: Reuses the success and result method from
        the Message utility class.

        Every collection object from the Java Collections Framework (Such as
        LinkedList, ArrayList, Stack, etc.) inherits methods from the Object
        class in Java.
        In this case, there is no need to create a printResult method for each
        implementation of the CollectionSorter interface.
        Instead, encapsulate this private result into each ReadAndSortApp object
        and display the collection type by reusing the generic method:
        getClass().getSimpleName().

        For the example from the run method, it prints out the message,
        collection type, detailed list:
        1) LinkedListSorter:
        [Success]: The read-and-sort process is successfully made.
        Original Input: 5 0 9 0
        Sorted (LinkedList): [0, 0, 5, 9]

        2) StackSorter: (smallest on the right)
        [Success]: The read-and-sort process is successfully made.
        Original Input: 5 0 9 0
        Sorted (Stack): [9, 5, 0, 0]

        3) ArrayListSorter(future implementation):
        [Success]: The read-and-sort process is successfully made.
        Original Input: 5 0 9 0
        Sorted (ArrayList): [0, 0, 5, 9]
         */
    }

}


