package com.example.acmegradefinalassessment.data.db.itemdb;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.acmegradefinalassessment.data.model.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemCartDatabase extends SQLiteOpenHelper implements ItemCartDatabaseInterface {

    SharedPreferences sharedPreferences;
    //database version
    private static final int DATABASE_VERSION = 1;
    //database name
    private static final String DATABASE_NAME = "ItemCartInfo.db";
    //table name
    private static final String TABLE_ITEM_CART = "cart";
    //table columns names
    private static final String COLUMN_ITEM_ID = "item_id";
    private static final String COLUMN_ITEM_CATEGORY = "item_category";
    private static final String COLUMN_ITEM_TITLE = "item_title";
    private static final String COLUMN_ITEM_DESC = "item_desc";
    private static final String COLUMN_ITEM_PRICE = "item_price";
    private static final String COLUMN_ITEM_DELIVERY = "item_delivery";
    private static final String COLUMN_ITEM_RATING = "item_rating";
    private static final String COLUMN_ITEM_ADDED_TO_CART = "item_added";

    //sql query to create the users table
    private String CREATE_TABLE_QUERY = "CREATE TABLE " + TABLE_ITEM_CART + "("
            + COLUMN_ITEM_ID + " INTEGER,"
            + COLUMN_ITEM_CATEGORY + " TEXT,"
            + COLUMN_ITEM_TITLE + " TEXT,"
            + COLUMN_ITEM_DESC + " TEXT,"
            + COLUMN_ITEM_PRICE + " INTEGER,"
            + COLUMN_ITEM_DELIVERY + " INTEGER,"
            + COLUMN_ITEM_RATING + " REAL,"
            + COLUMN_ITEM_ADDED_TO_CART + " TEXT" +  ")";

    private String DROP_TABLE_QUERY = "DROP TABLE IF EXISTS " + TABLE_ITEM_CART;

    public ItemCartDatabase(@Nullable Context context) {
        super(context, DATABASE_NAME, null,DATABASE_VERSION);
        sharedPreferences = context.getSharedPreferences("PREF_CONSTANT", Context.MODE_PRIVATE);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DROP_TABLE_QUERY);
        db.execSQL(CREATE_TABLE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE_QUERY);
        db.execSQL(CREATE_TABLE_QUERY);
    }

    @Override
    public List<Item> getData(String category) {
        Log.d("ANEESH GUPTA", "Hello!");
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM "+ TABLE_ITEM_CART  + " WHERE " + COLUMN_ITEM_CATEGORY + " = ?";
        Cursor cursor = db.rawQuery(query, new String[]{category});
        List<Item> list = new ArrayList<>();

        if(cursor.moveToFirst()) {
            do {
                Item item = new Item(cursor.getInt(0),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getInt(4),
                        cursor.getInt(5),
                        cursor.getDouble(6));
                item.setAddedToCart(cursor.getString(7).equals("1"));
                Log.d("HEYO!", cursor.getString(0) + " " + cursor.getString(7));
                list.add(item);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return list;
    }

    @Override
    public void fillItemsTable(List<Item> list, String category) {
        SQLiteDatabase db = this.getReadableDatabase();
        for(int i = 0; i < list.size(); i++) {
            ContentValues values = new ContentValues();
            Item item = list.get(i);
            values.put(COLUMN_ITEM_ID, item.getId());
            values.put(COLUMN_ITEM_CATEGORY, category);
            values.put(COLUMN_ITEM_TITLE, item.getName());
            values.put(COLUMN_ITEM_DESC, item.getDesc());
            values.put(COLUMN_ITEM_PRICE, item.getPrice());
            values.put(COLUMN_ITEM_DELIVERY, item.getDelivery());
            values.put(COLUMN_ITEM_RATING, item.getRating());
            values.put(COLUMN_ITEM_ADDED_TO_CART, item.isAddedToCart());
            db.insert(TABLE_ITEM_CART, null, values);
        }
        db.close();
    }

    @Override
    public void updateUserCart(int id, boolean addToCart) {
        Log.d("UPDATE", id + " -> " + addToCart + "DB");
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "UPDATE " + TABLE_ITEM_CART + " SET " + COLUMN_ITEM_ADDED_TO_CART + " = " + addToCart+"" + " WHERE "
                + COLUMN_ITEM_ID + " = " + id+"";
        db.execSQL(query);
        db.close();
    }

    @Override
    public List<Item> getUserCart() {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM "+ TABLE_ITEM_CART  + " WHERE " + COLUMN_ITEM_ADDED_TO_CART + " = ?";
        Cursor cursor = db.rawQuery(query, new String[]{"1"});
        List<Item> list = new ArrayList<>();

        if(cursor.moveToFirst()) {
            do {
                Item item = new Item(cursor.getInt(0),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getInt(4),
                        cursor.getInt(5),
                        cursor.getDouble(6));
                item.setAddedToCart(cursor.getString(7).equals("1"));
                list.add(item);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return list;
    }
}
