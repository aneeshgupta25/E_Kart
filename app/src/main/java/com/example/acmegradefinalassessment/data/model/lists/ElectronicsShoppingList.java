package com.example.acmegradefinalassessment.data.model.lists;

import com.example.acmegradefinalassessment.data.model.Item;

import java.util.ArrayList;
import java.util.List;

public class ElectronicsShoppingList {
    private List<Item> list;

    public ElectronicsShoppingList() {
        list = new ArrayList<>();
        list.add(new Item(21, "Refrigerator", "Keep you fruits and vegetables healthy and fresh", 20000, 500, 4.6,
                "https://www.cnet.com/a/img/resize/48065dee15cef0753aa1fa72bea191d4aadf1702/hub/2017/05/25/034db8df-8871-402c-a04f-6be2272117bc/samsung-rf28k9380sg-refrigerator-product-photos-12.jpg?auto=webp&width=1200"));
        list.add(new Item(22, "Television", "Enjoy watching some movies, and play some games!", 25000, 300, 4.5,
                "https://cdn.webshopapp.com/shops/256009/files/374440369/xiaomi-xiaomi-mi-tv-p1-32-inch.jpg"));
        list.add(new Item(23, "Air Conditioner", "Keep your room cool with fresh and healthy air", 35000, 499, 4.9,
                "https://os-wordpress-media.s3.ap-south-1.amazonaws.com/blog/wp-content/uploads/2020/11/24212247/Air-Conditioner-Buying-Guide.jpg"));
        list.add(new Item(24, "Washing Machine", "Just put your untidy clothes and let it handle :)", 31000, 400, 4.6,
                "https://static.toiimg.com/thumb/resizemode-4,msid-77792902,imgsize-200,width-1200,imgv-1/77792902.jpg"));
        list.add(new Item(25, "Microwave", "Keep your food warm and healthy", 5000, 100, 4.2,
                "https://www.lg.com/in/images/microwave-ovens/md07536273/gallery/MC2886BHT-Microwave-ovens-Right-Low-Perspective-view-D-12.jpg"));
        list.add(new Item(26, "Vacuum Cleaner", "Maintain your floors and carpets", 2500, 200, 4.0,
                "https://www.eurekaforbes.com/media/catalog/product/cache/5dacb12e56b80562394993655c6849d4/f/o/forbes-trendy-zip-vacuum-cleaner-left1.png"));
    }

    public List<Item> getElectronicsList() {
        List<Item> electronicsList = new ArrayList<>(list);
        return electronicsList;
    }
}
