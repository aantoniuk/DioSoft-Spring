package org.diosoft.spring.lesson4.profiles;

import org.diosoft.spring.lesson4.Person;
import org.springframework.context.ApplicationEvent;

class PersonEvent extends ApplicationEvent {

    public PersonEvent(Person person) {
        super(person);
    }

    public Person getSource(){
        return (Person) super.getSource();
    }
}
