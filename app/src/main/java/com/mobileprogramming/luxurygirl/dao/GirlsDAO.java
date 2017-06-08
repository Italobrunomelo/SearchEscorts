package com.mobileprogramming.luxurygirl.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.mobileprogramming.luxurygirl.model.Girls;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by italo on 17/05/2017.
 */

public class GirlsDAO extends SQLiteOpenHelper {

    public GirlsDAO(Context context) {
        super(context, "dbLuxuryGirls", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE Girls (name TEXT NOT NULL, age TEXT NOT NULL, information TEXT NOT NULL, " +
                "contact TEXT NOT NULL, location TEXT NOT NULL, status TEXT NOT NULL);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS Girls;";
        db.execSQL(sql);
        onCreate(db);
    }

    //INSERT
    public void insert(Girls girls){
        String sql = "INSERT INTO Girls (name,age,information,contact,location,status) " +
                "VALUES ('" + girls.getmName()+"','"+ girls.getmAge()+"','"+ girls.getmInformation()+"','"+ girls.getmContact()+"','"+ girls.getmLocation()+"','"+ girls.getmStatus()+"');";
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(sql);
        db.close();
    }

    //GetAllEscort
    public List<Girls> getAllGirls(){
        String sql = "SELECT * FROM Girls;";
        SQLiteDatabase sqLiteDb = getReadableDatabase();
        Cursor cursor = sqLiteDb.rawQuery(sql, null);
        List<Girls> girl = new ArrayList<Girls>();

        while(cursor.moveToNext()){
            Girls girls = new Girls();
            girls.setmName(cursor.getString(cursor.getColumnIndex("name")));
            girls.setmAge(cursor.getString(cursor.getColumnIndex("age")));
            girls.setmInformation(cursor.getString(cursor.getColumnIndex("information")));
            girls.setmContact(cursor.getString(cursor.getColumnIndex("contact")));
            girls.setmLocation(cursor.getString(cursor.getColumnIndex("location")));
            girls.setmStatus(cursor.getString(cursor.getColumnIndex("status")));
            girl.add(girls);
        }

        sqLiteDb.close();

        return girl;
    }
}