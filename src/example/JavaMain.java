package example;

import example.javamodules.Config;
import example.javamodules.Example;
import example.spec.ICopier;
import ru.abishev.tcontainer.ModuleBuilder;
import ru.abishev.tcontainer.main.*;

import static ru.abishev.tcontainer.main.ModuleLoader.load;

/**
 * Date: Apr 1, 2010
 * Time: 10:30:26 PM
 *
 * @author Timur Abishev (timur@abishev.ru)
 */
public class JavaMain {
    public static void main(String[] args) throws NotAllImportedBeansException, BeanNotFoundException {
        Module example = ModuleBuilder.from(new Example());
        Module config = ModuleBuilder.from(new Config());
        
        // module internals checks when you create the module
        // module dependencies checks when you load module

        BeanContainer container = load(example, load(config));

        ICopier copier = (ICopier) container.instanceOf("copier");
        copier.copy();
    }
}
