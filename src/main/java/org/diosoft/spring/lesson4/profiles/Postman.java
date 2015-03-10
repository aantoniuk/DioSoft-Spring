package org.diosoft.spring.lesson4.profiles;

import org.diosoft.spring.lesson4.Person;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

class Postman implements ApplicationEventPublisherAware{

    protected ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void notifyObservers(Person person) {
        applicationEventPublisher.publishEvent(new PersonEvent(person));
    }
}
