package com.example.acmegradefinalassessment.data.db.itemdb;

import com.example.acmegradefinalassessment.data.model.Item;

import java.util.List;

public interface ItemCartDatabaseInterface {
    public List<Item> getData(String category);
    public void fillItemsTable(List<Item> list, String category);
    public void updateUserCart(int id, boolean addToCart);
    public List<Item> getUserCart();
}
