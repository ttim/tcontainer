package ru.abishev.tcontainer.configurable;

import ru.abishev.tcontainer.main.Bean;
import ru.abishev.tcontainer.main.BeanNotFoundException;

/**
 * Date: Apr 3, 2010
 * Time: 6:18:40 PM
 *
 * @author Timur Abishev (timur@abishev.ru)
 */
public class ConfigHelper {
    public static void exportBean(ConfigurableModuleContext context, String name) throws BeanNotFoundException {
        context.exportBean(context.getBeanOf(name));
    }

    public static void exportBeans(ConfigurableModuleContext context, Bean... beans) {
        for (Bean bean : beans) {
            context.exportBean(bean);
        }
    }

    public static void exportBeans(ConfigurableModuleContext context, String... names) throws BeanNotFoundException {
        for (String name : names) {
            exportBean(context, name);
        }
    }
}
