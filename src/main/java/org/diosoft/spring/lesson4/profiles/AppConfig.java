package org.diosoft.spring.lesson4.profiles;

import org.diosoft.spring.lesson4.PersonEventListener;
import org.diosoft.spring.lesson4.Postman;
import org.diosoft.spring.lesson4.Postman2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by tolikgag on 09.03.2015.
 */
@Configuration
@PropertySource("classpath:/lesson4-profiles.properties")
public class AppConfig {

    @Autowired
    Environment  env;

    @Bean
    public Postman postman(){
        return new Postman();
    }

    @Bean
    @Profile("dev")
    public PersonEventListener personEventListener1(){
        return new PersonEventListener();
    }

    @Bean
    @Profile("qa")
    public PersonEventListener personEventListener2(){
        return new PersonEventListener();
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer getProperties(){
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    @Conditional(PropertyCondition.class)
    public Postman2 postman2(){
        List<String> personNameList = new LinkedList<String>(Arrays.asList(env.getProperty("first"),env.getProperty("second"),env.getProperty("third")));
        return new Postman2(personNameList);
    }
}
