package ru.geekbrains.homework;

public class Dog extends Animal{
    public static int countDogs;

    public Dog(String name, int age, String color) {
        super(name, age, color);
    }

    @Override
    public void run(int distance) {
        if (distance <= 500) {
            System.out.println(name + " пробежал " + distance + " м.");
        } else {
            System.out.println(name + " столько не пробежит!");
        }
    }

    @Override
    public void swim(int distance) {
        if (distance <= 10) {
            System.out.println(name + " проплыл " + distance + " м.");
        } else {
            System.out.println(name + " столько не проплывет!");
        }
    }
}
