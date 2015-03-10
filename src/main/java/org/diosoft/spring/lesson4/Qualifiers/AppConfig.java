package org.diosoft.spring.lesson4.qualifiers;

import org.diosoft.spring.lesson4.ObserverHelperImpl;
import org.diosoft.spring.lesson4.ObserverHelperImpl2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

/**
 * Created by tolikgag on 09.03.2015.
 */
@Configuration
@PropertySource("classpath:/lesson4.properties")
class AppConfig {

    @Autowired
    Environment env;

    @Bean
    public static PropertySourcesPlaceholderConfigurer getProperties(){
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public ObserverHelperImpl2 observerHelperImpl2(){
        return new ObserverHelperImpl2();
    }

    @Bean
    @Qualifier("observerHelperImpl3")
    public ObserverHelperImpl observerHelperImpl(){
        return new ObserverHelperImpl();
    }

    @Bean
    @MyAnnotation
    public Person person(){
        return new Person();
    }
}
