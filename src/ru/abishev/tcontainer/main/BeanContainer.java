package ru.abishev.tcontainer.main;

import java.util.List;

/**
 * Date: Apr 3, 2010
 * Time: 3:15:02 PM
 *
 * @author Timur Abishev (timur@abishev.ru)
 */
public interface BeanContainer {
    Object instanceOf(String beanName) throws BeanNotFoundException;
    Bean beanOf(String beanName) throws BeanNotFoundException;

    List<Bean> getAllBeans();
}
