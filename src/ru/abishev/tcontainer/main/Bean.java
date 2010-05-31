package ru.abishev.tcontainer.main;

/**
 * Date: Apr 1, 2010
 * Time: 10:42:14 PM
 *
 * @author Timur Abishev (timur@abishev.ru)
 */
public interface Bean {
    String getName();
    Class getClazz();
    Object getInstance();
}
