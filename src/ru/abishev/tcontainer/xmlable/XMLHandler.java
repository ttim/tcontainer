package ru.abishev.tcontainer.xmlable;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import ru.abishev.tcontainer.configurable.BeanBuilder;
import ru.abishev.tcontainer.configurable.ConfigurableModuleContext;
import ru.abishev.tcontainer.main.BeanNotFoundException;

/**
 * Date: Apr 4, 2010
 * Time: 11:09:31 PM
 *
 * @author Timur Abishev (timur@abishev.ru)
 */
public class XMLHandler extends DefaultHandler {
    private final ConfigurableModuleContext context;

    private StringBuilder text = new StringBuilder();

    private BeanBuilder currentBuilder;

    public XMLHandler(ConfigurableModuleContext context) {
        this.context = context;
    }

    @Override
    public void startElement(String s2, String s1, String s, Attributes attributes) throws SAXException {
        text = new StringBuilder();
        
        if ("import".equals(s)) {
            try {
                context.importBean(attributes.getValue("bean"), Class.forName(attributes.getValue("class")));
            } catch (ClassNotFoundException e) {
                throw new SAXException(e);
            }
        } else if ("bean".equals(s)) {
            currentBuilder = context.bean(attributes.getValue("name"));

            if (attributes.getValue("class") != null) {
                try {
                    currentBuilder = currentBuilder.withClass(Class.forName(attributes.getValue("class")));
                } catch (ClassNotFoundException e) {
                    throw new SAXException(e);
                }
            }

            if (attributes.getValue("lazy") != null) {
                if ("false".equals(attributes.getValue("lazy"))) {
                    currentBuilder = currentBuilder.notLazySingleton();
                } else {
                    currentBuilder = currentBuilder.lazySingleton();
                }
            } else {
                currentBuilder = currentBuilder.prototype();
            }
        } else if ("property".equals(s)) {
            currentBuilder.set(attributes.getValue("name")).toBean(attributes.getValue("ref"));
        } else if ("export".equals(s)) {
            try {
                context.exportBean(context.getBeanOf(attributes.getValue("bean")));
            } catch (BeanNotFoundException e) {
                throw new SAXException(e);
            }
        }
    }

    @Override
    public void endElement(String s2, String s1, String s) throws SAXException {
        if ("bean".equals(s)) {
            currentBuilder.finish();
            currentBuilder = null;
        } else if ("int".equals(s)) {
            currentBuilder.withValue(Integer.parseInt(text.toString()));
        } else if ("string".equals(s)) {
            currentBuilder.withValue(text.toString());
        }
        text = new StringBuilder();
    }

    @Override
    public void characters(char[] chars, int i, int i1) throws SAXException {
        text.append(new String(chars, i, i1));
    }
}
