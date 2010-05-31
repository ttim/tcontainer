package ru.abishev.tcontainer.configurable;

import ru.abishev.tcontainer.configurable.beans.AbstractBean;
import ru.abishev.tcontainer.configurable.beans.BeanHelper;
import ru.abishev.tcontainer.configurable.beans.BeanType;
import ru.abishev.tcontainer.configurable.beans.ProxyBean;
import ru.abishev.tcontainer.configurable.beans.primitive.IntegerBean;
import ru.abishev.tcontainer.configurable.beans.primitive.StringBean;
import ru.abishev.tcontainer.configurable.beans.primitive.ValueBean;
import ru.abishev.tcontainer.main.Bean;
import ru.abishev.tcontainer.main.BeanContainer;
import ru.abishev.tcontainer.main.BeanNotFoundException;
import ru.abishev.tcontainer.main.SimpleBeanContainer;

import java.util.*;

/**
 * Date: Apr 3, 2010
 * Time: 6:38:18 PM
 *
 * @author Timur Abishev (timur@abishev.ru)
 */
public class RunnableContext implements ConfigurableModuleContext {
    private final BeanContainer importedBeans;
    private Set<Bean> exportedBeans = new HashSet<Bean>();

    private Map<String, Bean> beans = new HashMap<String, Bean>();

    public RunnableContext(BeanContainer importedBeans) {
        this.importedBeans = importedBeans;
    }

    public Bean importBean(final String name, final Class clazz) {
        Bean bean = null;
        try {
            if (BeanHelper.isCastable(importedBeans.beanOf(name).getClazz(), clazz)) {
                bean = importedBeans.beanOf(name);
            } else {
                throw new ImportedBeanHasIllegalClassException();
            }
        } catch (BeanNotFoundException e) {
            throw new RuntimeException(e);
        }

        addBean(bean);
        return bean;
    }

    public Bean getBeanOf(String name) throws BeanNotFoundException {
        Bean bean = beans.get(name);
        if (bean == null) {
            throw new BeanNotFoundException();
        }
        return bean;
    }

    public BeanBuilder bean(String name) {
        return new ConcreteBeanBuilder().withName(name);
    }

    public void exportBean(Bean bean) {
        exportedBeans.add(bean);
    }

    public BeanContainer getExportedBeans() {
        List<Bean> exportedBeans = new ArrayList<Bean>();
        for (Bean bean : this.exportedBeans) {
            exportedBeans.add(bean);
        }

        return new SimpleBeanContainer(exportedBeans);
    }

    private void addBean(Bean bean) {
        if (bean.getName() != null) {
            beans.put(bean.getName(), bean);
        }
    }

    public class ConcreteBeanBuilder implements BeanBuilder {
        private String name;
        private Class clazz;

        private String currentParameterName = null;

        private Map<String, Bean> parametersMap = new HashMap<String, Bean>();

        private BeanType type;

        private Bean value = null;

        public BeanBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public Bean withValue(Object object) {
            return finish(new ValueBean(name, object));
        }

        public BeanBuilder set(String name) {
            currentParameterName = name;
            return this;
        }

        public BeanBuilder to(Bean bean) {
            if (currentParameterName == null) {
                throw new IllegalArgumentException();
            }

            parametersMap.put(currentParameterName, bean);
            currentParameterName = null;
            return this;
        }

        public BeanBuilder toBean(String name) {
            return to(beans.get(name));
        }

        public BeanBuilder to(int value) {
            return to(new IntegerBean(value));
        }

        public BeanBuilder to(String value) {
            return to(new StringBean(value));
        }

        public BeanBuilder lazySingleton() {
            type = BeanType.LAZY_SINGLETON;
            return this;
        }

        public BeanBuilder notLazySingleton() {
            type = BeanType.NOT_LAZY_SINGLETON;
            return this;
        }

        public BeanBuilder prototype() {
            type = BeanType.PROTOTYPE;
            return this;
        }

        public BeanBuilder withClass(Class clazz) {
            this.clazz = clazz;
            return this;
        }

        private Bean finish(Bean bean) {
            this.value = bean;
            addBean(bean);
            return bean;
        }

        public Bean finish() {
            if (value == null) {
                AbstractBean value = type.getBeanForType();

                value.setName(name);
                value.setClazz(clazz);
                value.setParameters(parametersMap);

                value.finish();

                return finish(value);
            } else {
                return value;
            }
        }
    }
}
