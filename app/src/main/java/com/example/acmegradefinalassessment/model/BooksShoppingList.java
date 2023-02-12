package com.example.acmegradefinalassessment.model;

import java.util.ArrayList;
import java.util.List;

public class BooksShoppingList {
    private List<Item> list;

    public BooksShoppingList() {
        list = new ArrayList<>();
        list.add(new Item(1,"Harry Potter and the Goblet of Fire", "JK Rowling", 569, 20, 4.9));
        list.add(new Item(2, "A Little Life", "Hanya Yanagihara", 499, 30, 4.7));
        list.add(new Item(3, "A Little Life", "Hanya Yanagihara", 499, 25,4.7));
        list.add(new Item(4, "Chronicles: Volume One", "Bob Dylan", 479, 45,4.6));
        list.add(new Item(5, "Chronicles: Volume One", "Bob Dylan", 479, 45,4.6));
        list.add(new Item(6, "The Siege", "Helen Dunmore", 432, 30, 4.8));
        list.add(new Item(7, "Visitation", "Jenny Erpenbeck", 467, 36, 4.5));
    }

    public List<Item> getBooksList() {
        List<Item> booksList = new ArrayList<>(list);
        return booksList;
    }
}
