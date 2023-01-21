package chapter3.data.types;

public class CharTypes {
  public static void main(String[] args) {
    char a = '\u0000';
    char b = '\u0001';
    char c = '\u0100';
    char d = '\u0049';
    char tm = '\u2122';
    char pi = '\u03C0';
    System.out.println("Char a : " + a);
    System.out.println("Char b : " + b);
    System.out.println("Char c : " + c);
    System.out.println("Char d : " + d);
    System.out.println("Char tm : " + tm);
    System.out.println("Char pi : " + pi);

    char x = 3;
    char y = 70;
    char z = (char) (x + y);
    System.out.println("Char z : " + z);

    // Octonions
    // First Code Unit + Second Code Unit in Surrogate Aread (U+D800 to U+DBFF) that forms Supplementary Characters
    String octonions = "\uD835\uDD46";
    System.out.println("Octonions : " + octonions);

    // Unicode escape sequences are processed before the code is parsed.
    // \u0022 is double quote
    System.out.println("test" + "\u0022+\u0022");

    // Insidiously result, \u000A //is new line character
    // \u000A //is a newline

    // Same unexpected result
    // \uffff is not followed by four hex digits
    // look inside c:\ users
  }
}
