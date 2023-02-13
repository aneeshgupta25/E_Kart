package com.example.acmegradefinalassessment.repository;

import android.view.View;

import com.example.acmegradefinalassessment.data.model.Item;
import com.example.acmegradefinalassessment.data.model.User;

import java.util.List;

public interface RepoInterface {

    List<Item> getList(String category);
    List<Item> getUserCart();
    boolean userExists(String email);
    void fillItemCartDatabase();
    void registerUser(User user);
    void updateUserCart(int id, boolean addToCart);
    void saveLoginDetails(String email);
    String getUserName();
    String getUserEmail();

}
