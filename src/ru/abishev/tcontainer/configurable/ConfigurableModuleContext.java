package ru.abishev.tcontainer.configurable;

import ru.abishev.tcontainer.main.Bean;
import ru.abishev.tcontainer.main.BeanNotFoundException;
import ru.abishev.tcontainer.main.NotAllImportedBeansException;

/**
 * Date: Apr 3, 2010
 * Time: 6:08:57 PM
 *
 * @author Timur Abishev (timur@abishev.ru)
 */
public interface ConfigurableModuleContext {
    Bean importBean(String name, Class clazz);

    Bean getBeanOf(String name) throws BeanNotFoundException;

    BeanBuilder bean(String name);
    
    void exportBean(Bean bean);
}
