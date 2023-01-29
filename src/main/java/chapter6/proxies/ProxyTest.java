package chapter6.proxies;

import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Random;

/**
 * This program demonstrates the use of proxies.
 * @version 1.01 2018-04-10
 * @author Cay Horstmann
 */
public class ProxyTest {
  
  public static void main(String[] args) {
    var elements = new Object[1000];

    // Fill elements with proxies for the integers 1 ... 1000
    for (int i = 0; i < elements.length; i++) {
      Integer value = i + 1;
      var handler = new TraceHandler(value);
      Object proxy = Proxy.newProxyInstance(
        ClassLoader.getSystemClassLoader(),
              new Class[] {Comparable.class},
              handler);
      elements[i] =  proxy;
    }
    
    // Construct a random integer
    Integer key = new Random().nextInt(elements.length) + 1;
    System.out.println("Random Key is : " + key);
    
    // Search for the key
    int result = Arrays.binarySearch(elements, key);
    
    // Print match if found
    if (result >= 0)
      System.out.println(elements[result]);
  }

}
