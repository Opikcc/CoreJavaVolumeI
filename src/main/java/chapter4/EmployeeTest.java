package chapter4;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class EmployeeTest {
  public static void main(String[] args) {
    var employeeList = new ArrayList<Employee>();

    employeeList.add(new Employee("Asep", 1250.55, LocalDate.of(1990, 10, 12)));
    employeeList.add(new Employee("Budi", 2500.55, LocalDate.of(1990, 10, 12)));
    employeeList.add(new Employee("Cecep", 1250.55, LocalDate.of(1990, 10, 12)));
    employeeList.add(new Employee(null, 1250.55, LocalDate.of(1990, 10, 12)));

    for (Employee e : employeeList) {
      System.out.println(e);
    }
    
    System.out.println("Sorting Employee Based on Salary :");
    var arrEmployee = employeeList.toArray();
    Arrays.sort(arrEmployee);
    System.out.println("arrEmployee : " + Arrays.toString(arrEmployee));

    // To Stream
    System.out.println("Outputting as Stream :");
    Arrays.asList(arrEmployee).stream().forEach(System.out::println);
  }
}
