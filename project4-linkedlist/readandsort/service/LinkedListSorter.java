package readandsort.service;

import java.util.Collections;
import java.util.LinkedList;

import readandsort.util.CollectionSorter;

/**
 * The {@code LinkedListSorter} class represents a sorter that takes unsorted
 * LinkedList of integers and returns it as sorted LinkedList.
 * It uses the Java Collections Framework ({@code Collections}) and implements
 * the {@code CollectionSorter} interface based on its own collection type.
 * @author Huihua Huang
 * @version 1.0.0
 * @since Week 4 of CSC6301
 * @see java.util.Collections#sort(java.util.List)
 * @see CollectionSorter
 */
public class LinkedListSorter implements CollectionSorter {

    /**
     * Implements the integer sorting logic and turns the unsorted integer
     * {@code LinkedList} into a sorted one.
     *
     * @param unsortedList the unsorted {@code LinkedList} of integers.
     * @return a sorted integer {@code LinkedList}.
     */
    @Override
    public LinkedList<Integer> sort(LinkedList<Integer> unsortedList) {
        // Copy the input LinkedList to enforce immutability practice.
        LinkedList<Integer> copyList = new LinkedList<>(unsortedList);
        // Sort the list
        Collections.sort(copyList);
        return copyList;

        /*
        Reusability:
        Reuses the sorting algorithm provided by the Java Collections Framework.
        This Collections.sort() can be widely used not only for the LinkedList,
        but also (not limited to) Stack and ArrayList.

        This sorting logic can be reused and adapted for other implementations
        of CollectionSorter like StackSorter and ArrayListSorter.

        For future planning:
        Example algorithm combined with other methods in Collections framework:
        - StackSorter: the smallest element is the top of stack on the right.
            1) Create a copyList like LinkedListSorter;
            2) Collections.sort(copyList, Collections.reverseOrder());
            3) Create a stack and push the copyList elements (using for loop)
            into this stack.
            4) Return the stack.

        - ArrayListSorter:
            1) Create an ArrayList(result) based on the input list.
            2) Collections.sort(result);
            3) Return result list.
         */

    }

}
