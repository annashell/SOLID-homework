package ru.sbt.bit.ood.solid.homework;

import java.sql.Connection;
import java.sql.ResultSet;
import java.time.LocalDate;

public class SalaryHtmlReportNotifier {

    private Connection connection;

    public SalaryHtmlReportNotifier(Connection databaseConnection) {
        this.connection = databaseConnection;
    }


    /**
     * @param recipients в случае, если результаты не отсылаются, а сохраняются где-либо, в этот параметр складывается путь сохранения
     */
    public void generateAndSendHtmlSalaryReport(String departmentId, LocalDate dateFrom, LocalDate dateTo, String recipients) throws Exception {


        DataSetGenerator st = new SQLResultSetGenerator(connection);
        SalaryReport salaryReport = new SalaryReport();
        ResultSet results = st.preparedStatement(departmentId, dateFrom, dateTo, salaryReport.getReport());

        StringMaker resultingHtml = new HTMLStringMaker();
        StringBuilder str = resultingHtml.makeFromSQL(results);

        MailSender mailSender = new MailSender(recipients, str);
        mailSender.send();

    }
}
