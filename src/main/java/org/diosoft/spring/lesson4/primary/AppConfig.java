package org.diosoft.spring.lesson4.primary;

import org.diosoft.spring.lesson4.ObserverHelperImpl;
import org.diosoft.spring.lesson4.ObserverHelperImpl2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * Created by tolikgag on 09.03.2015.
 */
@Configuration
class AppConfig {

    @Bean
    @Primary
    public ObserverHelperImpl2 observerHelperImpl2(){
        return new ObserverHelperImpl2();
    }

    @Bean
    public ObserverHelperImpl observerHelperImpl(){
        return new ObserverHelperImpl();
    }

    @Bean
    public Person person(){
        return new Person();
    }
}
