package ru.sbt.bit.ood.solid.homework;

/**
 * Created by Анна on 12.12.2015.
 */
public class SalaryData {
    private String empName;
    private double salary;

    public SalaryData(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
    }

    public String getEmpName() {
        return empName;
    }

    public double getSalary() {
        return salary;
    }
}
