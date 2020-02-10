package Lesson_7;

import Lesson_7.Annotations.Test;
import Lesson_7.Annotations.AfterSuite;
import Lesson_7.Annotations.BeforeSuite;

public class CaseTesting {

    @Test()
    public void testMethodTwo(){
        System.out.println("1 priority method");
    }

    @Test(priority = 5)
    public void testMethodOne() {
        System.out.println("5 priority method");
    }

    @Test(priority = 7)
    private void testMethodFour(){
        System.out.println("7 priority method");
    }

    @Test(priority = 10)
    public void testMethodTree(){
        System.out.println("10  priority method");
    }

    @Test()
    public void testMethodFive(){
        System.out.println("Default priority method");
    }

    @AfterSuite
    public void methodAfter(){
        System.out.println("AfterSuite method");
    }

    @BeforeSuite
    public void methodBefore(){
        System.out.println("BeforeSuite method");
    }
}
