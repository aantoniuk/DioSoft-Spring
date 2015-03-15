package org.diosoft.spring.lesson5.spel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class Postman implements org.diosoft.spring.lesson5.spel.Subject {

	@Value("#{personNameList}")
	private List<String> observerNamesFromProperties;
	private List<Observer> observers = new ArrayList<Observer>();

	public List<Observer> getObservers() {
		return observers;
	}

	public Postman() {
	};

	@Autowired
	public Postman(@Value("#{systemProperties['user.name']}") String userName){
		register(new Person(userName));
	}

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

	public void loadObserversFromProperties(){
		for (String observerName : observerNamesFromProperties){
			register(new Person(observerName));
		}
	}

	public void loadObserverByNames(Collection<String> observerNames){
		for (String observerName : observerNames){
			register(new Person(observerName));
		}
	}
}
