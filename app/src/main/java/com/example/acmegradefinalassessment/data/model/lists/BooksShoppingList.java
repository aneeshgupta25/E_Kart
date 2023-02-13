package com.example.acmegradefinalassessment.data.model.lists;

import com.example.acmegradefinalassessment.data.model.Item;

import java.util.ArrayList;
import java.util.List;

public class BooksShoppingList {
    private List<Item> list;

    public BooksShoppingList() {
        list = new ArrayList<>();
        list.add(new Item(1,"Harry Potter and the Goblet of Fire", "JK Rowling", 569, 20, 4.9,
                "https://media.harrypotterfanzone.com/goblet-of-fire-movie-stills.jpg"));
        list.add(new Item(2, "A Little Life", "Hanya Yanagihara", 499, 30, 4.7,
                "https://images.squarespace-cdn.com/content/v1/5a568dd1a9db09c7adf8c2d0/1554350554180-ZZA4JH8JIQQHNWUDIRF4/ALL_edit+%28final%29.jpg"));
        list.add(new Item(3, "One Hundred Years of Solitude", "Gabriel Garcia Marquez", 499, 25,4.7,
                "https://payload.cargocollective.com/1/16/518726/14199469/onehundredyearsofsolitude-marquez_900.jpg"));
        list.add(new Item(4, "Chronicles: Volume One", "Bob Dylan", 479, 45,4.6,
                "https://i0.wp.com/alwaysbooks.co.uk/wp-content/uploads/2020/01/IMG_20200106_114143-e1578433472995.jpg?fit=1200%2C1100&ssl=1"));
        list.add(new Item(5, "The Great Gatsby", "Bob Dylan", 479, 45,4.6,
                "https://static01.nyt.com/images/2021/01/15/books/15GREATGATSBY-COMBO/00GREATGATSBY-COMBO-superJumbo.jpg"));
        list.add(new Item(6, "The Siege", "Helen Dunmore", 432, 30, 4.8,
                "https://kbimages1-a.akamaihd.net/acd47a0e-12d3-4311-9889-a0e611c7125e/1200/1200/False/heralds-of-the-siege.jpg"));
        list.add(new Item(7, "Visitation", "Jenny Erpenbeck", 467, 36, 4.5,
                "https://m.media-amazon.com/images/I/81ZrVI8jMaL.jpg"));
    }

    public List<Item> getBooksList() {
        List<Item> booksList = new ArrayList<>(list);
        return booksList;
    }
}
