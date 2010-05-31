package ru.abishev.tcontainer.configurable.beans.primitive;

import ru.abishev.tcontainer.main.Bean;

/**
 * Date: Apr 3, 2010
 * Time: 7:49:24 PM
 *
 * @author Timur Abishev (timur@abishev.ru)
 */
public class ValueBean implements Bean {
    private final String name;
    private final Object value;
    
    public ValueBean(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Class getClazz() {
        return value.getClass();
    }

    public Object getInstance() {
        return value;
    }
}
