package readandsort.app;

import readandsort.service.StringToListParser;
import readandsort.util.CollectionSorter;
import readandsort.util.SorterFactory;

/**
 * The {@code DemoApp} class serves as the main entry point of the read-and-sort
 * application.
 * It sets up configurations - user prompt, delimiter and sorter type,
 * coordinates objects from {@code StringToListParser}, {@code SorterFactory},
 * and {@code ReadAndSortApp} to perform full read-and-sort workflows.
 * <p><em>Sources and command instructions in README.md</em></p>
 *
 * <p>
 *  <strong>Version update:</strong><br>
 *  The class was updated to convert a string of integers into a sorted stack
 *  from smallest to largest.
 *  </p>
 * @author Huihua Huang
 * @version 1.1.0
 * @since Week 4 of CSC6301
 * @see StringToListParser
 * @see SorterFactory
 * @see ReadAndSortApp
 */
public class DemoApp {

    /**
     * The main method sets up configuration and calls relevant classes to
     * perform read-and-sort operations. It also displays information to show
     * correctness of full workflows.
     * @param args default parameter for the main method - not used.
     */
    public static void main(String[] args) {
        // Customize configuration: prompt message, delimiter and sorter type.
        // Enter a customized prompt.
        String prompt = """
                Welcome to the Read-and-Sort Application.
                Stack Order: Smallest element on top (right side)
                
                Please enter a list of integers separated by a space.
                For example: 50 70 60
                Note: Any other symbols or invalid data types will be rejected.
                Your input:\s""";
        /*
        ## Change was made here for project 5:
        Modify the second line of text box into:
        Stack Order: Smallest element on top (right side)
         */


        // Enter a delimiter such as space, comma, asterisk, period ...
        String delimiter = " ";

        // Enter a sorter type such as LinkedList, Stack, ArrayList ...
         String sorterType = "Stack";
        /*
        ## Change was made here for project 5:
        Modify sorterType from "LinkedList" to "Stack"
         */

        /*
        Reusability:
        The block of code under this dash line remains unchanged regardless of
        prompt, delimiter or sorter type in configuration.
        Such as:
        - Prompt: Change for delimiter like "separated by a comma" ...
        - Delimiter: " "(space), ","(comma), "."(period), "*"(asterisk) ...
        - Sorter Type: "LinkedList", "Stack", "ArrayList" ...

        The ReadAndSortApp dynamically adapts all configurations with usage of
        SorterFactory and StringToListParser.
        Detail explanations are commented in each related class.
        ---------------------------------------------------------------
         */
        // Create a converter
        StringToListParser converter = new StringToListParser();

        // Create a sorter (for LinkedList, Stack or other collections)
        CollectionSorter sorter = SorterFactory.createSorter(sorterType);

        // Create a specific app based on a customized prompt and delimiter.
        ReadAndSortApp app = new ReadAndSortApp(prompt, delimiter);

        // Run the read-and-sort workflows by passing sorter and converter.
        app.run(sorter, converter);

    }

}
