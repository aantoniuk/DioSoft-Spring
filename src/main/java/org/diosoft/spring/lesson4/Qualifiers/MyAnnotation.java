package org.diosoft.spring.lesson4.qualifiers;

import org.diosoft.spring.lesson4.PropertyCondition;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Conditional;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by tolikgag on 10.03.2015.
 */
@Target({ElementType.FIELD,
        ElementType.METHOD,
        ElementType.TYPE,
        ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
@Conditional(PropertyCondition.class)
@interface MyAnnotation {
}
