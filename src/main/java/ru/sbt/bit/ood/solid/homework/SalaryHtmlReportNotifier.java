package ru.sbt.bit.ood.solid.homework;

import java.sql.Connection;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;

public class SalaryHtmlReportNotifier {

    private Connection connection;

    public SalaryHtmlReportNotifier(Connection databaseConnection) {
        this.connection = databaseConnection;
    }


    /**
     * @param recipients � ������, ���� ���������� �� ����������, � ����������� ���-����, � ���� �������� ������������ ���� ����������
     */
    public void generateAndSendHtmlSalaryReport(String departmentId, LocalDate dateFrom, LocalDate dateTo, String recipients) throws Exception {


        DataSetGenerator st = new SQLResultSetGenerator(connection);
        SalaryReport salaryReport = new SalaryReport();
        ResultSet results = st.preparedStatement(departmentId, dateFrom, dateTo, salaryReport.getReport());
        SQLParser parser = new SQLParser();
        ArrayList data = parser.getData(results);

        StringMaker resultingHtml = new HTMLStringMaker();
        StringBuilder str = resultingHtml.makeStringBuilder(data);

        MailSender mailSender = new MailSender(recipients, str);
        mailSender.send();

    }
}


/*
���� ������������� ���, �������� �������� SOLID, �������� ��������� ����:

    ����� ���������� ����� ��������� salary data (�������� ��  SQL databases)
    ����� ���������� ����� ������ (�min salary report�, �avg salary report�)
    ����� ���������� ����� ������� ������� (pdf/excel/etc)
    ���������� ����� ����������� �� ������ �� �����, �� � ������������ �������� �� ftp ��� ������ � ��������� �����
    (������ �������� �� e-mail)


*/
