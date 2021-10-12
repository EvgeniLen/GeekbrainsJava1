package ru.geekbrains.homework;

public class MyMain {
    public static void main(String[] args) {
        Plate plate = new Plate(0);
        plate.info();
        Cat[] cats = {
                new Cat("Barsik", 10),
                new Cat("Myrzik", 15),
                new Cat("Vasia", 5),
        };

        for (Cat cat:cats){
            cat.eat(plate);
            cat.info();
        }

        plate.setFood(50);

        for (Cat cat:cats){
            cat.eat(plate);
            cat.info();
        }

    }
}
