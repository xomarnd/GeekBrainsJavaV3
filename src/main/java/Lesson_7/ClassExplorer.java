package Lesson_7;

import java.lang.reflect.Method;
import java.lang.reflect.Field;
import java.lang.reflect.Constructor;

public class ClassExplorer {
    public static void outClassInfo(Class aClass) {
        System.out.println("Class: " + aClass.getName());
        outClassParents(aClass);
        outClassConstructors(aClass);
        outClassFields(aClass);
        outClassMethods(aClass);
    }

    private static void outClassMethods(Class aClass) {
        System.out.println("\n>>>>>>>>>>>>>>>>>>>>>>>> Methods \n");
        Method[] methods = aClass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
    }

    private static void outClassFields(Class aClass) {
        System.out.println("\n>>>>>>>>>>>>>>>>>>>>>>>> Fields \n");
        Field[] fields = aClass.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field);
        }
    }

    private static void outClassConstructors(Class aClass) {
        System.out.println("\n>>>>>>>>>>>>>>>>>>>>>>>> Constructors \n");
        Constructor[] constructors = aClass.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            System.out.print(constructor);
            System.out.println();
        }
    }

    private static void outClassParents(Class aClass) {
        Class parent = aClass.getSuperclass();
        if (parent != null) {
            System.out.println("Subclass: " + parent.getSimpleName());
            outClassParents(parent);
        }
    }
}