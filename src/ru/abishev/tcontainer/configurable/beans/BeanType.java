package ru.abishev.tcontainer.configurable.beans;

/**
 * Date: Apr 2, 2010
 * Time: 1:35:44 AM
 *
 * @author Timur Abishev (timur@abishev.ru)
 */
public enum BeanType {
    PROTOTYPE, LAZY_SINGLETON, NOT_LAZY_SINGLETON;

    public AbstractBean getBeanForType() {
        switch (this) {
            case PROTOTYPE: return new PrototypeBean();
            case LAZY_SINGLETON: return new LazySingletonBean();
            case NOT_LAZY_SINGLETON: return new NotLazySingletonBean();
        }

        return null;
    }
}
