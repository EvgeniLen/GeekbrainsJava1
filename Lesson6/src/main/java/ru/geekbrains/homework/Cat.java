package ru.geekbrains.homework;

public class Cat extends Animal{
    public static int countCats;

    public Cat(String name, int age, String color) {
        super(name, age, color);
    }

    @Override
    public void run(int distance) {
        if (distance <= 200) {
            System.out.println(name + " пробежал " + distance + " м.");
        } else {
            System.out.println(name + " столько не пробежит!");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println("Кот не умеет плавать!");
    }
}
