package com.example.acmegradefinalassessment.data.model.lists;

import com.example.acmegradefinalassessment.data.model.Item;

import java.util.ArrayList;
import java.util.List;

public class ClothesShoppingList {

    private List<Item> list;
    public ClothesShoppingList() {
        list = new ArrayList<>();
        list.add(new Item(11, "Rocko T-shirt", "Urban Modern Pretty Sensational Men T-shirt", 141, 20, 3.8,
                "https://m.media-amazon.com/images/I/71vp8Lec9JL._UX679_.jpg"));
        list.add(new Item(12, "Baggy SweatAbsorber", "Fancy Fashionable and Stylish", 251, 16, 3.4,
                "https://i.pinimg.com/originals/7e/b6/6c/7eb66ca9fdfb1e9a6e615332c02d8292.jpg"));
        list.add(new Item(13, "Celli Jeans", "Designer Fabulous Men Jeans", 198, 30, 4.6,
                "https://a.allegroimg.com/original/117c63/7b3aa6fc4c85b403e1e74a3ca5d1/Spodnie-meskie-JEANS-OCIEPLANE-CELLI-r-39"));
        list.add(new Item(14, "Manly Cruise", "Trendy and Cozy", 298, 18, 4.3,
                "https://img2.exportersindia.com/product_images/bc,-full/dir_136/4052884/premium-mens-shirts-2378877.jpeg"));
        list.add(new Item(15, "Girly and Classy", "Stylish Feminista", 278, 20, 4.7,
                "https://m.media-amazon.com/images/I/91ckULd19sL._UL1500_.jpg"));
        list.add(new Item(16, "Adrika Kurti", "Sensatinal Women Kurtis", 345, 27, 3.9,
                "https://wholesalefashionstore.in/wp-content/uploads/2022/01/1.jpg"));
        list.add(new Item(17, "Banita Superior Kurtis", "Stylish Modern Women Kurtis", 278, 19, 4.8,
                "https://g3fashion.com/blog/wp-content/uploads/2019/04/kurtis-1-1024x634.jpg"));
    }

    public List<Item> getClothesList() {
        List<Item> clothesList = new ArrayList<>(list);
        return clothesList;
    }

}
