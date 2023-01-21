package chapter3.strings;

public class CodePoints {
  public static void main(String[] args) {
    String greeting  = "Hello";
    int n = greeting.length();

    System.out.println("Length of greeting is " + n);

    // To get the true length (code point used)
    int cpCount = greeting.codePointCount(0, greeting.length());
    System.out.println("Length of greeting based on code point is " + cpCount);

    char first = greeting.charAt(0);
    char last = greeting.charAt(4);

    System.out.println("first : " + first);
    System.out.println("last : " + last);

    String octonions = "Hello \uD835\uDD46 World";
    System.out.println(octonions);
    System.out.println("octonions length : " + octonions.length());
    System.out.println();

    int index = octonions.offsetByCodePoints(0, 6);
    System.out.println("Index : " + index);

    int cp = octonions.codePointAt(index);
    System.out.println("Code Point : " + cp);

    int[] arrayOfCodePoints = {120134};

    String codePoints = new String(arrayOfCodePoints, 0, 1);
    System.out.println("codePoints : " + codePoints);

//    int index, cp;
//    for (int i = 0; i < octonions.length(); i++) {
//      index = octonions.offsetByCodePoints(0, i);
//      cp = octonions.codePointAt(i);
//      System.out.printf("Char at %d is %s \n", i, octonions.charAt(i));
//      System.out.printf("Index %d with code point %d\n", index, cp);
//
//      if (Character.isSupplementaryCodePoint(cp))
//        i++;
//    }

  }
}
