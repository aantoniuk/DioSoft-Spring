package org.diosoft.spring.lesson4.profiles;

import org.diosoft.spring.lesson4.Person;
import org.diosoft.spring.lesson4.Postman;
import org.diosoft.spring.lesson4.Postman2;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.core.env.AbstractEnvironment;

public class MainApp {

	public static void main(String[] args) {
        // default profiles
        System.setProperty(AbstractEnvironment.DEFAULT_PROFILES_PROPERTY_NAME, "dev");
        // active profiles
        System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, "qa");

        // ApplicationContext with XML
//		AbstractApplicationContext context = new ClassPathXmlApplicationContext(
//				"lesson4-profiles-config.xml");
        // ApplicationContext with Annotation
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        //single postman
        System.out.println("Single Postman");
        Postman postman = context.getBean("postman", Postman.class);

        postman.notifyObservers(new Person("Ann"));
        postman.notifyObservers(new Person("John"));
        postman.notifyObservers(new Person("Tom"));

        //postman with person's array
        if(context.containsBeanDefinition("postman2")) {
                System.out.println("Complex Postman");
                Postman2 postman2 = context.getBean("postman2", Postman2.class);
                postman2.notifyObservers();
        }
    }
}
