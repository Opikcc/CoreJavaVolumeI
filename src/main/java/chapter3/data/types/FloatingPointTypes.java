package chapter3.data.types;

public class FloatingPointTypes {
  public static void main(String[] args) {
    float flot = 12345678910111213F;
    double dobel = 12_345_678_910_111_213D;
    double dobelInHexa = 0xF;
    double dobelInHexaDecimal = 0xF.0p-3;

    System.out.println("Flot : " + flot);
    System.out.println("Dobel : " + dobel);
    System.out.println("Dobel in Hexa: " + dobelInHexa);
    System.out.println("Dobel in Hexa Decimal: " + dobelInHexaDecimal);

    System.out.println("Double.POSITIVE_INFINITY : " + Double.POSITIVE_INFINITY);
    System.out.println("Double.NEGATIVE_INFINITY : " + Double.NEGATIVE_INFINITY);
    System.out.println("Double.NaN : " + Double.NaN);

    if (Double.isNaN(Math.sqrt(-1))) {
      System.out.println("Double.isNaN");
    }
    else {
      System.out.println("Double.isNumber");
    }
  }
}
