package ru.abishev.tcontainer.main;

import ru.abishev.tcontainer.configurable.beans.primitive.IntegerBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: Apr 3, 2010
 * Time: 3:14:34 PM
 *
 * @author Timur Abishev (timur@abishev.ru)
 */
public class ModuleLoader {
    public static BeanContainer load(Module toLoad, BeanContainer... dependencies) throws NotAllImportedBeansException {
        List<Bean> importedBeans = new ArrayList<Bean>();
        for (BeanContainer module : dependencies) {
            importedBeans.addAll(module.getAllBeans());
        }

        return toLoad.getExportedBeans(new SimpleBeanContainer(importedBeans));
    }
}
