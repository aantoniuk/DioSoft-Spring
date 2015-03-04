package org.diosoft.spring.lesson2;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		
		System.out.println("----------------------------init context");
		// create ApplicationContext
		@SuppressWarnings("resource")
		AbstractApplicationContext context = new ClassPathXmlApplicationContext(
				"lesson2-config.xml");
		context.registerShutdownHook();
		DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) context.getBeanFactory();
		
		// create Person's BeanDefinition
		GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
		beanDefinition.setBeanClass(Person.class);
		beanDefinition.setInitMethodName("customInit");
		beanDefinition.setScope("prototype");
		beanDefinition.setLazyInit(true);
		beanDefinition.setAbstract(false);
		beanDefinition.setAutowireCandidate(true);
		// register Person Bean
		beanFactory.registerBeanDefinition("person", beanDefinition);
		
		System.out.println("----------------------------create bean's objects");

		// create message
		Message message = new Message("Hello");

		// create persons
		Person ann = context.getBean("person", Person.class);
		ann.setName("Ann");
		Person john = context.getBean("person", Person.class);
		john.setName("John");
		Person tom = context.getBean("person", Person.class);
		tom.setName("Tom");

		// create postman
		Postman postman = context.getBean(Postman.class);
		postman.register(ann);
		postman.register(john);
		postman.register(tom);
		
		System.out.println("----------------------------send message");
		//send messages
		postman.notifyObservers(message);

		System.out.println("----------------------------destroy bean objects");
		// destroy bean objects
		context.registerShutdownHook();
	}
}
