package chapter9.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class IteratorTest {
  public static void main(String[] args) {
    ArrayList<String> listName = new ArrayList<>();
    listName.addAll(Arrays.stream(new String[]{"Asep", "Budi", "Cecep"}).toList());
    listName.stream().forEach(n -> System.out.println(n));

    Iterator<String> iteratorString = listName.iterator();
    iteratorString.next();
    iteratorString.remove();
    listName.stream().forEach(n -> System.out.println(n));
  }
}
