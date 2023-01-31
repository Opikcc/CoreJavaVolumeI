package chapter8.generics;

/**
 * @version 1.01 2012-01-26
 * @author Cay Horstmann
 */
public class PairTest1 {
  public static void main(String[] args) {
    String[] words = { "Mary", "had", "a", "little", "lamb" };
    Pair<String> mm = ArrayAlg.minmax(words);
    System.out.println("min = " + mm.getFirst());
    System.out.println("max = " + mm.getSecond());

    // Get the middle
    String middleWord = ArrayAlg.getMiddle(words);
    System.out.println("Middle Words : " + middleWord);

    Long[] numbers = {1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, -1L};
    Long middleNumbers = ArrayAlg.<Long>getMiddle(numbers);
    System.out.println("Middle Numbers : " + middleNumbers);

    // Get Minimum
    System.out.println("Minimum = " + ArrayAlg.min(numbers));
    
//    if (mm instanceof Pair<String>) {
    if (mm instanceof Pair) {
      System.out.println("mm instance of Pair Class");
    }
    
    Pair<Double> dd = new Pair<>(1.23, 1.22);
    
    if (mm.getClass() == dd.getClass()) {
      System.out.println("mm and dd equals even the type parameter difference");
    }
  }
}

class ArrayAlg {
  /**
   * Gets the minimum and maximum of an array of strings.
   * @param a an array of strings
   * @return a pair with the min and max values, or null is a is empty
   */
  public static Pair<String> minmax(String[] a) {
    if (a == null || a.length == 0) return null;
    String min = a[0];
    String max = a[0];
    for (int i = 1; i < a.length; i++) {
      if (min.compareTo(a[i]) > 0) min = a[i];
      if (max.compareTo(a[i]) < 0) max = a[i];
    }

    return new Pair<>(min, max);
  }

  public static <T> T getMiddle(T... a) {
    return a[a.length/2];
  }

  public static <T extends Number & Comparable> T min(T... a) {
    if (a == null || a.length == 0) return null;
    T min = a[0];
    for(int i = 1; i < a.length; i++) {
      if(min.compareTo(a[i]) > 0) min = a[i];
    }

    return min;
  }
}
