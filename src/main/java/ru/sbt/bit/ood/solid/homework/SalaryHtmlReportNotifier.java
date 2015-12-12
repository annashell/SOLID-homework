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
     * @param recipients в случае, если результаты не отсылаются, а сохраняются где-либо, в этот параметр складывается путь сохранения
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
Надо отрефакторить код, применив принципы SOLID, учитывая следующие вещи:

    Могут появляться новые источники salary data (отличные от  SQL databases)
    Могут появляться новые отчеты (“min salary report”, “avg salary report”)
    Могут появляться новые форматы отчетов (pdf/excel/etc)
    Результаты могут рассылаться не только на почту, но и складываться например на ftp или просто в локальную папку
    (вместо отправки по e-mail)


*/
