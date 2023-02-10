package chapter12.concurrency;

import java.math.BigInteger;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CallableTest {
  public static void main(String[] args) throws Exception {
    Callable<BigInteger> callable = new Callable<BigInteger>() {
      @Override
      public BigInteger call() throws Exception {
        BigInteger result = BigInteger.ONE;
        
        for (long i = 1; i < 10; i++) {
          if (i % 2 == 1) {
            result = result.multiply(BigInteger.valueOf(i));
          }
          else {
            result = result.multiply(BigInteger.valueOf(i));
          }
        }
        
        return result;
      }
    };
    
    Future<BigInteger> future = new Future<BigInteger>() {
      @Override
      public boolean cancel(boolean mayInterruptIfRunning) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
      }

      @Override
      public boolean isCancelled() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
      }

      @Override
      public boolean isDone() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
      }

      @Override
      public BigInteger get() throws InterruptedException, ExecutionException {
        BigInteger result = BigInteger.ONE;
        
        for (long i = 1; i < 1000; i++) {
          if (i % 2 == 1) {
            result = result.multiply(BigInteger.valueOf(i));
          }
          else {
            result = result.multiply(BigInteger.valueOf(i));
          }
        }
        
        return result;
      }

      @Override
      public BigInteger get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
      }
    };
    
    System.out.printf("futureResult : %,d \n", future.get());
    System.out.printf("callableResult : %,d \n", callable.call());
    
    var futureTask = new FutureTask<BigInteger>(callable);
    var t = new Thread(futureTask); // It's a Runnable
    t.start();
    BigInteger result = futureTask.get(); // It's a Future
    System.out.println("Result : " + result);
  }
}
