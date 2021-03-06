package org.diosoft.spring.lesson3;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationListener;

class PersonEventListener implements ApplicationListener<PersonEvent>, BeanNameAware {

    //local code review (vtegza): should be private @ 15.03.15
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
