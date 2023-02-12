package com.example.acmegradefinalassessment.model;

import java.util.ArrayList;
import java.util.List;

public class ClothesShoppingList {

    private List<Item> list;
    public ClothesShoppingList() {
        list = new ArrayList<>();
        list.add(new Item("Rocko T-shirt", "Urban Modern Pretty Sensational Men T-shirt", 141, 20, 3.8));
        list.add(new Item("Baggy SweatAbsorber", "Fancy Fashionable and Stylish", 251, 16, 3.4));
        list.add(new Item("Celli Jeans", "Designer Fabulous Men Jeans", 198, 30, 4.6));
        list.add(new Item("Manly Cruise", "Trendy and Cozy", 298, 18, 4.3));
        list.add(new Item("Girly and Classy", "Stylish Feminista", 278, 20, 4.7));
        list.add(new Item("Adrika Kurti", "Sensatinal Women Kurtis", 345, 27, 3.9));
        list.add(new Item("Banita Superior Kurtis", "Stylish Modern Women Kurtis", 278, 19, 4.8));
    }

    public List<Item> getClothesList() {
        List<Item> clothesList = new ArrayList<>(list);
        return clothesList;
    }

}
