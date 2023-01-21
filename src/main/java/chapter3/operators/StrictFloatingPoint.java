package chapter3.operators;

public class StrictFloatingPoint {
  // The use strictfp keyword make all of floating computation in this method use 64 bit,
  // even if the processor support 80 bit register computation
  // 80 bit register support more precision
  public static strictfp void main(String[] args) {
    double x, y, z;
    x = y = z = 1.23;
    double result = x * y / z;
    System.out.println("result : " + result);
  }
}
