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

public class HiOne implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean, BeanPostProcessor{
	private String one;
	
	public String getOne() {
		return one;
	}
	public void setOne(String one) {
		this.one = one;
	}
	
	public void init() {
		System.out.println("init");
	}
	
	public void customDestroy() {
		System.out.println("customDestroy");
	}
	
	public void destroy() {
		System.out.println("destroy");
	}
	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		System.out.println("setApplicationContext");
	}
	@Override
	public void setBeanFactory(BeanFactory arg0) throws BeansException {
		System.out.println("setBeanFactory");
	}
	@Override
	public void setBeanName(String arg0) {
		System.out.println("setBeanName");
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet");
	}
	@Override
	public Object postProcessAfterInitialization(Object arg0, String arg1)
			throws BeansException {
		System.out.println("postProcessAfterInitialization");
		return arg0;
	}
	@Override
	public Object postProcessBeforeInitialization(Object arg0, String arg1)
			throws BeansException {
		System.out.println("postProcessBeforeInitialization");
		return arg0;
	}
}
