package ru.abishev.tcontainer.configurable.beans;

import ru.abishev.tcontainer.main.Bean;

/**
 * Date: Apr 2, 2010
 * Time: 1:27:02 AM
 *
 * @author Timur Abishev (timur@abishev.ru)
 */
public class NotLazySingletonBean extends AbstractBean {
    private Object instance = null;
    
    @Override
    public Object getInstance() {
        return instance;
    }

    @Override
    public void finish() {
        instance = BeanHelper.createObjectFrom(clazz, parameters);
    }
}