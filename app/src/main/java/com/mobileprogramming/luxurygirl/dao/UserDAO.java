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
        super(context, "Search Girls", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE User (email TEXT NOT NULL);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS User;";
        db.execSQL(sql);
        onCreate(db);
    }

    //INSERT
    public void insert(User user){
        String sql = "INSERT INTO User (email) VALUES ('" + user.getmEmail()+"');";
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(sql);
        db.close();
    }

    //GetAllUser
    public List<User> getAllUser(){
        String sql = "SELECT * FROM User;";
        SQLiteDatabase sqLiteDb = getReadableDatabase();
        Cursor cursor = sqLiteDb.rawQuery(sql, null);
        List<User> users = new ArrayList<User>();

        while(cursor.moveToNext()){
            User user = new User();
            user.setmEmail(cursor.getString(cursor.getColumnIndex("email")));
            users.add(user);
        }

        sqLiteDb.close();

        return users;
    }
}
