package org.diosoft.spring.lesson4;

/**
 * Created by tolikgag on 10.03.2015.
 */
public class ObserverHelperImpl2 implements ObserverHelper {

    public void printPerson(org.diosoft.spring.lesson4.Person person) {
        System.out.println("Run ObserverHelperImpl2 class");
        System.out.println(person.toString());
    }
}
