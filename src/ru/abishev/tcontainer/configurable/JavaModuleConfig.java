package ru.abishev.tcontainer.configurable;

import ru.abishev.tcontainer.main.*;

/**
 * Date: Apr 3, 2010
 * Time: 6:09:39 PM
 *
 * @author Timur Abishev (timur@abishev.ru)
 */
abstract public class JavaModuleConfig implements ModuleConfig {
    private ConfigurableModuleContext context;

    abstract protected void config();

    public void config(ConfigurableModuleContext context) {
        this.context = context;
        config();
    }

    protected BeanBuilder prototypeBean(String name) {
        return context.bean(name).prototype();
    }

    protected BeanBuilder notLazySingletonBean(String name) {
        return context.bean(name).notLazySingleton();
    }

    protected BeanBuilder lazySingletonBean(String name) {
        return context.bean(name).lazySingleton();
    }

    protected BeanBuilder singletonBean(String name) {
        return lazySingletonBean(name);
    }

    protected BeanBuilder bean(String name) {
        return singletonBean(name);
    }

    protected Bean importBean(String name, Class clazz) {
        return context.importBean(name, clazz);
    }

    protected void exportBeans(Bean... beans) {
        ConfigHelper.exportBeans(context, beans);
    }

    protected void exportBean(Bean bean) {
        context.exportBean(bean);
    }

    protected void exportBean(String name) throws BeanNotFoundException {
        ConfigHelper.exportBean(context, name);
    }

    protected void exportBeans(String... names) throws BeanNotFoundException {
        ConfigHelper.exportBeans(context, names);
    }
}
