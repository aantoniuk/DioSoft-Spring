package org.diosoft.spring.lesson4.primary;

import org.diosoft.spring.lesson4.ObserverHelper;
import org.springframework.beans.factory.annotation.Autowired;

class Person extends org.diosoft.spring.lesson4.Person{

	@Autowired
	private ObserverHelper observerHelper;

	public void print(){
		observerHelper.printPerson(this);
	}
}
