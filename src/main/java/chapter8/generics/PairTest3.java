package chapter8.generics;

import chapter4.Employee;
import chapter5.Manager;

import java.time.LocalDate;

/**
 * @version 1.01 2012-01-26
 * @author Cay Horstmann
 */
public class PairTest3 {
  public static void main(String[] args) {
    var ceo = new Manager("Gus Greedy", 800000, LocalDate.of(2003, 12, 15));
    var cfo = new Manager("Sid Sneaky", 600000, LocalDate.of(2003, 12, 15));
    var buddies = new Pair<Manager>(ceo, cfo);
    
    var lowlyEmployee = new Employee("Asep", 800000, LocalDate.of(2003, 12, 15));
    Pair<? extends Employee> wildcardbuddies = buddies; // -- OK
    Employee x = wildcardbuddies.getFirst();
//    Manager x = wildcardbuddies.getFirst();
//    wildcardbuddies.setFirst(lowlyEmployee);  Compile-time Error
    Pair<? super Manager> superManager = buddies;
    Manager y = cfo;
    superManager.setFirst(y);
    Object z = superManager.getFirst();

    printBuddies(buddies);

    ceo.setBonus(1000000);
    cfo.setBonus(500000);
    Manager[] managers = {ceo, cfo};

    var result = new Pair<Employee>();
    minmaxBonus(managers, result);
    System.out.println("first: " + result.getFirst().getName() + ", second: " + result.getSecond().getName());
    maxminBonus(managers, result);
    System.out.println("first: " + result.getFirst().getName() + ", second: " + result.getSecond().getName());
  }

  public static void printBuddies(Pair<? extends Employee> p) {
    Employee first = p.getFirst();
    Employee second = p.getSecond();
//    p.setFirst(second); // Not OK--
//    p.setSecond(first); // Not OK--
    System.out.println(first.getName() + " and " + second.getName());
  }

  public static void minmaxBonus(Manager[] a, Pair<? super Manager> result) {
    if (a.length == 0) return;
    Manager min = a[0];
    Manager max = a[0];
    for (int i = 1; i < a.length; i++) {
      if (min.getBonus() > a[i].getBonus()) min = a [i];
      if (max.getBonus() < a[i].getBonus()) max = a [i];
    }
    result.setFirst(min);
    result.setSecond(max);
  }

  public static void maxminBonus(Manager[] a, Pair<? super Manager> result) {
    minmaxBonus(a, result);
    PairAlg.swapHelper(result); // OK-- swapHelper captures wildcard type
  }
  // Can't write public static <T super manager> ...
}

class PairAlg {
  public static boolean hasNulls(Pair<?> p) {
    return p.getFirst() == null || p.getSecond() == null;
  }

  public static void swap(Pair<?> p) {
    swapHelper(p);
  }

  public static <T> void swapHelper(Pair<T> p) {
    T t = p.getFirst();
    p.setFirst(p.getSecond());
    p.setSecond(t);
  }
}