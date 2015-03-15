package org.diosoft.spring.lesson5.spel;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by tolikgag on 15.03.2015.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        PersonTest.class,
        PostmanTest.class,
        QaSpringTest.class,
        DevSpringTest.class,
        DevQaSpringTest.class
})
public class JunitTestSuite {
}
