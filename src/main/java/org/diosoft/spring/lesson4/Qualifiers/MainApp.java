package org.diosoft.spring.lesson4.qualifiers;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

class MainApp {

	public static void main(String[] args) {

        // ApplicationContext with XML
//		AbstractApplicationContext context = new ClassPathXmlApplicationContext(
//				"lesson4-qualifiers-config.xml");
        // ApplicationContext with Annotation
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        if(context.containsBean("person")) {
            Person person = context.getBean("person", Person.class);
            person.setName("Ann");
            person.print();
        }
        else {
            System.out.println("Person Bean doesn't load");
        }
    }
}
