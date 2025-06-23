package readandsort.service;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Stack;

import readandsort.util.CollectionSorter;

/**
 * The {@code StackSorter} class represents a sorter that takes unsorted
 * LinkedList of integers and returns it as a sorted Stack.
 * It uses the Java Collections Framework ({@code Collections}) and implements
 * the {@code CollectionSorter} interface based on its own collection type.
 * @author Huihua Huang
 * @version 1.0.0
 * @since Week 5 of CSC6301
 * @see java.util.Collections#sort(java.util.List)
 * @see CollectionSorter
 */
public class StackSorter implements CollectionSorter {

    /**
     * Implements the integer sorting logic and turns the unsorted integer
     * {@code LinkedList} into a sorted {@code Stack}.
     *
     * @param unsortedList the unsorted {@code LinkedList} of integers.
     * @return a sorted integer {@code Stack}.
     */
    @Override
    public Stack<Integer> sort(LinkedList<Integer> unsortedList) {
        // Copy the input LinkedList to enforce immutability practice.
        LinkedList<Integer> copyList = new LinkedList<>(unsortedList);
        // Sort the list with Collections framework
        // For stack, the top element is smallest(on the right)
        copyList.sort(Collections.reverseOrder());

        Stack<Integer> stack = new Stack<>();
        // Write the element from LinkedList to the Stack
        for (int i: copyList) {
            stack.push(i);
        }
        return stack;

        /*
        Reusability:
        ## Change made for project 5:
        The implementation of StackSorter class was newly created by adapting
        the implementation of LinkedListSorter.
         */

    }

}
