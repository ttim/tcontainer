package ru.abishev.tcontainer.configurable.beans;

import ru.abishev.tcontainer.main.Bean;

/**
 * Date: Apr 3, 2010
 * Time: 8:49:51 PM
 *
 * @author Timur Abishev (timur@abishev.ru)
 */
abstract public class ProxyBean implements Bean {
    abstract protected Bean getProxy();
    
    public String getName() {
        return getProxy().getName();
    }

    public Class getClazz() {
        return getProxy().getClazz();
    }

    public Object getInstance() {
        return getProxy().getInstance();
    }
}
