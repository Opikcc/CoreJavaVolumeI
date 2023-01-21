package chapter3.operators;

import static java.lang.Math.*;

public class MathFunctions {
  public static void main(String[] args) {
    System.out.println("Akar pangkat 2 dari 4 adalah " + sqrt(3));

    System.out.println("5 % 2 = " + (5 % 2));
    System.out.println("-5 % 2 = " + (-5 % 2));
    System.out.println("5 % -2 = " + (5 % -2));
    System.out.println("-5 % -2 = " + (-5 % -2));

    // Using floorMod
    System.out.println();
    System.out.println("5 % 2 = " + floorMod(5, 2));
    System.out.println("-5 % 2 = " + floorMod(-5, 2));
    System.out.println("5 % -2 = " + floorMod(5, -2));
    System.out.println("-5 % -2 = " + floorMod(-5, -2));

    // Wrong result because computation overflow
    System.out.println("1_000_000_000 * 3 is " + 1_000_000_000 * 3 );

    // Using Math.multiplyExact
    try {
      System.out.println("1_000_000_000 * 3 is " + multiplyExact(1_000_000_000, 3));
    }
    catch (Exception e) {
      System.out.println(e.getMessage());
    }

    // Pembulatan
    System.out.println();
    System.out.println("Floor of 1.23 + 1.55 = " + floor(1.23 + 1.55));
    System.out.println("Ceil of 1.23 + 1.55 = " + ceil(1.23 + 1.55));
    System.out.println("Round of 1.23 + 1.55 = " + round(1.23 + 1.55));

    // Coercion
    System.out.println();
    int x = 3;
//    x += 3.5;
    x = (int) (3 + 3.55555);
    System.out.println("x += 3.5" + x);
  }
}
