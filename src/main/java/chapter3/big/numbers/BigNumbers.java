package chapter3.big.numbers;

import java.math.BigInteger;

public class BigNumbers {
  public static void main(String[] args) {
    BigInteger bigInt = BigInteger.valueOf(100);
    BigInteger reallyBigInt = new BigInteger("12312312312312312312314356457568679679");

    System.out.println("bigInt : " + bigInt);
    System.out.println("reallyBigInt : " + reallyBigInt);

    BigInteger c = bigInt.add(reallyBigInt);
    BigInteger d = reallyBigInt.multiply(bigInt.add(BigInteger.valueOf(2)));

    System.out.println("c : " + c);
    System.out.println("d : " + d);
  }
}
