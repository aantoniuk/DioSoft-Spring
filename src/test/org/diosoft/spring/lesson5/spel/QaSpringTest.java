package org.diosoft.spring.lesson5.spel;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by tolikgag on 15.03.2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:lesson5-config-test.xml")
@TestPropertySource(value = "classpath:lesson3.properties", properties = {"customProp=test"})
@ActiveProfiles("qa")
public class QaSpringTest {

    @Autowired
    ApplicationContext context;
    @Autowired
    Environment environment;

    @Test
    public void getPropertyTest(){
        Assert.assertEquals("test", environment.getProperty("customProp"));
    }

    @Test
    public void getPropertyTest2(){
        Assert.assertEquals("Ann", environment.getProperty("first"));
    }

    @Test
    public void qaPersonTest(){
        Person person = context.getBean("person", Person.class);
        Assert.assertNotNull(person);
    }

    @Test(expected = NoSuchBeanDefinitionException.class)
    public void devPersonTest(){
        Postman postman = context.getBean("postman", Postman.class);
        Assert.assertNull(postman);
    }
}
