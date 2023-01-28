package chapter6.interfaces;

public class Moving implements Moveable {

  @Override
  public void move(double x, double y) {
    System.out.printf("Moving x : %f and Moving y : $f", x, y);
  }
  
  public static void main(String[] args) {
    Moveable movable = new Moving();
    movable.move(12, 13);
  }
}
