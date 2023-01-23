package chapter5;

import chapter4.Employee;

import java.time.LocalDate;

public class ManagerTest {

  private static Ukuran[] listSize = {Ukuran.SMALL, Ukuran.MEDIUM, Ukuran.LARGE};

  public static void main(String[] args) {
    Employee[] staff = new Employee[3];
    var boss = new Manager("Asep", 1250.55, LocalDate.of(1990, 10, 12));

    staff[0] = boss;
    staff[1] = new Employee("Budi", 1250.55, LocalDate.of(1990, 10, 12));
    staff[2] = new Employee("Cecep", 1250.55, LocalDate.of(1990, 10, 12));

    boss.setBonus(1000);

    for (Employee e : staff) {
      System.out.println(e.getName() + " : " + e.getSalary());
    }

    if (staff[0] instanceof Manager) {
      boss = (Manager) staff[0];
      System.out.println("staff[0] instanceof Manager");
    }

    System.out.println(boss.getName() + " : " + boss.getSalary() + " : " + boss.getBonus());

    for (Ukuran u : listSize) {
      System.out.println(u.getAbbreviation());
    }
  }
}

enum Ukuran {
  SMALL("S"), MEDIUM("M"), LARGE("L");

  Ukuran(String abbreviation) {
    this.abbreviation = abbreviation;
  }

  private String abbreviation;

  public String getAbbreviation() {
    return abbreviation;
  }

  public void setAbbreviation(String abbreviation) {
    this.abbreviation = abbreviation;
  }
}
