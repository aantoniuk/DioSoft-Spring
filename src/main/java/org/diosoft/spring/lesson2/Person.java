package org.diosoft.spring.lesson2;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

class Person implements Observer, BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {

	private String name;

	public Person() {
	}

	public Person(String name) {
		this.name = name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void notify(Message message) {
		System.out.println(message.getMessage() + ", " + name);
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("Person destroy");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Person afterPropertiesSet");
	}
	
	public void customInit() throws Exception {
		System.out.println("Person customInit");
	}
	
	public void customDestroy(){
		System.out.println("Person customDestroy");
	}

	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		System.out.println("Person setApplicationContext");
	}

	@Override
	public void setBeanFactory(BeanFactory arg0) throws BeansException {
		System.out.println("Person setBeanFactory");
	}

	@Override
	public void setBeanName(String arg0) {
		System.out.println("Person setBeanName");
	}
}
