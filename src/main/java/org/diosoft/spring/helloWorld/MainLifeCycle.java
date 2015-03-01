package org.diosoft.spring.helloWorld;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainLifeCycle {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("----------------------------init context");
		//@SuppressWarnings("resource")
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("helloWorldBeans.xml");
		
		System.out.println("----------------------------create bean object");
		context.getBean("one2");
		context.getBean("one");
		
//		HelloWorldSingleton obj = (HelloWorldSingleton) context.getBean("helloWorldSingleton");
//		obj.getMessage();
//		
//		HelloWorldPrototype obj2 = (HelloWorldPrototype) context.getBean("helloWorldPrototype");
//		obj2.getMessage();
		
		context.registerShutdownHook();
	}
}
