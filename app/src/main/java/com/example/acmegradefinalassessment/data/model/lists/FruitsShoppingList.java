package com.example.acmegradefinalassessment.data.model.lists;

import com.example.acmegradefinalassessment.data.model.Item;

import java.util.ArrayList;
import java.util.List;

public class FruitsShoppingList {
    private List<Item> list;

    public FruitsShoppingList() {
        list = new ArrayList<>();
        list.add(new Item(31, "Apples", "Crisp and Juicy", 100, 10, 4.6,
                "https://parade.com/.image/t_share/MTkwNTgxNDY1MzcxMTkxMTY0/different-types-of-apples-jpg.jpg"));
        list.add(new Item(32, "Bananas", "Sweat and Creamy", 50, 12, 4.5,
                "https://images.everydayhealth.com/images/diet-nutrition/all-about-bananas-nutrition-facts-health-benefits-recipes-and-more-rm-722x406.jpg"));
        list.add(new Item(33, "Oranges", "Juicy anf Tangy", 60, 15, 4.7,
                "https://cdn.britannica.com/24/174524-050-A851D3F2/Oranges.jpg"));
        list.add(new Item(34, "Strawberries", "Sweat and Juicy", 250, 30, 4.3,
                "https://ichef.bbci.co.uk/images/ic/1200xn/p0c9xp4y.jpg"));
        list.add(new Item(35, "Grapes", "Sweat and Juice", 90, 13, 4.2,
                "https://www.thespruceeats.com/thmb/l1_lV7wgpqRArWBwpG3jzHih_e8=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/what-are-grapes-5193263-hero-01-80564d77b6534aa8bfc34f378556e513.jpg"));
        list.add(new Item(36, "Mangoes", "Rich in Vitamin A", 120, 16, 4.9,
                "https://gigi-gelato.com/wp-content/uploads/2020/05/mango-is-gezond.jpg"));
    }

    public List<Item> getFruitsList() {
        List<Item> fruitsList = new ArrayList<>(list);
        return fruitsList;
    }
}
