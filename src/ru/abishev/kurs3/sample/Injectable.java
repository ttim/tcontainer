package ru.abishev.kurs3.sample;

import java.util.Map;

/**
 * Date: Apr 8, 2010
 * Time: 12:07:18 PM
 *
 * @author Timur Abishev (timur@abishev.ru)
 */
public interface Injectable {
    void inject(Map<String, Object> components);
}
