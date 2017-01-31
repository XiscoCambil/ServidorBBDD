package clases;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by blackwidow on 1/12/16.
 */

public class Injector {
    private static ApplicationContext cache = new ClassPathXmlApplicationContext("spring-config.xml");

    public static ApplicationContext getCache() {
        return cache;
    }
}
