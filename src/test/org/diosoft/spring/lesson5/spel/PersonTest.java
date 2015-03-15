package org.diosoft.spring.lesson5.spel;

import org.junit.*;

public class PersonTest {

    @BeforeClass
    public static void beforeClass(){
        System.out.println("beforeClass");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("afterClass");
    }

    @Before
    public void before(){
        System.out.println("before");
    }

    @After
    public void after(){
        System.out.println("after");
    }

    @Test
    public void testGetName() throws Exception {
        System.out.println("run testGetName");
    }

    @Test
    public void testSetName() throws Exception {
        System.out.println("run testSetName");
    }
}