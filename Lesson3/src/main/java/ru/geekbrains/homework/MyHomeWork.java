package ru.geekbrains.homework;

import java.util.Arrays;

public class MyHomeWork {
    public static void main(String[] args) {
        //task 1
        int[] arr = {0, 1, 1, 0, 1, 0, 0, 1, 1, 0, 0, 0};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
            } else if (arr[i] == 1) {
                arr[i] = 0;
            }
        }
        System.out.println(Arrays.toString(arr));

        //task 2
        int[] arr1 = new int[100];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = i + 1;
        }
        System.out.println(Arrays.toString(arr1));

        //task 3
        int[] arr2 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr2.length; i++) {
            if (arr2[i] < 6) {
                arr2[i] *= 2;
            }
        }
        System.out.println(Arrays.toString(arr2));

        //task 4
        int[][] matrix = new int[5][5];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i == j || i + j == matrix[i].length-1) {
                    matrix[i][j] = 1;
                }
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        //task 5
        System.out.println(Arrays.toString(getArray(10, 55)));

        //task 6*
        int[] arr3 = {1, 10, 15, 17, 18, 20, 3, 5, 8, 4, 1, 40, 25, -100};
        int max = arr3[0];
        int min = arr3[0];
        for (int i = 1; i < arr3.length; i++) {
            int curVal = arr3[i];
            if (max < curVal) {
                max = curVal;
            }
            if (min > curVal) {
                min = curVal;
            }
        }
        System.out.println("Максимальное значение " + max + "; Минимальное значение " + min + ";");

        //task 7**
        int[] arr4 = {10, 10, 10 , 20, 9, 1};
        System.out.println("CheckBalance = " + checkBalance(arr4));


        //task 8***
        int[] arr5 = {1, 2, 3, 4, -55};
        moveElement(arr5, -2);
        System.out.println(Arrays.toString(arr5));
    }

    public static int[] getArray(int len, int initialValue) {
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = initialValue;
        }
        return arr;
    }

    public static boolean checkBalance(int[] array){
        int sumLeft = 0;
        int sumRight = 0;
        for (int i = 0; i < array.length-1; i++) {
            sumLeft += array[i];
            for (int j = array.length - 1; j > i; j--) {
                sumRight += array[j];
            }
            if (sumLeft == sumRight) {
                return true;
            } else {
                sumRight = 0;
            }
        }
        return false;

    }

    public static void moveElement(int[] array, int n){
        if (n > 0){
            for (int i = 0; i < n; i++) {
                int val;
                int prevVal = 0;
                for (int j = 0; j < array.length; j++) {
                    if (j == 0){
                        prevVal = array[j];
                        array[j] = array[array.length - 1];
                    } else {
                        val = array[j];
                        array[j] = prevVal;
                        prevVal = val;
                    }
                }
            }
        } else {
            for (int i = n; i < 0; i++) {
                int val;
                int prevVal = 0;
                for (int j = array.length-1; j >= 0; j--) {
                    if (j == array.length-1){
                        prevVal = array[j];
                        array[j] = array[0];
                    } else {
                        val = array[j];
                        array[j] = prevVal;
                        prevVal = val;
                    }
                }
            }
        }

    }


}
