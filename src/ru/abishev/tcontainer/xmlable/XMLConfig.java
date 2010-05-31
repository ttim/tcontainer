package ru.abishev.tcontainer.xmlable;

import org.xml.sax.SAXException;
import ru.abishev.tcontainer.configurable.ConfigurableModuleContext;
import ru.abishev.tcontainer.configurable.JavaModuleConfig;
import ru.abishev.tcontainer.configurable.ModuleConfig;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Date: Apr 4, 2010
 * Time: 11:06:49 PM
 *
 * @author Timur Abishev (timur@abishev.ru)
 */
public class XMLConfig implements ModuleConfig {
    private final URL url;

    public XMLConfig(String fileName) throws MalformedURLException {
        this(new File(fileName));
    }

    public XMLConfig(File file) throws MalformedURLException {
        this(file.toURI().toURL());
    }

    public XMLConfig(URL url) {
        this.url = url;
    }

    public void config(ConfigurableModuleContext context) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            factory.newSAXParser().parse(url.openStream(), new XMLHandler(context));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
