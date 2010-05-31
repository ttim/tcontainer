package ru.abishev.tcontainer.configurable.beans;

import ru.abishev.tcontainer.main.Bean;

/**
 * Date: Apr 2, 2010
 * Time: 1:23:31 AM
 *
 * @author Timur Abishev (timur@abishev.ru)
 */
public class PrototypeBean extends AbstractBean {
    @Override
    public Object getInstance() {
        return BeanHelper.createObjectFrom(clazz, parameters);
    }
}