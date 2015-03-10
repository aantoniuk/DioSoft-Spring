package org.diosoft.spring.lesson4.primary;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

class MainApp {

	public static void main(String[] args) {

        // ApplicationContext with XML
//		AbstractApplicationContext context = new ClassPathXmlApplicationContext(
//				"lesson4-primary-config.xml");
        // ApplicationContext with Annotation
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Person person = context.getBean("person", Person.class);
        person.setName("Ann");
        person.print();
    }
}
