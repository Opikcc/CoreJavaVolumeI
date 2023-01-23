package chapter5;

import chapter4.Employee;

import java.time.LocalDate;
import java.util.Random;

public class Reflections {
  public static void main(String[] args) throws Exception {
    Employee e = new Employee("Asep", 12, LocalDate.of(2000, 10, 10));

    Class cl = e.getClass();
    System.out.println(cl.getName() + " " + e.getName());

    String className = "java.util.Random";
    Class c2 = Class.forName(className);

    Random r = (Random) c2.getConstructor().newInstance();
    r.nextInt(1000);
    System.out.println("next Int : " + r.nextInt());

    System.out.println("c2 : " + c2.getName());

    Class c3 = int.class;
    Class c4 = void.class;
    Class c5 = Random.class;

    System.out.println("c3: " + c3.getName());
    System.out.println("c4 : " + c4.getName());
    System.out.println("c5 : " + c5.getName());
  }
}
