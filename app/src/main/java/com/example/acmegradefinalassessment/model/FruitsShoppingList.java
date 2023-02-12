package com.example.acmegradefinalassessment.model;

import java.util.ArrayList;
import java.util.List;

public class FruitsShoppingList {
    private List<Item> list;

    public FruitsShoppingList() {
        list = new ArrayList<>();
        list.add(new Item("Apples", "Crisp and Juicy", 100, 10, 4.6));
        list.add(new Item("Bananas", "Sweat and Creamy", 50, 12, 4.5));
        list.add(new Item("Oranges", "Juicy anf Tangy", 60, 15, 4.7));
        list.add(new Item("Strawberries", "Sweat and Juicy", 250, 30, 4.3));
        list.add(new Item("Grapes", "Sweat and Juice", 90, 13, 4.2));
        list.add(new Item("Mangoes", "Rich in Vitamin A", 120, 16, 4.9));
    }

    public List<Item> getFruitsList() {
        List<Item> fruitsList = new ArrayList<>(list);
        return fruitsList;
    }
}
