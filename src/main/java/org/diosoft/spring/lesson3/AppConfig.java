package org.diosoft.spring.lesson3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by tolikgag on 09.03.2015.
 */
@Configuration
@PropertySource("classpath:/lesson3.properties")
class AppConfig {

    @Autowired
    Environment  env;

    @Bean
    public Postman postman(){
        return new Postman();
    }

    @Bean
    public PersonEventListener personEventListener1(){
        return new PersonEventListener();
    }

    @Bean
    public PersonEventListener personEventListener2(){
        return new PersonEventListener();
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer getProperties(){
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public Postman2 postman2(){
        List<String> personNameList = new LinkedList<String>(Arrays.asList(env.getProperty("first"),env.getProperty("second"),env.getProperty("third")));
        return new Postman2(personNameList);
    }
}
