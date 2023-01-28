package chapter4;

import java.time.LocalDate;
import java.util.Objects;

public class Employee implements Comparable<Employee> {
  private final String name;
  private  double salary;
  private final LocalDate hireDay;
  private final Comparable comparable;

  public Employee(String name, double salary, LocalDate hireDay) {
    Objects.requireNonNullElse(name, "Unknown");
    Objects.requireNonNull(hireDay, "Hire Day Cannot Be Null");
    this.name = Objects.requireNonNullElse(name, "Unknown");
    this.salary = salary;
    this.hireDay = hireDay;
    comparable = new Employee("Asep", 1250, LocalDate.of(2000, 10, 10));
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
  
  @Override
  public int compareTo(Employee other) {
      return Double.compare(this.salary, other.salary);
  }
}
