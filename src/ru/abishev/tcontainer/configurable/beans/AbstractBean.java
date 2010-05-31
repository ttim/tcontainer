package ru.abishev.tcontainer.configurable.beans;

import ru.abishev.tcontainer.main.Bean;

import java.util.Map;

/**
 * Date: Apr 3, 2010
 * Time: 7:37:27 PM
 *
 * @author Timur Abishev (timur@abishev.ru)
 */
abstract public class AbstractBean implements Bean {
    protected String name;
    protected Class clazz;
    protected Map<String, Bean> parameters;

    public String getName() {
        return name;
    }

    public Class getClazz() {
        return clazz;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    public void setParameters(Map<String, Bean> parameters) {
        this.parameters = parameters;
    }

    public void finish() {
    }

    abstract public Object getInstance();
}
