package org.diosoft.spring.helloWorld;

import org.springframework.beans.factory.access.BeanFactoryLocator;
import org.springframework.beans.factory.access.BeanFactoryReference;
import org.springframework.context.access.ContextSingletonBeanFactoryLocator;

public class ContextSingletonBeanFactoryLocatorLifeCycle {

	public static void main(String[] args) {
		callContext("first");
		callContext("second");

	}
	
	private static void callContext(String value){
		BeanFactoryLocator bfl = ContextSingletonBeanFactoryLocator.getInstance("beanRefContextHelloWorld.xml");
		BeanFactoryReference bf = bfl.useBeanFactory("helloWorldMainContext");
		
		HelloWorldPrototype obj2 = (HelloWorldPrototype) bf.getFactory().getBean("helloWorldPrototype");
		obj2.setMessage(value);
		obj2.getMessage();
	}

}
