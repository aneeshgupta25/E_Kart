package com.example.acmegradefinalassessment.repository;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Toast;

import com.example.acmegradefinalassessment.data.db.itemdb.ItemCartDatabase;
import com.example.acmegradefinalassessment.data.db.itemdb.ItemCartDatabaseInterface;
import com.example.acmegradefinalassessment.data.db.userdb.UserDatabase;
import com.example.acmegradefinalassessment.data.db.userdb.UserDatabaseInterface;
import com.example.acmegradefinalassessment.data.model.lists.BooksShoppingList;
import com.example.acmegradefinalassessment.data.model.lists.ClothesShoppingList;
import com.example.acmegradefinalassessment.data.model.lists.ElectronicsShoppingList;
import com.example.acmegradefinalassessment.data.model.lists.FruitsShoppingList;
import com.example.acmegradefinalassessment.data.model.Item;
import com.example.acmegradefinalassessment.data.model.User;
import com.example.acmegradefinalassessment.presentation.activity.BillingSummaryActivity;
import com.example.acmegradefinalassessment.presentation.activity.MainActivity;
import com.example.acmegradefinalassessment.presentation.activity.OrderPlacedActivity;
import com.example.acmegradefinalassessment.presentation.activity.RegistrationActivity;

import java.util.List;

public class RepoImpl implements RepoInterface{

    Context context;
    BooksShoppingList booksShoppingList;
    ClothesShoppingList clothesShoppingList;
    ElectronicsShoppingList electronicsShoppingList;
    FruitsShoppingList fruitsShoppingList;
    ItemCartDatabaseInterface itemCartDatabaseInterface;
    UserDatabaseInterface userDatabaseInterface;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    public RepoImpl(Context context) {
        booksShoppingList = new BooksShoppingList();
        clothesShoppingList = new ClothesShoppingList();
        electronicsShoppingList = new ElectronicsShoppingList();
        fruitsShoppingList = new FruitsShoppingList();

        itemCartDatabaseInterface = new ItemCartDatabase(context);
        userDatabaseInterface = new UserDatabase(context);

        sharedPreferences = context.getSharedPreferences("PREF_CONSTANT", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    @Override
    public List<Item> getList(String category) {
        return itemCartDatabaseInterface.getData(category);
    }

    @Override
    public List<Item> getUserCart() {
        return itemCartDatabaseInterface.getUserCart();
    }

    @Override
    public boolean userExists(String email) {
        return userDatabaseInterface.checkEmailAlreadyExists(email);
    }

    @Override
    public void fillItemCartDatabase() {
        if(sharedPreferences.getBoolean("isLoggedIn", false)) {
            return;
        }
        itemCartDatabaseInterface.fillItemsTable(booksShoppingList.getBooksList(), "BOOKS");
        itemCartDatabaseInterface.fillItemsTable(clothesShoppingList.getClothesList(), "CLOTHES");
        itemCartDatabaseInterface.fillItemsTable(fruitsShoppingList.getFruitsList(), "FRUITS");
        itemCartDatabaseInterface.fillItemsTable(electronicsShoppingList.getElectronicsList(), "ELECTRONICS");
    }

    @Override
    public void registerUser(User user) {
        userDatabaseInterface.addUserToDB(user);
    }

    @Override
    public void updateUserCart(int id, boolean addToCart) {
        itemCartDatabaseInterface.updateUserCart(id, addToCart);
    }

    @Override
    public void saveLoginDetails(String email) {
        editor.putBoolean("isLoggedIn", true);
        editor.putString("userName", userDatabaseInterface.getUser(email));
        editor.putString("userEmail", email);
        editor.apply();
    }

    @Override
    public String getUserName() {
        return sharedPreferences.getString("userName", "");
    }

    @Override
    public String getUserEmail() {
        return sharedPreferences.getString("userEmail", "");
    }

    @Override
    public void placeOrder(Context intentContext) {
        Intent intent = new Intent(intentContext, BillingSummaryActivity.class);
        intentContext.startActivity(intent);
    }

    @Override
    public void checkout(Context context) {
        Intent intent = new Intent(context, OrderPlacedActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void clearUserCart() {
        List<Item> list = getUserCart();
        for(int i = 0; i < list.size(); i++) {
            Item item = list.get(i);
            updateUserCart(item.getId(), false);
        }
    }

    @Override
    public void gotToMainActivity(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);
    }

    @Override
    public void logOut(Context context) {
        AlertDialog dialog = new AlertDialog.Builder(context)
                .setTitle("ATTENTION")
                .setMessage("You really want to go..?\nWe will miss you :(")
                .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        clearSharedPreferences();
                        clearItemDB();
                        dialog.dismiss();
                        gotToRegistrationActivity(context);
                    }
                })
                .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .create();
        dialog.show();

    }

    private void gotToRegistrationActivity(Context context) {
        Intent intent = new Intent(context, RegistrationActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);
    }

    private void clearItemDB() {
        itemCartDatabaseInterface.clearDB();
    }

    private void clearSharedPreferences() {
        editor.putBoolean("isLoggedIn", false);
        editor.putString("userName", "");
        editor.putString("userEmail", "");
        editor.apply();
    }

}
