package ru.sbt.bit.ood.solid.homework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Анна on 31.10.2015.
 */
public class HTMLStringMaker implements StringMaker {

    @Override
    public StringBuilder makeStringBuilder(ArrayList<SalaryData> data) throws Exception {
        StringBuilder resultingHtml = new StringBuilder();
        resultingHtml.append("<html><body><table><tr><td>Employee</td><td>Salary</td></tr>");
        double totals = 0;
        for (int i = 0; i < data.size(); i++) {
            resultingHtml.append("<tr>"); // add row start tag
            resultingHtml.append("<td>").append((data.get(i)).getEmpName()).append("</td>"); // appending employee name
            resultingHtml.append("<td>").append(data.get(i).getSalary()).append("</td>"); // appending employee salary for period
            resultingHtml.append("</tr>"); // add row end tag
            totals += data.get(i).getSalary(); // add salary to totals
        }

        resultingHtml.append("<tr><td>Total</td><td>").append(totals).append("</td></tr>");
        resultingHtml.append("</table></body></html>");

        return resultingHtml;
    }

    // makes HTML from smth else in another method
    // ....

}
