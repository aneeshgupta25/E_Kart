package com.example.acmegradefinalassessment.repository;

import android.content.Context;
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
    void placeOrder(Context context);
    void checkout(Context context);
    void clearUserCart();
    void gotToMainActivity(Context context);
    void logOut(Context context);
}
