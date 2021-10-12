package ru.geekbrains.homework;

public class Plate {
    private int food;

    public Plate(int food) {
        if (food >= 0){
            this.food = food;
        } else {
            System.out.println("Количество еды в миске не может быть отрицательным");
        }
    }

    public void decreaseFood(int n){
        food -= n;
    }

    public void info(){
        System.out.println("Plate: " + food);
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        if (food > 0) {
            this.food += food;
            System.out.print("В миску добавили еды. ");
            info();
        }
    }
}
