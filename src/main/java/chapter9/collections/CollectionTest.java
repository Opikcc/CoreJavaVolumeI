package chapter9.collections;

import java.util.*;

public class CollectionTest {
  public static void main(String[] args) {
    Queue<String> stringLane = new ArrayDeque<>(100);
    stringLane.add("Asep");
    stringLane.add("Budi");
    stringLane.add("Cecep");
    
    stringLane.remove();
    
    for (String q : stringLane) {
      System.out.println(q);
    }

    // Linked List
    var staff = new LinkedList<String>();
    staff.add("Amy");
    staff.add("Bobby");
    staff.add("Carl");

    Iterator iter = staff.iterator();
    String first = (String) iter.next();   // Visit first element
    String second = (String) iter.next();  // Visit second element
    iter.remove();  // Remove last visited element
    System.out.printf("first : %s, second : %s.\n", first, second);

    ListIterator listIter = staff.listIterator();
    listIter.add("Dudung");
    listIter.add("Encep");
    for (String s : staff)
      System.out.println(s);
  }
}
