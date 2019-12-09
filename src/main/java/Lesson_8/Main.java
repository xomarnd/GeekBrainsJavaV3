package Lesson_8;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите ширину двумерного массива:");
        int arraySize_X = sc.nextInt();
        System.out.println("Введите высоту двумерного массива:");
        int arraySize_Y = sc.nextInt();
        arrayPrint (arraySize_X, arraySize_Y);

    }
    private static void arrayPrint(int arraySize_X, int arraySize_Y){
        int[][] array = arrayFilling(arraySize_X, arraySize_Y);
        String longNumber = "%0" + getCountsOfDigits(arraySize_X, arraySize_Y)+ "d\t";

        for (int[] ints : array) {
            for (int j = 0; j < ints.length; j++) {
                System.out.format (longNumber, ints[j]);
            }
            System.out.println ();
        }
    }

    private static int[][] arrayFilling(int arraySize_X, int arraySize_Y){
        int i = 0, j = 0, z = 1;
        int[][] array = createArray(arraySize_X, arraySize_Y);

        while (z <= arraySize_X * arraySize_Y){
            //right
            while (j < arraySize_Y && array[i][j] == 0){
                array[i][j] = z;
                z++; j++;
            }
            --j; ++i;
            //down
            while (i < arraySize_X && array[i][j] == 0){
                array[i][j] = z;
                z++; i++;
            }
            --i; --j;
            //left
            while (j >= 0 && array[i][j] == 0){
                array[i][j] = z;
                z++; j--;
            }
            i--; j++;
            //up
            while (i >= 0 && array[i][j] == 0){
                array[i][j] = z;
                z++; i--;
            }
            j++; i++;
        }
        return array;
    }

    private static int[][] createArray(int arraySize_X, int arraySize_Y){
        int[][] arr = new int[arraySize_X][arraySize_Y];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = 0;
            }
        }
        return arr;
    }
    private static int getCountsOfDigits(int arraySize_X, int arraySize_Y) {
        long number = arraySize_X * arraySize_Y;
        int count = (number == 0) ? 1 : 0;
        while (number != 0) {
            count++;
            number /= 10;
        }
        return count;
    }
}
