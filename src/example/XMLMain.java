package example;

import example.javamodules.Config;
import example.javamodules.Example;
import example.spec.ICopier;
import ru.abishev.tcontainer.ModuleBuilder;
import ru.abishev.tcontainer.main.BeanContainer;
import ru.abishev.tcontainer.main.BeanNotFoundException;
import ru.abishev.tcontainer.main.Module;
import ru.abishev.tcontainer.main.NotAllImportedBeansException;

import java.io.File;
import java.net.MalformedURLException;

import static ru.abishev.tcontainer.main.ModuleLoader.load;

/**
 * Date: Apr 1, 2010
 * Time: 10:30:26 PM
 *
 * @author Timur Abishev (timur@abishev.ru)
 */
public class XMLMain {
    public static void main(String[] args) throws NotAllImportedBeansException, BeanNotFoundException, MalformedURLException {
        Module example = ModuleBuilder.from("src/example/xmlmodules/example.xml");
        Module config = ModuleBuilder.from("src/example/xmlmodules/config.xml");

        // module internals checks when you create the module
        // module dependencies checks when you load module

        BeanContainer container = load(example, load(config));

        ICopier copier = (ICopier) container.instanceOf("copier");
        copier.copy();
    }
}