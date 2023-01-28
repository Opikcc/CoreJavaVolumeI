package chapter6.lambda.expressions;

import java.util.Comparator;

public class CarsComparator  implements Comparator<Cars> {

  @Override
  public int compare(Cars c1, Cars c2) {
    return Double.compare(c1.getHorsePower(), c2.getHorsePower());
  }
}
