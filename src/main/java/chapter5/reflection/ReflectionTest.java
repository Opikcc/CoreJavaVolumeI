package chapter5.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

/**
 * This program uses reflection to print all features of a Class
 * @version 1.11 2018-03-16
 * @author Cay Horstmann
 */
public class ReflectionTest {
  public static void main(String[] args) throws ReflectiveOperationException {
    // Read class name from command line args or user input
    String name;
    if (args.length > 0) {
      name = args[0];
    }
    else {
      var in = new Scanner(System.in);
      System.out.println("Enter class name (e.g. java.util.Date)");
      name = in.next();
    }

    // Print class name and superclass name (if != Object)
    Class cl = Class.forName(name);
    Class supercl = cl.getSuperclass();
    String modifiers = Modifier.toString(cl.getModifiers());

    if (modifiers.length() > 0)
      System.out.print(modifiers + " ");
    System.out.println("class " + name);

    if (supercl != null && supercl != Object.class)
      System.out.println("superclass : " + supercl.getName());

    System.out.print("\n{\n");
    System.out.println("Constructors : ");
    printConstructors(cl);
    System.out.println();
    System.out.println("Methods : ");
    printMethods(cl);
    System.out.println();
    System.out.println("Fields : ");
    printFields(cl);
    System.out.println("}");
  }

  /**
   * Prints all constructors of a class
   * @param cl a class
   */
  public static void printConstructors(Class cl) {
    Constructor[] constructors = cl.getDeclaredConstructors();
    for (Constructor c : constructors) {
      String name = c.getName();
      System.out.print("   ");
      String modifiers = Modifier.toString(c.getModifiers());
      if (modifiers.length() > 0)
        System.out.print(modifiers + " ");
      System.out.print(name + "(");

      // Print parameter types
      Class[] paramTypes = c.getParameterTypes();
      for (int j = 0; j < paramTypes.length; j++) {
        if (j > 0)
          System.out.print(", ");
        System.out.print(paramTypes[j].getName());
      }
      System.out.println(");");
    }
  }

  /**
   * Prints all methods of a class
   * @param cl a class
   */
  public static void printMethods(Class cl) {
    Method[] methods = cl.getDeclaredMethods();

    for (Method m : methods) {
      Class retType = m.getReturnType();
      String name = m.getName();

      System.out.print("   ");

      // Print modifiers, return type and method name
      String modifiers = Modifier.toString(m.getModifiers());
      if (modifiers.length() > 0) System.out.print(modifiers + " (");
      System.out.print(retType.getName() + " " + name + " ");

      // Print parameter types
      Class[] paramTypes = m.getParameterTypes();
      for (int j = 0; j < paramTypes.length; j++) {
        if (j > 0) System.out.print(", ");
        System.out.print(paramTypes[j].getName());
      }
      System.out.println(");");
    }
  }

  /**
   * Prints all fields of a class
   * @param cl a class
   */
  public static void printFields(Class cl) {
    Field[] fields = cl.getDeclaredFields();

    for (Field f : fields) {
      Class type = f.getType();
      String name = f.getName();
      System.out.println("   ");
      String modifiers = Modifier.toString(f.getModifiers());

      if (modifiers.length() > 0)
        System.out.print(modifiers + " ");

      System.out.println(type.getName() + " " + name + ";");
    }
  }

}
