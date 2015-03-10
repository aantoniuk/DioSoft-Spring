package org.diosoft.spring.lesson4;

/**
 * Created by tolikgag on 10.03.2015.
 */
public class ObserverHelperImpl implements ObserverHelper {

    public void printPerson(org.diosoft.spring.lesson4.Person person) {
        System.out.println("Run ObserverHelperImpl class");
        System.out.println("Person{" +
                "name='" + person.getName() + '\'' +
                '}');
    }
}
