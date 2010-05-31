package ru.abishev.tcontainer.configurable;

import ru.abishev.tcontainer.main.BeanContainer;
import ru.abishev.tcontainer.main.Module;
import ru.abishev.tcontainer.main.NotAllImportedBeansException;

/**
 * Date: Apr 3, 2010
 * Time: 6:07:05 PM
 *
 * @author Timur Abishev (timur@abishev.ru)
 */
public class ConfigurableModule implements Module {
    private final ModuleConfig config;
    
    public ConfigurableModule(ModuleConfig config) {
        this.config = config;

        CheckingContext context = new CheckingContext();
        config.config(context); // checking config
    }

    public BeanContainer getExportedBeans(BeanContainer importedBeans) throws NotAllImportedBeansException {
        RunnableContext context = new RunnableContext(importedBeans);
        config.config(context);
        return context.getExportedBeans();
    }
}
