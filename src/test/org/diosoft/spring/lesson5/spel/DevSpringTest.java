package org.diosoft.spring.lesson5.spel;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.test.annotation.Repeat;
import org.springframework.test.annotation.Timed;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by tolikgag on 15.03.2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:lesson5-config-test.xml")
@ActiveProfiles("dev")
public class DevSpringTest {

    @Autowired
    ApplicationContext context;
    @Value("${first}")
    String firstName;

    @Test
    public void getPropertyTest(){
        Assert.assertEquals("Ann", firstName);
    }

    @Timed(millis = 10000)
    @Repeat(100)
    @Test(expected = NoSuchBeanDefinitionException.class)
    public void qaPersonTest(){
        Person person = context.getBean("person", Person.class);
        Assert.assertNull(person);
    }

    @Test
    public void devPersonTest(){
        Postman postman = context.getBean("postman", Postman.class);
        Assert.assertNotNull(postman);
    }
}
