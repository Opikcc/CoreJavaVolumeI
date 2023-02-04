package chapter9.collections;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * This program demonstrates operations on linked lists.
 * @version 1.12 2018-04-10
 * @author Cay Horstmann
 */
public class LinkedListTest {
  public static void main(String[] args) {
    var a = new LinkedList<String>();
    a.add("Amy");
    a.add("Carla");
    a.add("Erica");

    var b = new LinkedList<String>();
    b.add("Bob");
    b.add("Doug");
    b.add("Frances");
    b.add("Gloria");
    b.add("Marcus ");

    // Merge the words from b into a

    ListIterator<String> aIter = a.listIterator();
    Iterator<String> bIter = b.iterator();

    while (bIter.hasNext()) {
      if (aIter.hasNext()) aIter.next();
      aIter.add(bIter.next());
    }

    System.out.println(a);

    // Remove every second word from b
    bIter = b.iterator();
    while (bIter.hasNext()) {
      bIter.next(); // Skip one element
      if (bIter.hasNext()) {
        bIter.next();   // Skip next element
        bIter.remove(); // Remove that element
      }
    }

    System.out.println(b);

    // Bulk operation: Remove all words in b from a
    a.removeAll(b);
    System.out.println(a);
  }
}
