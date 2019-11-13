package Lesson_1;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // task 01
        Integer[] intArr = new Integer[2];

        intArr[0] = 1;
        intArr[1] = 2;

        System.out.println(Arrays.deepToString(intArr));
        swapTwoElementsInArray(intArr, 0, 1);
        System.out.println(Arrays.deepToString(intArr));

        // task 02
        ArrayList<Integer> arrList = toArrayList(intArr);

        // task 03
        Box<Apple> box1 = new Box<>(new Apple(), new Apple(), new Apple());
        Box<Orange> box2 = new Box<>(new Orange(), new Orange());

        System.out.println(box1.compare(box2));

        Box<Orange> box3 = new Box<>();
        box2.transfer(box3);
    }


    private static void swapTwoElementsInArray(Object[] arr, int indexA, int indexB) {
        if (indexA < 0 || indexA > arr.length || indexB < 0 || indexB > arr.length || indexA == indexB) {
            System.out.println("Неверно указаны позиции элементов для замены");
        } else {
            Object tmp = arr[indexA];
            arr[indexA] = arr[indexB];
            arr[indexB] = tmp;
        }
    }


    private static <T> ArrayList<T> toArrayList(T[] arr) {
        return new ArrayList<T> (Arrays.asList(arr));
    }
}
