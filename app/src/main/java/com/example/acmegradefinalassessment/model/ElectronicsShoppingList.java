package com.example.acmegradefinalassessment.model;

import java.util.ArrayList;
import java.util.List;

public class ElectronicsShoppingList {
    private List<Item> list;

    public ElectronicsShoppingList() {
        list = new ArrayList<>();
        list.add(new Item(21, "Refrigerator", "Keep you fruits and vegetables healthy and fresh", 20000, 500, 4.6));
        list.add(new Item(22, "Television", "Enjoy watching some movies, and play some games!", 25000, 300, 4.5));
        list.add(new Item(23, "Air Conditioner", "Keep your room cool with fresh and healthy air", 35000, 499, 4.9));
        list.add(new Item(24, "Washing Machine", "Just put your untidy clothes and let it handle :)", 31000, 400, 4.6));
        list.add(new Item(25, "Microwave", "Keep your food warm and healthy", 5000, 100, 4.2));
        list.add(new Item(26, "Vacuum Cleaner", "Maintain your floors and carpets", 2500, 200, 4.0));
    }

    public List<Item> getElectronicsList() {
        List<Item> electronicsList = new ArrayList<>(list);
        return electronicsList;
    }
}
