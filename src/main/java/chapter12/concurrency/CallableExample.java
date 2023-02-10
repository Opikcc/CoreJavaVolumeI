package chapter12.concurrency;

import java.util.Random;
import java.util.concurrent.Callable;

// Java program to illustrate Callable and FutureTask
// for random number generation
class CallableExample implements Callable {
  
  private int number;

  public CallableExample(int number) {
    this.number = number;
  }

  @Override
  public Object call() throws Exception {
    Random generator = new Random();
    Integer randomNumber = generator.nextInt(5);

    if (number != 5)
      Thread.sleep(randomNumber * 1000);

    return number;
  }

}
