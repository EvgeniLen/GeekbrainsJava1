package ru.geekbrains.homework;

public class Main {
    public static void main(String[] args) {

        Employee[] arrEmployee = new Employee[5];
        arrEmployee[0] = new Employee("Ivan Ivanov", "worker", "ii@mail.ru", "+892833343", 40000, 50);
        arrEmployee[1] = new Employee("Ivan Fedorov", "worker", "if@mail.ru", "+892833344", 57000, 33);
        arrEmployee[2] = new Employee("Ivan Romov", "worker", "ir@mail.ru", "+892833345", 46000, 29);
        arrEmployee[3] = new Employee("Ivan Taranov", "worker", "it@mail.ru", "+892833346", 45000, 45);
        arrEmployee[4] = new Employee("Ivan Markov", "worker", "im@mail.ru", "+892833347", 22000, 21);

        for (int i = 0; i < arrEmployee.length; i++) {
            if (arrEmployee[i].getAge() > 40) {
                arrEmployee[i].printEmployee();
            }
        }
    }
}
