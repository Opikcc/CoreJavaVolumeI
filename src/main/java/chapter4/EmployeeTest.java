package chapter4;

import java.time.LocalDate;
import java.util.ArrayList;

public class EmployeeTest {
  public static void main(String[] args) {
    var employeeList = new ArrayList<Employee>();

    employeeList.add(new Employee("Asep", 1250.55, LocalDate.of(1990, 10, 12)));
    employeeList.add(new Employee(null, 1250.55, LocalDate.of(1990, 10, 12)));

    for (Employee e : employeeList) {
      System.out.println(e);
    }
  }
}
