package readandsort.util;

import readandsort.service.LinkedListSorter;

/**
 * The {@code SorterFactory} class generates {@code CollectionSorter} instances
 * based on the provided sorter type.
 * <p>
 * This class is a utility class that simplifies object creation logic for the
 * {@code CollectionSorter} interface. It supports flexibility for different
 * sorting logics. If the sorter type is unrecognized, it returns the fallback
 * LinkedListSorter and displays the warnings.<br>
 * Additionally, all returned sorters must be the concrete classes of the
 * {@code CollectionSorter} interface.
 * </p>
 * @author Huihua Huang
 * @version 1.0.0
 * @since Week 4 of CSC6301
 * @see CollectionSorter
 * @see LinkedListSorter
 * @see Message
 */
public class SorterFactory {

    /**
     * Creates and returns an instance of a class that implements the interface
     * {@code CollectionSorter} based on given sorter type.
     * <p>It greatly supports sorter type extensions, returns a default
     * {@code LinkedListSorter} if invalid sorter type is detected.</p>
     * @param sorterType the name of the specific sorter (e.g., "LinkedList")
     * @return a {@code CollectionSorter} instance or a {@code LinkedListSorter}
     * instance if the sorter type is invalid.
     */
    public static CollectionSorter createSorter(String sorterType) {
        // Types are extensible and easy to maintain.
        if (sorterType.equalsIgnoreCase("linkedlist")){
            return new LinkedListSorter();
        }
        // Fallback sorter is LinkedListSorter if the sorter type is invalid.
        sorterType = sorterType.isEmpty() ? "empty" : sorterType;
        String warning = "The sorter type (" + sorterType + ") is invalid or " + 
        "unavailable in the factory. So the default LinkedListSorter is built.";
        Message.warning(warning);
        return new LinkedListSorter();

        /*
        Reusability:
        1) Reuse logic: It may seem redundant if there is only one sorter
        type. But as the program grows, it's extensible for more sorter types
        by simply adding the else-ifs, following the open-closed principle.
        Example as below:

        if (sorterType.equalsIgnoreCase("linkedlist")){
            return new LinkedListSorter();
        } else if (sorterType.equalsIgnoreCase("stack")) {
            return new StackSorter();
        } else if (sorterType.equalsIgnoreCase("arraylist")) {
            return new ArrayListSorter();
        } ...

        2) Message warning: It reuses the static warning method from the utility
        Message class if the sorter type is invalid.
        For example, if change the sorter type in the DemoApp with "Hello", it
        returns:

        [Warning]: The sorter type (Hello) is invalid or unavailable in the
        factory. So the default LinkedListSorter is built.

        3) Return type: These sorters, regardless of the underlying returned
        collection type, are returned as CollectionSorter to support flexible
        downstream processing in the DemoApp.
        For example:
        CollectionSorter sorter = SorterFactory.createSorter("stack");
        CollectionSorter sorter = SorterFactory.createSorter("arraylist");
         */
    }
}
