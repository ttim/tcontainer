package ru.abishev.tcontainer.configurable.beans;

import ru.abishev.tcontainer.main.Bean;

/**
 * Date: Apr 2, 2010
 * Time: 1:27:02 AM
 *
 * @author Timur Abishev (timur@abishev.ru)
 */
public class LazySingletonBean extends AbstractBean {
    private Object instance = null;

    @Override
    synchronized public Object getInstance() {
        if (instance == null) {
            instance = BeanHelper.createObjectFrom(clazz, parameters);
        }

        return instance;
    }
}