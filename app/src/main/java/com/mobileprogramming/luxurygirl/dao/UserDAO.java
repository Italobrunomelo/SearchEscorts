package com.mobileprogramming.luxurygirl.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.mobileprogramming.luxurygirl.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by italo on 27/05/2017.
 */

public class UserDAO extends SQLiteOpenHelper {

    public UserDAO(Context context) {
        super(context, "dbUsers", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE User (email TEXT NOT NULL,password TEXT NOT NULL);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS User;";
        db.execSQL(sql);
        onCreate(db);
    }

    //INSERT
    public void insert(User user) {
        String sql = "INSERT INTO User (email,password) VALUES ('" + user.getmEmail() + "','"+ user.getmPassword()+"');";
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(sql);
        db.close();
    }

    //DELETE
    public void delete(User user) {
        String sql = "DELETE FROM User WHERE email = '" + user.getmEmail() + "';";
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(sql);
        db.close();
    }

    //GetUser
    public User getUser(String nEmail) {
        String sql = "SELECT * FROM User WHERE email = '" + nEmail + "';";
        SQLiteDatabase sqLiteDb = getReadableDatabase();
        Cursor cursor = sqLiteDb.rawQuery(sql, null);
        User user = new User();
        user.setmEmail(cursor.getString(cursor.getColumnIndex("email")));

        sqLiteDb.close();

        return user;
    }
}
