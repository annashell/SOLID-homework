package ru.sbt.bit.ood.solid.homework;

/**
 * Created by Анна on 31.10.2015.
 */
public class SalaryReport implements Report{
    //salary report
    private String report = "select emp.id as emp_id, emp.name as amp_name, sum(salary) as salary " +
            "from employee emp left " +
            "join salary_payments sp on emp.id = sp.employee_id " +
            "where emp.department_id = ? and sp.date >= ? and sp.date <= ? group by emp.id, emp.name";

    public String getReport() {
        return report;
    }
}
