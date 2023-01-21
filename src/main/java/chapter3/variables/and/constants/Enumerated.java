package chapter3.variables.and.constants;

public class Enumerated {

  enum Size { SMALL, MEDIUM, LARGE, EXTRA_LARGE }

  public static void main(String[] args) {
    Size s = Size.LARGE;
    Size m = Size.MEDIUM;

    System.out.println("Size s : " + s);

    if (s.equals(Size.LARGE) && m == Size.MEDIUM)
      System.out.println("Size is Large");

  }
}
