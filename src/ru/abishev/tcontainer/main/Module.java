package ru.abishev.tcontainer.main;

import ru.abishev.tcontainer.main.Bean;

import java.util.List;

/**
 * Date: Apr 1, 2010
 * Time: 10:45:51 PM
 *
 * @author Timur Abishev (timur@abishev.ru)
 */
public interface Module {
    BeanContainer getExportedBeans(BeanContainer importedBeans) throws NotAllImportedBeansException;
}