package sample;

import org.testng.annotations.*;

public class ClassTest3 {
    @BeforeSuite
    void beforeSuite(){
        System.out.println("before suite");
    }
    @BeforeClass
    void beforeClass(){
        System.out.println("before class");
    }
    @BeforeTest
    void beforeTest(){
        System.out.println("before test");
    }
    @BeforeMethod
    void beforeMethod(){
        System.out.println("Before method");
    }
    @Test
    void tc01(){
        System.out.println("tc01");
    }
    @Test
    void tc02(){
        System.out.println("tc02");
    }
    @Test
    void tc03(){
        System.out.println("tc03");
    }
    @Test
    void tc04(){
        System.out.println("tc04");
    }
    @Test
    void tc05(){
        System.out.println("tc05");
    }
    @AfterMethod
    void afterMethod(){
        System.out.println("afterMethod");
    }
    @AfterClass
    void afterClass(){
        System.out.println("afterClass");
    }
    @AfterTest
    void aftertest(){
        System.out.println("aftertest");
    }
}
