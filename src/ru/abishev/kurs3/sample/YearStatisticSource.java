package ru.abishev.kurs3.sample;

/**
 * Date: Apr 7, 2010
 * Time: 9:12:13 PM
 *
 * @author Timur Abishev (timur@abishev.ru)
 */
public class YearStatisticSource implements StatisticSource {
    public Statistic getStatistic() {
        return new Statistic(new int[][]{});
    }
}
