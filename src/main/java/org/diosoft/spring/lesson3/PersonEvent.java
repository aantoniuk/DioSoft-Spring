package org.diosoft.spring.lesson3;

import org.springframework.context.ApplicationEvent;

public class PersonEvent extends ApplicationEvent {

    public PersonEvent(Person person) {
        super(person);
    }

    public Person getSource(){
        return (Person) super.getSource();
    }
}
