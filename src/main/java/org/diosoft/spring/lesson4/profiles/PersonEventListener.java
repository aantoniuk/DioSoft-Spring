package org.diosoft.spring.lesson4.profiles;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationListener;

class PersonEventListener implements ApplicationListener<PersonEvent>, BeanNameAware {

    String name;

    @Override
    public void onApplicationEvent(PersonEvent personEvent) {
        System.out.println("We got an Event with person " + personEvent.getSource() + " for listener " + name);
    }

    @Override
    public void setBeanName(String name) {
        this.name = name;
    }
}
