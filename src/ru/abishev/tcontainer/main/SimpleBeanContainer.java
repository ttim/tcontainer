package ru.abishev.tcontainer.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Date: Apr 3, 2010
 * Time: 3:23:00 PM
 *
 * @author Timur Abishev (timur@abishev.ru)
 */
public class SimpleBeanContainer implements BeanContainer {
    private final List<Bean> beans;
    private final Map<String, Bean> beansMap;

    public SimpleBeanContainer(List<Bean> beans) {
        beansMap = new HashMap<String, Bean>();
        for (Bean bean : beans) {
            beansMap.put(bean.getName(), bean);
        }

        this.beans = new ArrayList<Bean>();
        for (String beanName : beansMap.keySet()) {
            this.beans.add(beansMap.get(beanName));
        }
    }

    public Object instanceOf(String beanName) throws BeanNotFoundException {
        return beanOf(beanName).getInstance();
    }

    public Bean beanOf(String beanName) throws BeanNotFoundException {
        Bean bean = beansMap.get(beanName);

        if (bean == null) {
            throw new BeanNotFoundException();
        }

        return bean;
    }

    public List<Bean> getAllBeans() {
        return beans;
    }
}
