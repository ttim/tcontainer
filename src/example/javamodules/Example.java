package example.javamodules;

import example.concrete.*;
import ru.abishev.tcontainer.configurable.JavaModuleConfig;
import ru.abishev.tcontainer.main.Bean;

/**
 * Date: Apr 1, 2010
 * Time: 3:04:08 PM
 *
 * @author Timur Abishev (timur@abishev.ru)
 */
public class Example extends JavaModuleConfig {
    protected void config() {
        Bean repeatCount = importBean("repeatCount", Integer.class);
        Bean prefix = importBean("prefix", String.class);

        bean("writer").withClass(Writer.class).finish();
        bean("reader").withClass(Reader.class).finish();

        Bean copier = notLazySingletonBean("copier").withClass(Copier.class)
                .set("Writer").toBean("writer")
                .set("Reader").toBean("reader")
                .set("RepeatCount").to(repeatCount)
                .set("Prefix").to(prefix)
                .finish();

        exportBeans(copier);
    }
}