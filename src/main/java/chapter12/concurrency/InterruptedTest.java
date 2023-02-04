package chapter12.concurrency;

public class InterruptedTest {

  private static int counter = 1;

  public static void main(String[] args) {
    Runnable r = () -> {
      try {
        while (!Thread.currentThread().isInterrupted()) {
          counter++;
          System.out.println("Thread is not interrupted " + counter);
          Thread.sleep(100);
          System.out.println("isInterrupted : " + Thread.currentThread().isInterrupted());

          if (counter == 10) Thread.currentThread().interrupt();
        }
      }
      catch (InterruptedException e) {
        System.out.println("isInterrupted : " + Thread.currentThread().isInterrupted());
        e.printStackTrace();
      }
    };

    new Thread(r).start();
  }
}
