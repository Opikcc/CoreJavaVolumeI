package chapter5.reflection;

import chapter4.Employee;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * This program uses reflection to spy on objects.
 * @version 1.13 2018-03-16
 * @author Cay Horstmann
 */
public class ObjectAnalyzerTest {
  public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, ReflectiveOperationException {
    var harry = new Employee("Harry Hacker", 50000, LocalDate.of(1989, 1, 10));
    // The class object representing Employee
    Class cl = harry.getClass();

    // The name field of the Employee class
    Field f = cl.getDeclaredField("name");
    f.setAccessible(true);
    f.set(harry, "Dummy Crackers");

    // The value of the name field of the harry object, i.e.,
    // the String object "Harry Hacker"
    Object v = f.get(harry);

    System.out.println("Object : " + v);

    // Objects Analyzer
    var squares = new ArrayList<Integer>();
    for (int i = 1; i <= 5; i++)
      squares.add(i * i);

    System.out.println(new ObjectAnalyzer().toString(squares));
  }
}
