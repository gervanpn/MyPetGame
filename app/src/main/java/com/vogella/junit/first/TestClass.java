package com.vogella.junit.first;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
@RunWith(Suite.class)
@SuiteClasses({
        TestClass.MyClassTest.class,
        TestClass.MySecondClassTest.class })
public class TestClass {

    public class MyClassTest {
    }

    public class MySecondClassTest {
    }
}