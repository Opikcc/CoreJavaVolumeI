package chapter12.concurrency;

/**
 * @version 1.30 2004-08-01
 * @author Cay Horstmann
 */
public class ThreadTest {
  
  public static final int DELAY = 10;
  public static final int STEPS = 5;
  public static final double MAX_AMOUNT = 1_000;
  private static int daemonCounter = 1;
  
  private static Thread.State getCurrentThreadState(Thread t) {
    System.out.printf("State of %s : %s .\n",t.getName().toString(), t.getState().toString());
    
    return t.getState();
  }
  
  public static void main(String[] args) {
    ThreadExceptionHander threadHandler = new ThreadExceptionHander();
    Thread.setDefaultUncaughtExceptionHandler(threadHandler);

    var bank = new Bank(4, 100_000);
    
    Runnable task1 = () -> {
      try {
        for (int i = 0; i < STEPS; i++) {
          double amount = MAX_AMOUNT * Math.random();
          bank.transfer(0, 1, amount);
          Thread.sleep((int) (DELAY * Math.random()));
          System.out.printf("State of %s : %s .\n",Thread.currentThread().getName(), Thread.currentThread().getState().toString());

        }
        throw new Exception();
      } catch (Exception e) {
        
      }
    };
    
    Runnable task2 = () -> {
      try {
        for (int i = 0; i < STEPS; i++) {
          double amount = MAX_AMOUNT * Math.random();
          bank.transfer(2, 3, amount);
          Thread.sleep((int) (DELAY * Math.random()));
        }
      } catch (InterruptedException e) {
        
      }
    };
    
    var t1 = new Thread(task1);
    System.out.println("State of t1 : " + t1.getState());
    t1.start();
    System.out.println("State of t1 : " + t1.getState());
    new Thread(task2).start();

    // Daemon Thread
    Runnable r = () -> {
      for (;;) System.out.println("Daemon Thread " + daemonCounter++);
    };

    var z = new Thread(r);
    z.setDaemon(true);
    z.start();
    
    for (;;) {
      if (Thread.State.TERMINATED.equals(getCurrentThreadState(t1))) break;
      else getCurrentThreadState(t1);
    }
  }
}

class ThreadExceptionHander implements Thread.UncaughtExceptionHandler {
  @Override
  public void uncaughtException(Thread t, Throwable e) {
    System.out.println("Uncaught Exception : " + t.getName());
  }
}
