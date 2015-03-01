package org.diosoft.spring.helloWorld;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class HelloWorldSingleton implements InitializingBean, DisposableBean, BeanPostProcessor, BeanNameAware, BeanFactoryAware, ApplicationContextAware {
	private String name;
	private String message;

	public void setMessage(String message) {
		this.message = message;
	}

	public void getMessage() {
		System.out.println(name + " Your Message : " + message);
	}

	@Override
	public void destroy() throws Exception {
		System.out.println(name + " destroy");
		
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println(name + " afterPropertiesSet");
		
	}
	
	public void customInit() throws Exception {
		System.out.println(name + " customInit");
		
	}
	
	public void customDestroy(){
		System.out.println(name + " customDestroy");
	}

	@Override
	public Object postProcessAfterInitialization(Object arg0, String arg1)
			throws BeansException {
		System.out.println(name + " postProcessAfterInitialization");
		return arg0;
	}

	@Override
	public Object postProcessBeforeInitialization(Object arg0, String arg1)
			throws BeansException {
		System.out.println(name + " postProcessBeforeInitialization");
		return arg0;
	}

	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		System.out.println(name + " setApplicationContext");
	}

	@Override
	public void setBeanFactory(BeanFactory arg0) throws BeansException {
		System.out.println(name + " setBeanFactory");
		
	}

	@Override
	public void setBeanName(String arg0) {
		name = arg0;
		System.out.println(name + " setBeanName");
	}
}
