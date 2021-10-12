package ru.geekbrains.homework;

public class Cat {
    private String name;
    private int appetite;
    private boolean wellFed;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.wellFed = false;
    }

    public void eat(Plate p){
        if (!wellFed) {
            if (p.getFood() > 0 && p.getFood() - appetite >= 0){
                p.decreaseFood(appetite);
                wellFed = true;
                System.out.println(name + " - поел из тарелки.");
            } else {
                System.out.println("В миске недостаточно еды для " + name);
            }
        }

    }

    public void info(){
        if (wellFed){
            System.out.println(name + " - сыт!");
        } else {
            System.out.println(name + " - голоден!");
        }

    }

}
