package ru.sbt.bit.ood.solid.homework;

import java.time.LocalDate;

/**
 * Created by Анна on 31.10.2015.
 */
public interface DataSetGenerator {
    <T> T preparedStatement(String departmentId, LocalDate dateFrom, LocalDate dateTo, String statement) throws Exception;
}
