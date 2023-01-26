package chapter6.lambda.expressions;

import javax.swing.*;
import java.util.Arrays;
import java.util.Date;

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
  }
}
