package ru.abishev.tcontainer.configurable;

import ru.abishev.tcontainer.main.Bean;

/**
 * Date: Apr 1, 2010
 * Time: 10:49:54 PM
 *
 * @author Timur Abishev (timur@abishev.ru)
 */
public interface BeanBuilder {
    BeanBuilder withClass(Class clazz);
    BeanBuilder withName(String name);
    Bean withValue(Object object);

    BeanBuilder set(String name);
    BeanBuilder to(Bean bean);
    BeanBuilder toBean(String name);
    BeanBuilder to(int value);
    BeanBuilder to(String value);

    BeanBuilder lazySingleton();
    BeanBuilder notLazySingleton();
    BeanBuilder prototype();

    Bean finish();
}
