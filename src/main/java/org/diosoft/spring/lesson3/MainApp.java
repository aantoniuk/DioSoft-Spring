package org.diosoft.spring.lesson3;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		AbstractApplicationContext context = new ClassPathXmlApplicationContext(
				"lesson3-config.xml");
        context.registerShutdownHook();

        //single postman
        System.out.println("Single Postman");
        Postman postman = context.getBean("postman", Postman.class);

        postman.notifyObservers(new Person("Ann"));
        postman.notifyObservers(new Person("John"));
        postman.notifyObservers(new Person("Tom"));

        //postman with person's array
        System.out.println("Complex Postman");
        Postman2 postman2 = context.getBean("postman2", Postman2.class);
        postman2.notifyObservers();
    }
}
