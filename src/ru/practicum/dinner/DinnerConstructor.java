package ru.practicum.dinner;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {
    HashMap<String, ArrayList<String>> dishes = new HashMap<>();
    ArrayList<String> dishesArray;
    Random random = new Random();

    void addDish(String dishType, String dishName) {
        if (dishes.containsKey(dishType)) {
            dishes.get(dishType).add(dishName);
        } else {
            dishesArray = new ArrayList<>();
            dishesArray.add(dishName);
            dishes.put(dishType, dishesArray);
        }
    }

    ArrayList<String> generateNewDishes(ArrayList<String> dishesTypes) {
        ArrayList<String> generatedDishes = new ArrayList<>();
        for (String dishType: dishesTypes) {
            dishesArray = dishes.get(dishType);
            generatedDishes.add(dishesArray.get(random.nextInt(dishesArray.size())));
        }
        return generatedDishes;
    }

    boolean checkDishType(String dishType) {
        return dishes.containsKey(dishType);
    }
}
