package readandsort.util;

import java.util.Collection;
import java.util.LinkedList;

/**
 * The {@code CollectionSorter} interface defines an abstract method for classes
 * to implement integer sorting logic using different collection data types.
 *
 * @author Huihua Huang
 * @version 1.0.0
 * @since Week 4 of CSC6301
 * @see java.util.Collections
 */
public interface CollectionSorter {

     /**
      * The abstract {@code sort} method sorts the given {@code LinkedList} of
      * integers and returns a sorted result list in any specific
      * {@code Collection} data type, depending on the implementing class.
      * @param unsortedList the unsorted {@code LinkedList} of integers.
      * @return a sorted {@code Collection} of integers.
      */
     public Collection<Integer> sort(LinkedList<Integer> unsortedList);

     /*
     Reusability:
     Reuses Java Collections Framework to return various types of sorted
     collections via the Collection interface.

     Regardless of the underlying collection type, the results are returned as
     Collection<Integer> to support flexible instances processing.

     The supported return collection types include(but not limited to):
          - LinkedList<Integer>
          - Stack<Integer>
          - ArrayList<Integer>
      */

}
