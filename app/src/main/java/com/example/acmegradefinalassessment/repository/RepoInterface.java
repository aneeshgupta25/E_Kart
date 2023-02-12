package com.example.acmegradefinalassessment.repository;

import com.example.acmegradefinalassessment.data.model.Item;
import com.example.acmegradefinalassessment.data.model.User;

import java.util.List;

public interface RepoInterface {

    public List<Item> getList(String category);
    public List<Item> getUserCart();
    public boolean userExists(String email);
    public void fillItemCartDatabase();
    public void registerUser(User user);
    public void updateUserCart(int id, boolean addToCart);

}
