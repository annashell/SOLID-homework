package ru.sbt.bit.ood.solid.homework;

import java.sql.ResultSet;

/**
 * Created by Анна on 31.10.2015.
 */
public class HTMLStringMaker implements StringMaker {

    public StringBuilder makeFromSQL(ResultSet results) throws Exception {
        StringBuilder resultingHtml = new StringBuilder();
        resultingHtml.append("<html><body><table><tr><td>Employee</td><td>Salary</td></tr>");
        double totals = 0;
        while (results.next()) {
            // process each row of query results
            resultingHtml.append("<tr>"); // add row start tag
            resultingHtml.append("<td>").append(results.getString("emp_name")).append("</td>"); // appending employee name
            resultingHtml.append("<td>").append(results.getDouble("salary")).append("</td>"); // appending employee salary for period
            resultingHtml.append("</tr>"); // add row end tag
            totals += results.getDouble("salary"); // add salary to totals
        }
        resultingHtml.append("<tr><td>Total</td><td>").append(totals).append("</td></tr>");
        resultingHtml.append("</table></body></html>");

        return resultingHtml;
    }

    // makes HTML from smth else in another method
    // ....

}
