package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.Scanner;

public class Main { // main class

    static DinnerConstructor dc;
    static Scanner scanner;

    public static void main(String[] args) {
        dc = new DinnerConstructor();
        scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            String command = scanner.nextLine();

            switch (command) {
                case "1":
                    addNewDish();
                    break;
                case "2":
                    generateDishCombo();
                    break;
                case "3":
                    return;
            }
        }
    }
    // Вывод меню
    private static void printMenu() {
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Выход");
    }
    // Добавление блюда в хэш мап
    private static void addNewDish() {
        System.out.println("Введите тип блюда:");
        String dishType = scanner.nextLine();
        System.out.println("Введите название блюда:");
        String dishName = scanner.nextLine();

        dc.addDish(dishType, dishName);
    }

    // Генерация комбо блюд
    private static void generateDishCombo() {
        ArrayList<String> dishesTypes = new ArrayList<>();
        System.out.println("Начинаем конструировать обед...");

        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        int numberOfCombos = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). Для завершения ввода введите пустую строку");
        String nextItem = scanner.nextLine();

        while (!nextItem.isEmpty()) {
            if (dc.checkDishType(nextItem)) {
                dishesTypes.add(nextItem);
            } else {
                System.out.println("Такого блюда нет. Попробуйте другое.");
            }
            nextItem = scanner.nextLine();
        }

        for (int i = 0; i < numberOfCombos; i++) {
            ArrayList<String> generatedDishes = dc.generateNewDishes(dishesTypes);
            if (generatedDishes != null) {
                System.out.println("Комбо " + (i + 1) + "\n" + generatedDishes);
            }
        }
    }
}
