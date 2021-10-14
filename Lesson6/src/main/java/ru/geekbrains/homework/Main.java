package ru.geekbrains.homework;

public class Main {
    public static void main(String[] args) {
        Animal[] animals = {new Cat("Барсик", 3, "black"),
                new Cat("Мурзик", 10, "white"),
                new Dog("Бобик", 4, "brown"),

            };

        for(Animal animal:animals){
            if (animal instanceof Cat) {
                Cat.countCats++;
            } else if (animal instanceof Dog) {
                Dog.countDogs++;
            }
            animal.run(20);
            animal.swim(0);
            Animal.countAnimals++;
        }

        System.out.println("Создано котов - " + Cat.countCats + ", собак - " + Dog.countDogs + ", в целом животных - " + Animal.countAnimals + ".");
    }
}
