package com.example.acmegradefinalassessment.data.db.userdb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.acmegradefinalassessment.data.model.User;

public class UserDatabase extends SQLiteOpenHelper implements UserDatabaseInterface{

    //database version
    private static final int DATABASE_VERSION = 1;
    //database name
    private static final String DATABASE_NAME = "UserInfo.db";
    //table name
    private static final String TABLE_USER_INFO = "users";
    //table columns names
    private static final String COLUMN_USER_ID = "user_id";
    private static final String COLUMN_USER_NAME = "user_name";
    private static final String COLUMN_USER_EMAIL = "user_email";
    private static final String COLUMN_USER_PASSWORD = "user_password";

    //sql query to create the users table
    private String CREATE_TABLE_QUERY = "CREATE TABLE " + TABLE_USER_INFO + "("
            + COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_USER_NAME + " TEXT,"
            + COLUMN_USER_EMAIL + " TEXT,"
            + COLUMN_USER_PASSWORD + " TEXT" +  ")";
    private String DROP_TABLE_QUERY = "DROP TABLE IF EXISTS " + TABLE_USER_INFO;

    public UserDatabase(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.d("Aneesh", CREATE_TABLE_QUERY);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE_QUERY);
        db.execSQL(CREATE_TABLE_QUERY);
    }

    @Override
    public boolean checkEmailAlreadyExists(String email) {
        //Create database instance
        SQLiteDatabase db = this.getReadableDatabase();

        //SELECT user_id FROM users WHERE user_email = 'abc@gmail.com';
        //The below mentioned columns will be returned
        String[] columns = {COLUMN_USER_ID};
        //Below is the param for Where clause
        String condition = COLUMN_USER_EMAIL + " = ?";
        //Below is the value for the corresponding param of Where clause
        String[] conditionValue = {email};

        //Create Cursor object to get response of query
        Cursor cursor = db.query(
                TABLE_USER_INFO,
                columns,
                condition,
                conditionValue,
                null,
                null,
                null
        );
        int recordCount = cursor.getCount();
        cursor.close();
        db.close();
        return recordCount > 0;
    }
    @Override
    public void addUserToDB(User user) {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues value = new ContentValues();
        value.put(COLUMN_USER_NAME, user.getName());
        value.put(COLUMN_USER_EMAIL, user.getEmail());
        value.put(COLUMN_USER_PASSWORD, user.getPassword());
        db.insert(TABLE_USER_INFO, null, value);
        db.close();
    }
}