package ru.geekbrains.homework;

public abstract class Animal {
    protected static int countAnimals;
    protected String name;
    protected int age;
    protected String color;

    public Animal(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    public abstract void run(int distance);

    public abstract void swim (int distance);


}

