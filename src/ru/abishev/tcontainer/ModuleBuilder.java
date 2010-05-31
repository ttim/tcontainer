package ru.abishev.tcontainer;

import ru.abishev.tcontainer.configurable.ConfigurableModule;
import ru.abishev.tcontainer.configurable.ModuleConfig;
import ru.abishev.tcontainer.main.Module;
import ru.abishev.tcontainer.xmlable.XMLConfig;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Date: Apr 3, 2010
 * Time: 6:05:37 PM
 *
 * @author Timur Abishev (timur@abishev.ru)
 */
public class ModuleBuilder {
    public static Module from(ModuleConfig config) {
        return new ConfigurableModule(config);
    }

    public static Module from(File file) throws MalformedURLException {
        return from(new XMLConfig(file));
    }

    public static Module from(URL url) {
        return from(new XMLConfig(url));
    }

    public static Module from(String fileName) throws MalformedURLException {
        return from(new XMLConfig(fileName));
    }
}
