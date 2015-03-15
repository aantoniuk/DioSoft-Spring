package org.diosoft.spring.lesson2;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.ArrayList;
import java.util.List;

class Postman implements Subject, BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {

	private List<Observer> observers = new ArrayList<Observer>();

	public Postman() {
	};

	@Override
	public void register(Observer obj) {
		observers.add(obj);
	}

	@Override
	public void unregister(Observer obj) {
		observers.remove(obj);
	}

	@Override
	public void notifyObservers(Message message) {
		for (Observer observer : observers) {
			observer.notify(message);
		}
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("Postman destroy");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Postman afterPropertiesSet");
	}
	
	public void customInit() throws Exception {
		System.out.println("Postman customInit");
	}
	
	public void customDestroy(){
		System.out.println("Postman customDestroy");
	}

	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		System.out.println("Postman setApplicationContext");
	}

	@Override
	public void setBeanFactory(BeanFactory arg0) throws BeansException {
		System.out.println("Postman setBeanFactory");
	}

	@Override
	public void setBeanName(String arg0) {
		System.out.println("Postman setBeanName");
	}
}
