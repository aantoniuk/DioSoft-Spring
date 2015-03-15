package org.diosoft.spring.lesson5.spel;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.IfProfileValue;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by tolikgag on 15.03.2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:lesson5-config-test.xml")
@TestPropertySource("classpath:lesson3.properties")
@ActiveProfiles({"dev", "qa"})
public class DevQaSpringTest {

    @Autowired
    AbstractApplicationContext context;

    @DirtiesContext
    @Test
    public void qaPersonTest(){
        Person person = context.getBean("person", Person.class);
        Assert.assertNotNull(person);
        // remove Postman Bean from context
        DefaultListableBeanFactory defaultListableBeanFactory = (DefaultListableBeanFactory) context.getBeanFactory();
        defaultListableBeanFactory.removeBeanDefinition("postman");
    }

    @Test
    public void devPersonDirtiesContextTest(){
        Postman postman = context.getBean("postman", Postman.class);
        Assert.assertNotNull(postman);
    }

    @IfProfileValue(name="user.name", values={"tolikgag", "guest"})
    @Test
    public void onlySpecialUsersTest(){
        System.out.println("user.name=tolikgag or guest");
    }
}
