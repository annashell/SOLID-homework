package ru.sbt.bit.ood.solid.homework;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 * Created by Анна on 31.10.2015.
 *
 *
 * Here SQL result set is generated
 */
public class SQLResultSetGenerator implements DataSetGenerator {

    private Connection connection;

    public SQLResultSetGenerator(Connection connection) {
        this.connection = connection;
    }

    @Override
    public ResultSet preparedStatement(String departmentId, LocalDate dateFrom, LocalDate dateTo, String statement) throws SQLException {
        // prepare statement with sql
        PreparedStatement ps = connection.prepareStatement(statement);

        // inject parameters to sql
        ps.setString(0, departmentId);
        ps.setDate(1, new java.sql.Date(dateFrom.toEpochDay()));
        ps.setDate(2, new java.sql.Date(dateTo.toEpochDay()));


        // execute query and get the results
        ResultSet results = ps.executeQuery();
        return results;
    }
}
