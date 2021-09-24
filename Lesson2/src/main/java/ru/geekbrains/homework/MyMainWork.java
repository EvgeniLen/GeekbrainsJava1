package ru.geekbrains.homework;

public class MyMainWork {

    public static void main(String[] args) {
        System.out.println(sum(10, 11));
        printPosOrNeg(-10);
        System.out.println(getIsNegative(0));
        printString("Hello", 5);
        System.out.println(getItIsLeapYear(2096));
    }

    public static boolean sum(int a, int b) {
        return a + b >= 10 && a + b <= 20;
    }

    public static void printPosOrNeg(int a) {
        if (a >= 0) {
            System.out.println("Число положительное");
        } else {
            System.out.println("Число отрицательное");
        }

    }

    public static boolean getIsNegative(int a) {
        return a < 0;
    }

    public static void printString(String str, int count) {
        for (int i = 0; i < count; ++i) {
            System.out.println(str);
        }

    }

    public static boolean getItIsLeapYear(int year) {
        if (year <= 0) {
            return false;
        } else {
            return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
        }
    }
}
