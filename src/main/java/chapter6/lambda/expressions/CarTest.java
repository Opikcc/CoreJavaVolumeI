package chapter6.lambda.expressions;

import java.util.Arrays;

public class CarTest {
  public static void main(String[] args) {
    Cars[] cars = new Cars[3];
    
    cars[0] = new Cars(10);
    cars[1] = new Cars(3.43);
    cars[2] = new Cars(3.41);
    
    System.out.println(Arrays.toString(cars));
    
    // Sorting Cars
    Arrays.sort(cars, new CarsComparator());
    System.out.println("Sorted Cars");
    
    System.out.println(Arrays.toString(cars));
  }
  
}
