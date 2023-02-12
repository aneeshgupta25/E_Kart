package com.example.acmegradefinalassessment.data.model.lists;

import com.example.acmegradefinalassessment.data.model.Item;

import java.util.ArrayList;
import java.util.List;

public class ClothesShoppingList {

    private List<Item> list;
    public ClothesShoppingList() {
        list = new ArrayList<>();
        list.add(new Item(11, "Rocko T-shirt", "Urban Modern Pretty Sensational Men T-shirt", 141, 20, 3.8));
        list.add(new Item(12, "Baggy SweatAbsorber", "Fancy Fashionable and Stylish", 251, 16, 3.4));
        list.add(new Item(13, "Celli Jeans", "Designer Fabulous Men Jeans", 198, 30, 4.6));
        list.add(new Item(14, "Manly Cruise", "Trendy and Cozy", 298, 18, 4.3));
        list.add(new Item(15, "Girly and Classy", "Stylish Feminista", 278, 20, 4.7));
        list.add(new Item(16, "Adrika Kurti", "Sensatinal Women Kurtis", 345, 27, 3.9));
        list.add(new Item(17, "Banita Superior Kurtis", "Stylish Modern Women Kurtis", 278, 19, 4.8));
    }

    public List<Item> getClothesList() {
        List<Item> clothesList = new ArrayList<>(list);
        return clothesList;
    }

}
