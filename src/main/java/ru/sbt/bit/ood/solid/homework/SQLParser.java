package ru.sbt.bit.ood.solid.homework;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Анна on 12.12.2015.
 */
public class SQLParser {
    ArrayList getData(ResultSet results) throws SQLException {
        ArrayList data = new ArrayList();
        while (results.next()) {
            SalaryData salaryData = new SalaryData(results.getString("emp_name"), results.getDouble("salary"));
            data.add(salaryData);
        }
        return data;
    }
}
