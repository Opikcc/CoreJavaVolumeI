package chapter6.lambda.expressions;

import java.util.Comparator;

public class Cars implements Comparator<Cars> {
  private int id;
  private String name;
  private double horsePower;

  public Cars(double horsePower) {
    this.horsePower = horsePower;
  }
  
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getHorsePower() {
    return horsePower;
  }

  public void setHorsePower(double horsePower) {
    this.horsePower = horsePower;
  }

  @Override
  public String toString() {
    return "Cars{" + "id=" + id + ", name=" + name + ", horsePower=" + horsePower + '}';
  }
  
  @Override
  public int compare(Cars c1, Cars c2) {
    return Double.compare(c2.horsePower, c1.horsePower);
  }
  
}
