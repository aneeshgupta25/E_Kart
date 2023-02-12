package com.example.acmegradefinalassessment.model;

import java.util.LinkedHashMap;
import java.util.List;

public class ShoppingList {
    LinkedHashMap<Filter, List<Item>> list;

    public ShoppingList() {
        list = new LinkedHashMap<>();
        list.put(new Filter("CLOTHES"), new ClothesShoppingList().getClothesList());
        list.put(new Filter("BOOKS"), new BooksShoppingList().getBooksList());
        list.put(new Filter("ELECTRONICS"), new ElectronicsShoppingList().getElectronicsList());
        list.put(new Filter("FRUITS"), new FruitsShoppingList().getFruitsList());
    }

    public LinkedHashMap<Filter, List<Item>> getShoppingList() {
        return list;
    }
}
