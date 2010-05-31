package ru.abishev.kurs3.sample;

/**
 * Date: Apr 7, 2010
 * Time: 9:05:39 PM
 *
 * @author Timur Abishev (timur@abishev.ru)
 */
public class PlainTextReportGenerator implements ReportGenerator {
    public void generate(Statistic statistic) {
        System.out.println("Plaintext report generator!");
    }
}
