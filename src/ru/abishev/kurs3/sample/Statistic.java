package ru.abishev.kurs3.sample;

/**
 * Date: Apr 7, 2010
 * Time: 9:05:17 PM
 *
 * @author Timur Abishev (timur@abishev.ru)
 */
public class Statistic {
    private final int[][] data;

    public Statistic(int[][] data) {
        this.data = data;
    }

    public int[][] getData() {
        return data;
    }
}
