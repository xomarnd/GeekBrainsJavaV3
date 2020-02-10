package Lesson_7;

import Lesson_7.Annotations.TestsHandler;

public class Main {
    public static void main(String[] args) {
        //Task1
        CaseTesting classForTesting = new CaseTesting();
        TestsHandler.start(classForTesting.getClass());

        //Task2
        System.out.println();
        ClassExplorer.outClassInfo(String.class);
    }
}
