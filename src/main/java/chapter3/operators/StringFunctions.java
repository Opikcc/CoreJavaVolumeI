package chapter3.operators;

public class StringFunctions {
  public static void main(String[] args) {
    String listSize = String.join(" / ", "S", "M", "L", "XL");
    String currency = String.join(".", "1", "000", "000");
    System.out.println(listSize);
    System.out.println(currency);

    String repeated = "Java".repeat(1000000);
    System.out.println(repeated);
  }
}
