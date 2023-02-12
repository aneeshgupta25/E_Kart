package com.example.acmegradefinalassessment.repository;

import android.content.Context;
import android.content.SharedPreferences;
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

    public RepoImpl(Context context) {
        booksShoppingList = new BooksShoppingList();
        clothesShoppingList = new ClothesShoppingList();
        electronicsShoppingList = new ElectronicsShoppingList();
        fruitsShoppingList = new FruitsShoppingList();

        itemCartDatabaseInterface = new ItemCartDatabase(context);
        userDatabaseInterface = new UserDatabase(context);

        sharedPreferences = context.getSharedPreferences("PREF_CONSTANT", Context.MODE_PRIVATE);
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


}
