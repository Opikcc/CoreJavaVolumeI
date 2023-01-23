package chapter5;

import chapter4.Employee;

import java.time.LocalDate;

public class Manager extends Employee {
  private double bonus;

  public Manager(String name, double salary, LocalDate hireDay) {
    super(name, salary, hireDay);
    bonus = 0;
  }

  @Override
  public double getSalary() {
    double baseSalary = super.getSalary();
    return baseSalary + bonus;
  }

  public void setBonus(double bonus) {
    this.bonus = bonus;
  }

  public double getBonus() {
    return bonus;
  }
}
