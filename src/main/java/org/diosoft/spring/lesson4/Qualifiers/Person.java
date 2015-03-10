package org.diosoft.spring.lesson4.qualifiers;

import org.diosoft.spring.lesson4.ObserverHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

class Person extends org.diosoft.spring.lesson4.Person{

	@Autowired
	@Qualifier("observerHelperImpl3")
	private ObserverHelper observerHelper;

	public void print(){
		observerHelper.printPerson(this);
	}
}
