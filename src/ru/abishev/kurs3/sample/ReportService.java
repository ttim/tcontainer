package ru.abishev.kurs3.sample;

import java.util.Map;

/**
 * Date: Apr 7, 2010
 * Time: 9:11:03 PM
 *
 * @author Timur Abishev (timur@abishev.ru)
 */
public class ReportService implements Injectable {
    private ReportGenerator generator;
        // = (ReportGenerator) Container.getContainer().getComponent("generator");
    private StatisticSource statisticSource;
        // = (StatisticSource) Container.getContainer().getComponent("statisticSource");

    public ReportService() {
    }

    public ReportService(ReportGenerator generator, StatisticSource statisticSource) {
        this.generator = generator;
        this.statisticSource = statisticSource;
    }

    public void setGenerator(ReportGenerator generator) {
        this.generator = generator;
    }

    public void setStatisticSource(StatisticSource statisticSource) {
        this.statisticSource = statisticSource;
    }

    public void generateYearReport() {
        generator.generate(statisticSource.getStatistic());    
    }

    public static void main(String[] args) {
        (new ReportService()).generateYearReport();
    }

    public void inject(Map<String, Object> components) {
        this.generator = (ReportGenerator) components.get("generator");
        this.statisticSource = (StatisticSource) components.get("statisticSource");
    }
}
