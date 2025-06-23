package readandsort.service;

import java.util.LinkedList;

/**
 * The {@code StringToListParser} class splits and parses a string into an
 * unsorted LinkedList of integers based on given raw string and delimiter.
 * <p>It splits the raw string into elements using the specified delimiter,
 * attempts to parse each element as an integer, and collects the results in a
 * {@code LinkedList}. If any element is not a valid integer, it returns an
 * empty list.</p>
 * <p>This class is fully reusable for any raw string input and delimiter.</p>
 *
 * @author Huihua Huang
 * @version 1.0.0
 * @since Week 4 of CSC6301
 * @see java.util.LinkedList
 */
public class StringToListParser {

    /**
     * Parses a raw string into an unsorted {@code LinkedList} of integers
     * based on given user input and delimiter.
     * <p>If the invalid element is detected, it will return an empty list.</p>
     * @param rawString the scanned user input from prompts (e.g.,"5 9 2").
     * @param delimiter the predefined delimiter used to split the string
     *                  (e.g.,"+", ",", "*", or ".").
     * @return an unsorted {@code LinkedList} of parsed integers or an empty
     * list if the input is invalid.
     */
    public LinkedList<Integer> parseList(String rawString,
                                                String delimiter) {

        // Trim the whole string and split into string list.
        String[] stringList = rawString.trim().split(delimiter);
        LinkedList<Integer> unsortedList = new LinkedList<>();

        // Trim each element to get cleaner data.
        for (String s : stringList) {
            String cleanedData = s.trim();
            try {
                unsortedList.add(Integer.parseInt(cleanedData));
            } catch (NumberFormatException e) {
                // Clear out the list if one of the inputs is not integer.
                unsortedList.clear();
                break;
            }
        }

        return unsortedList;
    }

       /*
       Reusability:
       The converter created by this class can accept any delimiter from the
       DemoApp configuration and raw string from run method called by the
       ReadAndSortApp, adhering the open/closed principle.

       Examples executed by a StringToListParser instance - converter:
       1) String delimiter1 = ",";
          String userInput1 = "9,6,3";
          LinkedList<Integer> res1 = converter.parseList(userInput1, delimiter1);
          res1 will be: [9, 6, 3]

       2) String delimiter2 = "*";
          String userInput2 = "9*6*3";
          LinkedList<Integer> res2 = converter.parseList(userInput2, delimiter2);
          res2 will be: [9, 6, 3]

       3) String delimiter3 = "*";
          String userInput3 = "9.5*6*3";
          LinkedList<Integer> res3 = converter.parseList(userInput3, delimiter3);
          res3 will be: []
          Reason: 9.5 is float, not integer.

       Additionally, selecting the LinkedList<Integer> as return type is based
       on its flexibility, which can be easily converted into other collection
       data type with the usage of Java Collections Framework.
       For example:
       ArrayList<Integer> array = new ArrayList<>(res1)
         */
}
