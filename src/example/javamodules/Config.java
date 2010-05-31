package example.javamodules;

import ru.abishev.tcontainer.configurable.JavaModuleConfig;
import ru.abishev.tcontainer.main.Bean;
import ru.abishev.tcontainer.main.BeanNotFoundException;

/**
 * Date: Apr 1, 2010
 * Time: 6:04:09 PM
 *
 * @author Timur Abishev (timur@abishev.ru)
 */
public class Config extends JavaModuleConfig {
    @Override
    protected void config() {
        bean("repeatCount").withValue(5);
        bean("prefix").withValue("This is prefix YEAHHH !");

        exportBeans("repeatCount", "prefix");
    }
}
