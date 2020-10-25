package test1;

import java.util.Collections;
import java.util.List;

/**
 * - Collections:
 * Write a java merge class that will merge two sorted collections of the same kind into a single sorted collection.
 * You need to think of how to design this class in a generic form and efficiently
 *
 * Design:
 * 1) Design ListNode as the elements of Collection
 * 2) Define a Comparator for ListNode, currently we set it as natural ordering, of course, we can set another type of ordering
 * 3) combine the sorted collection to one collection and run "sort" for the single collection, then we can get the result
 * 4) We can also define a method to sort these two collections but directly use java collection sort is more directly and simple
 */
public class MergeSortedCollection {

    public List<ListNode> merge(List<ListNode> t1, List<ListNode> t2) {
        t1.addAll(t2);
        Collections.sort(t1);
        return t1;
    }

}
