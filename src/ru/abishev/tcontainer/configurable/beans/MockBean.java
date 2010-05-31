package ru.abishev.tcontainer.configurable.beans;

import ru.abishev.tcontainer.main.Bean;

/**
 * Date: Apr 1, 2010
 * Time: 11:19:35 PM
 *
 * @author Timur Abishev (timur@abishev.ru)
 */
public class MockBean implements Bean {
    private final String name;
    private final Class clazz;

    public MockBean(String name, Class clazz) {
        this.name = name;
        this.clazz = clazz;
    }

    public String getName() {
        return name;
    }

    public Class getClazz() {
        return clazz;
    }

    public Object getInstance() {
        throw new UnsupportedOperationException();
    }
}
