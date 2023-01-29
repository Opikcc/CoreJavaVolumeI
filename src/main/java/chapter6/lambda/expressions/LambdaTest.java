package chapter6.lambda.expressions;

import javax.swing.*;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * This program demonstrates the use of lambda expressions.
 * @version 1.02 2015-05-12
 * @author Cay Horstmann
 */
public class LambdaTest {
  public static void main(String[] args) {
    var planets = new String[] { "Mercury", "Venus", "Earth", "Jupiter", "Saturn", "Uranus", "Neptune"};
    System.out.println(Arrays.toString(planets));
    System.out.println("Sorted in dictionary order:");
    Arrays.sort(planets);
    System.out.println(Arrays.toString(planets));
    System.out.println("Sorted by length:");
    Arrays.sort(planets, (first, second) -> first.length() - second.length());
    System.out.println(Arrays.toString(planets));

    var timer = new Timer(1000, event -> System.out.println("The time is " + new Date()));
    timer.start();

    // Keep program running until the user select "OK"
    JOptionPane.showMessageDialog(null, "Quit Programs?");
    timer.stop();
//    System.exit(0);

    // Create BiFunction Sample
    BiFunction<String, String, Integer> comp = (a, b) -> (a.length() - b.length());
    
    Integer x = comp.apply("First", "Second");
    System.out.println("X : " + x);
    
    Predicate<String> planetCheck = e -> (e.equals("Earth"));
    Stream<String> result = Arrays.stream(planets).filter(planetCheck);
    List<String> resultString = result.collect(Collectors.toList());
    System.out.println("result String : " + resultString);
    System.out.println("Predicate : " + Arrays.stream(planets).filter(planetCheck));
  }
}
