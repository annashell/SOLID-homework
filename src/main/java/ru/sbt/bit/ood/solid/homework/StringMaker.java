package ru.sbt.bit.ood.solid.homework;

import java.sql.ResultSet;

/**
 * Created by Анна on 31.10.2015.
 */
public interface StringMaker {

    //uses SQL class ResultSet
    StringBuilder makeFromSQL(ResultSet results) throws Exception;

    // some methods to make statements not from SQL
    //.....
}
