package chapter4;

import java.time.LocalDate;
import java.util.Objects;

public class Employee {
  private final String name;
  private  double salary;
  private LocalDate hireDay;

  public Employee(String name, double salary, LocalDate hireDay) {
    Objects.requireNonNullElse(name, "Unknown");
    Objects.requireNonNull(hireDay, "Hire Day Cannot Be Null");
    this.name = Objects.requireNonNullElse(name, "Unknown");
    this.salary = salary;
    this.hireDay = hireDay;
  }

  public String getName() {
    return name;
  }

  public double getSalary() {
    return salary;
  }

  public void raiseSalary(double byPercent) {
    this.salary = this.salary * byPercent / 100;
  }

  @Override
  public String toString() {
    return "Employee{" +
            "name='" + name + '\'' +
            ", salary=" + salary +
            ", hireDay=" + hireDay +
            '}';
  }
}
