package chapter9.collections;

import java.util.ArrayDeque;
import java.util.Queue;

public class CollectionTest {
  public static void main(String[] args) {
//    Queue<String> stringLane = new CircularArrayQueue<>(100);
    Queue<String> stringLane = new ArrayDeque<>(100);
    stringLane.add("Asep");
    stringLane.add("Budi");
    stringLane.add("Cecep");
    
    stringLane.remove();
    
    for (String q : stringLane) {
      System.out.println(q);
    }
  }
}
