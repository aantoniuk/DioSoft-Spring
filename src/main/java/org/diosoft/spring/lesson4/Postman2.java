package org.diosoft.spring.lesson4;

import java.util.LinkedList;
import java.util.List;

public class Postman2 extends Postman {
    private List<Person> persons = new LinkedList<Person>();

    public Postman2(){
    }

    public Postman2(List<String> personNames) {
        for (String personName : personNames){
            persons.add(new Person(personName));
        }
    }

    public void notifyObservers() {
        for(Person person : persons) {
            applicationEventPublisher.publishEvent(new PersonEvent(person));
        }
    }
}
