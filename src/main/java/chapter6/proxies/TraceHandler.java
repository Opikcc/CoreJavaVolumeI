package chapter6.proxies;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TraceHandler implements InvocationHandler {
  
  private Object target;
  public TraceHandler(Object t) {
    target = t;
  }

  @Override
  public Object invoke(Object proxy, Method m, Object[] args) throws Throwable {
    // Print implicit argument
    System.out.print(target);
    
    // Print method name
    System.out.print("." + m.getName() + "(");
    
    // Print explicit arguments
    if (args != null) {
      for (int i = 0; i < args.length; i++) {
        System.out.print(args[i]);
        if (i < args.length - 1)
          System.out.print(", ");
      }
    }
    System.out.println(")");
    
    // Invoke actual method
    return m.invoke(target, args);
  }

}
