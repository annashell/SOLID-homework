package ru.sbt.bit.ood.solid.homework;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 * Created by Анна on 31.10.2015.
 * <p>
 * <p>
 * Can be implemented by any type of statements
 */
public interface DataSetGenerator {
    ResultSet preparedStatement(String departmentId, LocalDate dateFrom, LocalDate dateTo, String statement) throws SQLException;
}
